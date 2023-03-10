package com.example.chatApplication.controller;

import com.example.chatApplication.dao.StatusRepository;
import com.example.chatApplication.dao.UserRepository;
import com.example.chatApplication.model.ChatHistory;
import com.example.chatApplication.model.Status;
import com.example.chatApplication.model.Users;
import com.example.chatApplication.service.ChatHistoryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


@RestController
@RequestMapping(value = "/api/v1/chat")
public class ChatHistoryController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    ChatHistoryService chatHistoryService;

    @PostMapping("/send-message")
    public ResponseEntity<String> saveMessage(@RequestBody String requestData){
        JSONObject requestObj = new JSONObject(requestData);
        JSONObject errorList = validateRequest(requestObj);
        if(errorList.isEmpty()){
            ChatHistory chat = setChatHistory(requestObj);
            int chatId = chatHistoryService.saveMessage(chat);
            return new ResponseEntity<>("message sent - "+chatId,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-chat")
    public ResponseEntity<String> getChatsByUserId(@RequestParam int senderId) {
        JSONObject response = chatHistoryService.getChatsByUserId(senderId);
        return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-conversation")
    public ResponseEntity<String> getConversationBetweenTwoUsers(@RequestParam int user1,@RequestParam int user2) {
        JSONObject response = chatHistoryService.getConversation(user1, user2);
        return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-chat/{chatId}")
    public ResponseEntity<String> deleteChat(@PathVariable int chatId){
         ResponseEntity<String> response = chatHistoryService.deleteChat(chatId);
         return response;
    }

    private ChatHistory setChatHistory(JSONObject requestObj) {
        ChatHistory chat = new ChatHistory();
        chat.setMessage(requestObj.getString("message"));
        Integer senderId = requestObj.getInt("sender");
        Integer receiverId = requestObj.getInt("receiver");
        Users sender = userRepository.findById(senderId).get();
        Users receiver = userRepository.findById(receiverId).get();

        chat.setReceiver(receiver);
        chat.setSender(sender);

        Status status = statusRepository.findById(1).get();
        chat.setStatusId(status);

        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        chat.setCreatedDate(createdDate);

        return chat;
    }

    private JSONObject validateRequest(JSONObject requestData) {
        JSONObject errorList = new JSONObject();
        if(!requestData.has("sender")){
            errorList.put("sender","missing parameter");
        }
        if(!requestData.has("receiver")){
            errorList.put("receiver","missing parameter");
        }
        if(requestData.has("message")){
            String message = requestData.getString("message");
            if(message.isBlank() || message.isEmpty()){
                errorList.put("message","message can't be empty");
            }
        }else{
            errorList.put("message","missing parameter");
        }
        return errorList;
    }
}
