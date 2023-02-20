package com.geekster.ecommerceApi.controller;

import com.geekster.ecommerceApi.model.User;
import com.geekster.ecommerceApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userId")
    public User getUser(@RequestParam int userId){
        return userService.getUser(userId);
    }
}
