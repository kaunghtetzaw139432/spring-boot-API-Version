package com.example.apiversioning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiversioning.Repo.UserRepo;
import com.example.apiversioning.mapper.UserMapper;
import com.example.apiversioning.userDto.UserDTOv1;
import com.example.apiversioning.userDto.UserDTOv2;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final UserMapper userMapper;

    @GetMapping(value = "/{version}/users", version = "1.0")
    public List<UserDTOv1> findAll() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toV1)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{version}/users", version = "2.0")
    public List<UserDTOv2> findAllUserV2() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toV2)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/users", version = "1.1")
    public List<UserDTOv1> findAllUser() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toV1)
                .collect(Collectors.toList());
    }

}
