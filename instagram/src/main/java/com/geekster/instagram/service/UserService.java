package com.geekster.instagram.service;

import com.geekster.instagram.dao.UserRepository;
import com.geekster.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public Integer saveUser(User user) {
        User userObj = userRepository.save(user);
        return userObj.getUserId();
    }

    public List<User> getUser(Integer userId) {
        List<User> userList = new ArrayList<>();
        if(null!=userId){
            User user = userRepository.getById(userId);
            userList.add(user);
        }else {
            userList = userRepository.findAll();
        }
        return userList;
    }
}