package com.example.userManagementSystem.controller;

import com.example.userManagementSystem.model.UserManagement;
import com.example.userManagementSystem.service.UMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-management-app")
public class UMController {
    @Autowired
    UMService umService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserManagement userManagement){
        umService.addUser(userManagement);
    }

    @GetMapping("/getAllUser")
    public List<UserManagement> getAllUser(){
        return umService.getAllUser();
    }

    @GetMapping("/getUser/{userid}")
    public UserManagement getUser(@PathVariable int userid){
        return umService.getUser(userid);
    }

    @PutMapping("/updateUserInfo/userId/{userId}")
    public void updateUser(@PathVariable int userId, @RequestBody UserManagement userManagement){
        umService.updateUser(userId,userManagement);
    }

    @DeleteMapping("/deleteUser/userId/{userId}")
    public void deleteUser(@PathVariable int userId){
        umService.deleteUser(userId);
    }
}
