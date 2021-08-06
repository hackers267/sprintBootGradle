package com.silence.realworldspring.controllers;

import com.silence.realworldspring.persistent.entity.User;
import com.silence.realworldspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired UserService userService;

    @PostMapping("users")
    public boolean register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("users/login")
    public boolean login(@RequestBody User user){
        return userService.login(user);
    }

}
