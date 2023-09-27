package com.jason.controllers;

import com.jason.models.UserEntity;
import com.jason.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> allUsers() {
        return userService.returnAllUsers();
    }

    @PostMapping
    public ResponseEntity<String> newUser(@RequestBody UserEntity newUser) {
        return userService.saveUserEntity(newUser);
    }

}
