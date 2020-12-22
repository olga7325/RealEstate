package ua.realestate.management.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.realestate.management.entity.UserEntity;
import ua.realestate.management.entity.UserRole;

import java.util.Collection;

@AllArgsConstructor
@Data
public class SecurityUserEntity implements UserDetails {
    private Integer id;

    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private Boolean isActive;

    private UserRole userRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public static SecurityUserEntity create(UserEntity user) {

        return new SecurityUserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getIsActive(),
                user.getUserRole());
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isActive;
    }
}
