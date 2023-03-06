package com.geekster.instagram.service;

import com.geekster.instagram.dao.PostRepository;
import com.geekster.instagram.dao.UserRepository;
import com.geekster.instagram.model.Post;
import com.geekster.instagram.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PostService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    public void savePost(Post post){
        postRepository.save(post);
    }

    public JSONArray getPost(String postId, String userId) {
        JSONArray postArray = new JSONArray();
        List<Post> list;
        if(postId!=null && postRepository.findById(Integer.valueOf(postId)).isPresent()){
            Post post = postRepository.findById(Integer.valueOf(postId)).get();
            JSONObject jsonObject = setJson(post);
            postArray.put(jsonObject);
            return postArray;
        }else if(userId!=null && userRepository.findById(Integer.valueOf(userId)).isPresent()){
            list = postRepository.findAll();
            for (Post post : list) {
                if (post.getUser().getUserId() == Integer.valueOf(userId)) {
                    JSONObject jsonObject = setJson(post);
                    postArray.put(jsonObject);
                }
            }
            return postArray;
        }
        list = postRepository.findAll();
        for (Post post : list) {
            JSONObject jsonObject = setJson(post);
                postArray.put(jsonObject);
        }
        return postArray;
    }

    public JSONObject setJson(Post post){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("postId",post.getPostId());
        jsonObject.put("createdDate",post.getCreatedDate());
        jsonObject.put("updateDated",post.getUpdateDate());
        jsonObject.put("postData",post.getPostData());
        User user = post.getUser();
        jsonObject.put("userId",user.getUserId());
        jsonObject.put("username",user.getFirstName());
        return jsonObject;
    }

    public void updatePost(Integer postId, Post updatedPost) {

        if(postRepository.findById(postId).isPresent()){
            Post olderPost = postRepository.findById(postId).get();
            olderPost.setUser(updatedPost.getUser());
            olderPost.setPostData(updatedPost.getPostData());
            Timestamp updatedDate = new Timestamp(System.currentTimeMillis());
            olderPost.setUpdateDate(updatedDate);
            postRepository.save(olderPost);
        }
    }
}
