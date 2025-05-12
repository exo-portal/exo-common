package com.exodia_portal.common.service;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuditorService implements AuditorAware<String> {

    /**
     * Retrieves the username or ID of the currently authenticated user.
     *
     * @return The username or ID of the authenticated user, or "SYSTEM" if no user is authenticated.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof OAuth2User oAuth2User) {
            return Optional.ofNullable(oAuth2User.getAttribute("name"));
        } else if (authentication != null && authentication.getPrincipal() instanceof User userDetails) {
            // Handle email/password login
            return Optional.of(userDetails.getUsername());
        }

        return Optional.of("SYSTEM");
    }
}
