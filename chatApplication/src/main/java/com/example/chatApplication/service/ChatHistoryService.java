package com.example.chatApplication.service;

import com.example.chatApplication.dao.ChatRepository;
import com.example.chatApplication.dao.UserRepository;
import com.example.chatApplication.model.ChatHistory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatHistoryService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserRepository userRepository;

    public int saveMessage(ChatHistory chat) {
        return chatRepository.save(chat).getChatId();
    }

    public JSONObject getChatsByUserId(int senderId) {
        List<ChatHistory> chatList = chatRepository.getChatsByUserId(senderId);
        JSONObject response = new JSONObject();

        if(!chatList.isEmpty()) {
            response.put("senderId" , chatList.get(0).getSender().getUserId());
            response.put("senderName" , chatList.get(0).getSender().getFirstname());
            JSONArray receivers = new JSONArray();
            for (ChatHistory chats: chatList) {
                JSONObject receiverObj = new JSONObject();
                receiverObj.put("receiverId" , chats.getReceiver().getUserId());
                receiverObj.put("receiverName" , chats.getReceiver().getFirstname());
                receiverObj.put("message" , chats.getMessage());
                receivers.put(receiverObj);
            }
            response.put("receivers", receivers);
        }else {
            response.put(userRepository.findById(senderId).get().getFirstname(),"No message sent yet!");
        }
        return response;
    }

    public JSONObject getConversation(int user1, int user2) {
        JSONObject jsonObject = new JSONObject();
        JSONArray conversations = new JSONArray();
        List<ChatHistory> chatHistoryList = chatRepository.getConversation(user1,user2);

        for(ChatHistory chat:chatHistoryList){
            JSONObject messageObj = new JSONObject();
            messageObj.put("chatId",chat.getChatId());
            messageObj.put("senderName",chat.getSender().getFirstname());
            messageObj.put("timeStamp",chat.getCreatedDate());
            messageObj.put("message",chat.getMessage());
            conversations.put(messageObj);
        }
        jsonObject.put("conversation",conversations);
        return jsonObject;
    }

    public ResponseEntity<String> deleteChat(int chatId) {
        if(chatRepository.findById(chatId).isPresent()){
            chatRepository.deleteChatById(chatId);
            return new ResponseEntity<>("chat deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid chat-id",HttpStatus.BAD_REQUEST);
    }
}
