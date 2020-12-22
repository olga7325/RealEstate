package ua.realestate.management.security;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JWTSuccessLogIn {
    private Integer userId;
    private String accessToken;
    private String refreshToken;
    private String name;

    public JWTSuccessLogIn(Integer id, String generateAccessToken, String generateRefreshToken, String name) {
    }
}
