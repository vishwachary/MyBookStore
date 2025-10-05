package org.example.mybookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("dev")
public class MyBookStoreSecurityConfig {

    /**
     *
     * @param http
     * @return
     * @throws Exception
     * Every HTTP request that is not explicitly permitted (like /, /css/**, /js/**) requires authentication.
     * So yes — /api/v1/books is not allowed unless the user is authenticated.
     *
     * The second part
     * .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/dashboard", true));
     * .oauth2Login(...)
     * Tells Spring Security:     *
     * When an unauthenticated user tries to access a protected endpoint (e.g. /api/v1/books or /dashboard),
     * instead of returning immediately with 401, Spring Security will redirect them to the OAuth2 login page.
     * Since you configured Google in application.yml/properties,
     * Spring knows to send them to Google’s login screen.
     *
     * .defaultSuccessUrl("/dashboard", true) Defines what happens after successful login:
     * Once Google authenticates the user, it sends the user back to your app.
     * Spring Security creates a session and stores the user details.     *
     * The user is then redirected to /dashboard.     *
     * The true flag means: always redirect to /dashboard (even if the user originally requested a different page).
     */

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        System.out.println("I am security filter for DEV NO ROLES");
         http.authorizeHttpRequests(
                 authorize ->
                         authorize
                                 .requestMatchers("/", "/css/**", "/js/**")
                                 .permitAll()
                                 .anyRequest().authenticated()
         ).oauth2Login(oauth2 ->oauth2.defaultSuccessUrl("/dashboard",true));
        return http.build();
    }
}
