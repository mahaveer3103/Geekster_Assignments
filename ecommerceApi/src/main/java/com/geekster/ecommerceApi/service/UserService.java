package com.geekster.ecommerceApi.service;

import com.geekster.ecommerceApi.dao.UserRepository;
import com.geekster.ecommerceApi.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User getUser(int userId) {

        return userRepository.findById(userId).get();
    }
}
