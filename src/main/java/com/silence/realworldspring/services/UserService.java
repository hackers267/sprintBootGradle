package com.silence.realworldspring.services;

import com.silence.realworldspring.persistent.entity.User;
import com.silence.realworldspring.persistent.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserServiceImpl userService;
    public boolean login(User user){
        return true;
    }

    public boolean register(User user){
        return true;
    }


}
