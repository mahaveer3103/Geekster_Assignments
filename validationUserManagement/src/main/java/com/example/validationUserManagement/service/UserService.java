package com.example.validationUserManagement.service;

import com.example.validationUserManagement.dao.UserRepository;
import com.example.validationUserManagement.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void addUser(User newUser) {
        userRepository.save(newUser);
    }

//    public List<User> getAllUser() {
//        return userRepository.findAll();
//    }

    public List<User> getUser(String userId) {
        List<User> userList = new ArrayList<>();
        if(null!=userId){
            userList.add(userRepository.findById(Integer.valueOf(userId)).get());
        }else{
            userList = userRepository.findAll();
        }
        return userList;
    }

    public ResponseEntity<String> updateUser(String newUser, Integer userId) {
        try{
            User oldUser = userRepository.findById(userId).get();
            JSONObject json = new JSONObject(newUser);
            oldUser.setUserName(json.getString("userName"));
            oldUser.setDateOfBirth(json.getString("dateOfBirth"));
            oldUser.setEmail(json.getString("email"));
            oldUser.setPhoneNumber(json.getString("phoneNumber"));
            oldUser.setDate(json.getString("date"));
            oldUser.setTime(json.getString("time"));
            userRepository.save(oldUser);
            return new ResponseEntity<>("Updated Successfully", HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.toString(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteUser(Integer userId) {
        try {
            User deleteUser = userRepository.findById(userId).get();
            userRepository.delete(deleteUser);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.toString(),HttpStatus.BAD_REQUEST);
        }
    }
}
