package com.geekster.instagram.controller;

import com.geekster.instagram.dao.UserRepository;
import com.geekster.instagram.model.Post;
import com.geekster.instagram.model.User;
import com.geekster.instagram.service.PostService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class PostController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService postService;

    @PostMapping("/post")
    public ResponseEntity<String> savePost(@RequestBody String postRequest){
        String savePost = "savePost";
        Post post = setPost(postRequest,savePost);
        postService.savePost(post);
        return new ResponseEntity<>("post saved successfully with postId - " + post.getPostId(), HttpStatus.CREATED);
    }

    @GetMapping("/post")
    public ResponseEntity<String> getPost(@Nullable @RequestParam String postId,@Nullable @RequestParam String userId){
        return new ResponseEntity<>(postService.getPost(postId,userId).toString(),HttpStatus.FOUND);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Integer postId,@RequestBody String postRequest){
        String updatePost = "updatePost";
        Post post = setPost(postRequest, updatePost);
        postService.updatePost(postId,post);
        return new ResponseEntity<>("Post Updated Successfully",HttpStatus.OK);
    }


    private Post setPost(String postRequest,String TypePost) {
        JSONObject json = new JSONObject(postRequest);
        User user = null;
        int userId = json.getInt("userId");
        if(userRepository.findById(userId).isPresent()){
            user = userRepository.findById(userId).get();
        }else {
            return null;
        }
        Post post = new Post();
        post.setPostData(json.getString("postData"));
        post.setUser(user);
        if(TypePost.equals("savePost")) {
            Timestamp createdDate = new Timestamp(System.currentTimeMillis());
            post.setCreatedDate(createdDate);
        }
        return post;
    }



}
