package ua.realestate.management.security;

import io.jsonwebtoken.Jwts;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.repository.UserRepository;
import ua.realestate.management.security.entity.SecurityUserEntity;

import java.util.Date;

import static ua.realestate.management.exception.ErrorMessage.USER_NOT_FOUND_BY_EMAIL;

@Slf4j
@Component
@AllArgsConstructor
public class JwtTokenProvider {
    private final UserRepository userRepository;
    private final SecurityConfigProperties securityConfigProperties;

    public String generateAccessToken(Authentication authentication){
        return this.generateAccessToken(((SecurityUserEntity) authentication.getPrincipal()).getUsername());
    }

    public String generateAccessToken(String email){
        Date expireDate = new Date(new Date().getTime() + securityConfigProperties.getAccessExpirationTime());
        log.info("Access Token for " + email + " created.");
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .compact();
    }

    public String generateRefreshToken(Authentication authentication){
        return this.generateRefreshToken(((SecurityUserEntity) authentication.getPrincipal()).getUsername());
    }

    public String generateRefreshToken(String email){
        UserEntity user = userRepository.findByEmail(email);
        Date expireDate = new Date(new Date().getTime() + securityConfigProperties.getRefreshExpirationTime());
        log.info("Access Token for " + email + " created.");
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .compact();
    }
}
