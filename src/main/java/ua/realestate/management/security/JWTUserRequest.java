package ua.realestate.management.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class JWTUserRequest {
    @Email
    private String email;
    @Size(min = 8)
    private String password;
}
