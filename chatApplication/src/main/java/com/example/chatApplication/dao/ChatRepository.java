package com.example.chatApplication.dao;

import com.example.chatApplication.model.ChatHistory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatHistory,Integer> {


    @Query(value = "select * from tbl_chat_history where sender_user_id= :senderId and status_id=1",nativeQuery = true)
    List<ChatHistory> getChatsByUserId(int senderId);

    @Query(value = "Select * from tbl_chat_history where (sender_user_id = :user1 and receiver_user_id = :user2) or "+
            "(sender_user_id = :user2 and receiver_user_id = :user1) order by created_date",nativeQuery = true)
    List<ChatHistory> getConversation(int user1, int user2);

    @Modifying
    @Transactional
    @Query(value = "update tbl_chat_history set status_id=2 where chat_id=:chatId",
            countQuery = "Select count(*) from tbl_user",nativeQuery = true)
    void deleteChatById(int chatId);
}
