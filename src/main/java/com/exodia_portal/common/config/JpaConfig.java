package com.exodia_portal.common.config;

import com.exodia_portal.common.service.UserAuditorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "userAuditorService")
public class JpaConfig {
    private final UserAuditorService userAuditorService;

    public JpaConfig(UserAuditorService userAuditorService) {
        this.userAuditorService = userAuditorService;
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return userAuditorService::getCurrentAuditor;
    }
}
