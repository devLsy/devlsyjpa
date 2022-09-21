package com.devlsy.devlsyjpa.controller;

import com.devlsy.devlsyjpa.domain.UserDto;
import com.devlsy.devlsyjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     *  create member by userId
     */
    @PostMapping("/")
    public Long createMember(@RequestBody UserDto userDto) {
        return userService.createMember(userDto);
    }

    /**
     *  delete member by userId
     */
    @DeleteMapping("/")
    public void deleteMember(Long userId) {
        userService.deleteMember(userId);
    }

    /**
     * findOne member by userId
     */
    @GetMapping("/{userId}")
    public HashMap<String, Object> findOneMember(@PathVariable Long userId) {
        return userService.findOneMember(userId);
    }

    /**
     *  findAll member by userId
     */
    @GetMapping("/")
    public HashMap<String, Object> findAllMember() {
        return userService.findAllMember();
    }
}
