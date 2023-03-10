package com.geekster.instagram.dao;

import com.geekster.instagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

//    List<Post> findPostByUserId(Integer userId);
}

