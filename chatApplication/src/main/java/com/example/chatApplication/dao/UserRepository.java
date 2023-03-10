package com.example.chatApplication.dao;

import com.example.chatApplication.model.Status;
import com.example.chatApplication.model.Users;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query(value = "Select * from tbl_user where username = :username and status_id = 1", nativeQuery = true )
    public List<Users> findByUserName(String username);

    @Query(value = "select * from tbl_user where user_id = :userId and status_id = 1",nativeQuery = true)
    public List<Users> findByUserId(Integer userId);

    @Query(value = "select * from tbl_user where status_id = 1",nativeQuery = true)
    public List<Users> findAllUsers();

    @Query(value = "Select * from tbl_user where email = :email and status_id = 1", nativeQuery = true )
    public List<Users> findUserByEmail(String email);

    @Query(value = "Select * from tbl_user where password = :password and status_id = 1", nativeQuery = true )
    List<Users> findUserByPassword(String password);

    @Modifying
    @Transactional
    @Query(value = "update tbl_user set status_id=2 where user_id= :userId",
            countQuery = "Select count(*) from tbl_user",nativeQuery = true)
    public void deleteUserByUserId(@PathParam("userId") int userId);
}