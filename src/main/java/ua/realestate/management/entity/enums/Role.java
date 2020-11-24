package ua.realestate.management.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    BASIC_USER,
    MODERATOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
