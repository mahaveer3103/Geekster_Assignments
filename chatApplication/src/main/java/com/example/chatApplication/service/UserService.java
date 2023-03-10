package com.example.chatApplication.service;

import com.example.chatApplication.dao.UserRepository;
import com.example.chatApplication.model.Users;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int save(Users user) {
        Users userObj = userRepository.save(user);
        return userObj.getUserId();
    }

    public JSONArray getUser(String userId) {
        JSONArray response = new JSONArray();
        if(userId!=null){
            List<Users> users = userRepository.findByUserId(Integer.valueOf(userId));
            for (Users user : users){
                JSONObject jsonObject = setJson(user);
                response.put(jsonObject);
            }
        }else {
            List<Users> users = userRepository.findAllUsers();
            for (Users user : users){
                JSONObject jsonObject = setJson(user);
                response.put(jsonObject);
            }
        }
        return response;
    }

    public JSONObject setJson(Users user){
        JSONObject json = new JSONObject();
        json.put("user_id",user.getUserId());
        json.put("username",user.getUsername());
        json.put("email",user.getEmail());
        json.put("phone_number",user.getPhoneNumber());
        json.put("gender",user.getGender());
        json.put("first_name",user.getFirstname());
        json.put("age",user.getAge());
        json.put("created_date",user.getCreatedDate());
        return json;
    }

//    public JSONObject loginUser(String usernameEmail, String password) {
//        JSONObject errorList = new JSONObject();
//        if(!validatePassword(password)){
//            errorList.put("Invalid parameter : ","password");
//        }else {
//            if (validateEmailOrUsername(usernameEmail).isEmpty()) {
//                errorList.put("Invalid parameter : ", "username or email");
//            }
//            else {
//                return validateEmailOrUsername(usernameEmail);
//            }
//        }
//        return errorList;
//    }



    private boolean validatePassword(String password) {
        List<Users> passwordList = userRepository.findUserByPassword(password);
        return passwordList.size() > 0;
    }

    private JSONObject validateEmailOrUsername(String string) {
//        List<Users> usersList;
        JSONObject errorList ;
        JSONObject jsonObject;
        if(string.contains(".") ) {
            List<Users> user = userRepository.findUserByEmail(string);
            jsonObject = setJson(user.get(0));
        }else{
            Users user =userRepository.findByUserName(string).get(0);
            jsonObject = setJson(user);
        }
        return jsonObject;
    }

    public String checkMailOrUsername(String string){
        if(string.contains(".") ) {
            return "email";
        }
        return "username";
    }

    public void deleteUser(String id) {
        userRepository.deleteUserByUserId(Integer.valueOf(id));
    }

    public JSONObject loginUser(String username, String password) {
        JSONObject response = new JSONObject();
        List<Users> usersList = userRepository.findByUserName(username);
        if(usersList.isEmpty()){
            response.put("errorMessage","username doesn't exist!");
        }else {
            Users user = usersList.get(0);
            if(password.equals(user.getPassword())) {
                response = setJson(user);
            }else {
                response.put("errorMessage","Invalid password");
            }
        }
        return response;
    }

    public JSONObject updateUser(Users user, Integer userId) {
        List<Users> usersList = userRepository.findByUserId(userId);
        JSONObject obj = new JSONObject();
        if(!usersList.isEmpty()) {
            Users oldUser = usersList.get(0);
            user.setUserId(oldUser.getUserId());
            user.setCreatedDate(oldUser.getCreatedDate());
            user.setPassword(oldUser.getPassword());
            Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
            user.setUpdatedDate(updatedTime);
            userRepository.save(user);
        } else {
            obj.put("errorMessage" , "User doesn't exist");
        }
        return obj;
    }
}
