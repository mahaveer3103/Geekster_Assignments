package com.geekster.instagram.controller;

import com.geekster.instagram.model.User;
import com.geekster.instagram.service.UserService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody String userData){
        User user = setUser(userData);
        int userId = userService.saveUser(user);
        return new ResponseEntity("user saved with id - "+ userId, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity getUser(@Nullable @RequestParam Integer userId){
        List<User> userList = userService.getUser(userId);
        return new ResponseEntity(userList,HttpStatus.OK);
    }

    private User setUser(String userData) {
        JSONObject json = new JSONObject(userData);
        User user = new User();
        user.setAge(json.getInt("age"));
        user.setEmailId(json.getString("email"));
        user.setFirstName(json.getString("firstname"));
        user.setLastName(json.getString("lastname"));
        user.setPhoneNo(json.getString("phone_no"));
        return user;
    }
}
