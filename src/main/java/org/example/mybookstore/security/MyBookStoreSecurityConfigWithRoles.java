package org.example.mybookstore.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@Profile("roles")
public class MyBookStoreSecurityConfigWithRoles {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http,
                                    CustomOidcUserService customOidcUserService) throws Exception {
        System.out.println("Injected CustomOidcUserService: " + customOidcUserService);

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/css/**", "/js/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/books").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/books").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ) .exceptionHandling(ex -> ex
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            response.setContentType("application/json");
                            response.getWriter().write("{\"error\": \"You don’t have permission to access this resource.\"}");
                        })
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(u -> u.oidcUserService(customOidcUserService))
                        .defaultSuccessUrl("/dashboard", true)

                );

        return http.build();
    }
}
