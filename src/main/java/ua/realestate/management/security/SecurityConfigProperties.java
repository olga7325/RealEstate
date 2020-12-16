package ua.realestate.management.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwtconf")
public class SecurityConfigProperties {
    private Long accessExpirationTime;
    private Long refreshExpirationTime;
    private String tokenPrefix;
    private String header;
    private String signUpUrl;
    private String signInUrl;
    private String refreshTokensUrl;
    private String locationUrl;
    private String restoreUrl;
    private String rulesUrl;
    private String restorePasswordUrl;
    private String resendRegistrationToken;
    private String confirmRegistrationUrl;
}
