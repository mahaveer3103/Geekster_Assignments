package com.example.userManagementSystem.service;

import com.example.userManagementSystem.controller.UMController;
import com.example.userManagementSystem.model.UserManagement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UMService {

    List<UserManagement> list = new ArrayList<>();

    public void addUser(UserManagement userManagement) {
        list.add(userManagement);
    }

    public List<UserManagement> getAllUser() {
        return list;
    }

    public UserManagement getUser(int userid) {
        for(int i=0;i<list.size();i++){
            UserManagement userManagement = list.get(i);
            if(userManagement.getUserId()==userid){
                return userManagement;
            }
        }
        return null;
    }

    public void updateUser(int UserId, UserManagement newUser) {
        UserManagement um = getUser(UserId);

        um.setUserId(newUser.getUserId());
        um.setUsername(newUser.getUsername());
        um.setAddress(newUser.getAddress());
        um.setName(newUser.getName());
        um.setPhoneNo(newUser.getPhoneNo());
    }

    public void deleteUser(int userId) {
        UserManagement um = getUser(userId);
        list.remove(um);
    }
}
