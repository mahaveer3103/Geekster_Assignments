package com.geekster.instagram.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/post")
    public ResponseEntity<String> savePost(){
        return null;
    }
}
