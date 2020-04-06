package com.kalkin.JUnitMockito.api.controller;

import com.kalkin.JUnitMockito.api.service.User;
import com.kalkin.JUnitMockito.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/save")
    public User userSave(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUserByAddress/{address}")
    public List<User> findUserByAddress(@PathVariable String user){
        return userService.getUserByAddress(user);
    }

    @DeleteMapping(value="/deleteUser")
    public User removeuser(@RequestBody User user){
        userService.deleteUser(user);
        return user;
    }



}
