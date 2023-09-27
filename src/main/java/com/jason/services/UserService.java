package com.jason.services;

import com.jason.models.UserEntity;
import com.jason.repos.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> returnAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<String> saveUserEntity(UserEntity userEntity){
        return respondOkWithValidatedSave(userEntity);
    }

    private ResponseEntity<String> respondOkWithValidatedSave(UserEntity userEntity) {
        userRepository.save(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created :" + userEntity);
    }

}
