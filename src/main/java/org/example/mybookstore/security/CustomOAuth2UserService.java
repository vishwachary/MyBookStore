package org.example.mybookstore.security;

import org.example.mybookstore.dto.UserDto;
import org.example.mybookstore.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Profile("roles")
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserService userService;

    public CustomOAuth2UserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauthUser = new DefaultOAuth2UserService().loadUser(userRequest);

        String email = oauthUser.getAttribute("email");

        UserDto user = userService.getUserByEmail(email);

        // map role to authority (Spring expects ROLE_ prefix)
        Collection<GrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority
                        ("ROLE_" + user.getRole()));

        return new DefaultOAuth2User(
                authorities,
                oauthUser.getAttributes(),
                "email" // unique attribute
        );
    }
}

