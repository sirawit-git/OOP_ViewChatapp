package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.CreateUser;
import org.example.backend.model.UserModel;
import org.example.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/add")
    public UUID addUser(@RequestBody CreateUser createUser) {
        return userRepository.addUser(createUser.getUserName());
    }
}