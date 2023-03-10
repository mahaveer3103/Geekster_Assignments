package com.example.validationUserManagement.controller;

import com.example.validationUserManagement.model.User;
import com.example.validationUserManagement.service.UserService;
import com.example.validationUserManagement.utils.CommonUtils;
import jakarta.annotation.Nullable;
import jakarta.websocket.server.PathParam;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody String user){

        List<String> user1 = CommonUtils.validatorUser(user);

        JSONObject json = new JSONObject(user);

        String[] answer = Arrays.copyOf(
                user1.toArray(), user1.size(), String[].class);

        if(user1.isEmpty()){
            User newUser = setUser(json);
            userService.addUser(newUser);
            return new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Please add appropriate mandatory parameters - "+Arrays.toString(answer),HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/getAllUser")
//    public List<User> getAllUser(){
//        return userService.getAllUser();
//    }

    @GetMapping("/getUser")
    public List<User> getUser(@Nullable @RequestParam String userId){

        return userService.getUser(userId);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody String user,@RequestParam Integer userId){
        List<String> user1 = CommonUtils.validatorUser(user);

        String[] answer = Arrays.copyOf(
                user1.toArray(), user1.size(), String[].class);

        if(user1.isEmpty()){
            return userService.updateUser(user,userId);
        }else {
            return new ResponseEntity<>("Please add appropriate mandatory parameters - "+Arrays.toString(answer),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam Integer userId){
        return userService.deleteUser(userId);
    }

    public User setUser(JSONObject json){
        User user = new User();
        user.setUserName(json.getString("userName"));
        user.setDateOfBirth(json.getString("dateOfBirth"));
        user.setEmail(json.getString("email"));
        user.setPhoneNumber(json.getString("phoneNumber"));
        if(json.has("date")) {
            user.setDate(json.getString("date"));
        }
        if(json.has("time")){
            user.setTime(json.getString("time"));
        }
        return user;
    }

}
