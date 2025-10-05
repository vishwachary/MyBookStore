package org.example.mybookstore.service;

import org.example.mybookstore.dto.BookDto;
import org.example.mybookstore.dto.UserDto;
import org.example.mybookstore.entity.Book;
import org.example.mybookstore.entity.User;
import org.example.mybookstore.repository.UserRepository;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserByEmail(String email) {
        UserDto user = convertToDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new OAuth2AuthenticationException("No local user mapped for email " + email)));

        return user;
    }


    private UserDto convertToDto(User user) {
        return UserDto.builder().id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole()).build();


    }
}
