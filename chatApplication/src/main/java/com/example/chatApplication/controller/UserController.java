package com.example.chatApplication.controller;

import com.example.chatApplication.dao.StatusRepository;
import com.example.chatApplication.dao.UserRepository;
import com.example.chatApplication.model.Status;
import com.example.chatApplication.model.Users;
import com.example.chatApplication.service.StatusService;
import com.example.chatApplication.service.UserService;
import com.example.chatApplication.util.CommonUtils;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;



@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/create-user")
    public ResponseEntity<String> createUser(@RequestBody String userData){

        JSONObject isValid = validateUserRequest(userData);

        Users user = null;

        if(isValid.isEmpty()) {
            user = setUser(userData);
            int userId= userService.save(user);
            return new ResponseEntity<String>("Saved with id - "+userId, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<String>(isValid.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-user")
    public ResponseEntity<String> getUser(@Nullable @RequestParam String userId){
        JSONArray userList = userService.getUser(userId);
        return new ResponseEntity<>(userList.toString(),HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody String loginDetails){
//        JSONObject requestJson = new JSONObject(loginDetails);
//        JSONObject isValid = validateLogin(loginDetails);
//        if(isValid.isEmpty()){
//            String username_email = requestJson.getString("email/username");
//            String password = requestJson.getString("password");
//            JSONObject responseJson = userService.loginUser(username_email,password);
//            if(responseJson.has("Invalid parameter : ")){
//                return new ResponseEntity<String>(responseJson.toString(), HttpStatus.BAD_REQUEST);
//            }else {
//                return new ResponseEntity<String>(responseJson.toString(), HttpStatus.OK);
//            }
//        }else {
//            return new ResponseEntity<String>(isValid.toString(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody String loginDetails){
        JSONObject jsonObject = new JSONObject(loginDetails);
        JSONObject isValid = validateLogin(jsonObject);

        if(isValid.isEmpty()){
            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");
            JSONObject response = userService.loginUser(username,password);
            if(response.has("errorMessage")){
                return new ResponseEntity<>(response.toString(),HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<>(response.toString(),HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>(isValid.toString(),HttpStatus.BAD_REQUEST);
        }
    }

    private JSONObject validateLogin(JSONObject jsonObject) {
        JSONObject errorList = new JSONObject();
        if(!jsonObject.has("username")){
            errorList.put("username","missing parameter");
        }
        if(!jsonObject.has("password")){
            errorList.put("password","missing parameter");
        }
        return errorList;
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody String requestUser,@PathVariable Integer userId){
        JSONObject isValid = validateUserRequest(requestUser);
        Users user = null;
        if(isValid.isEmpty()) {
            user = setUser(requestUser);
            JSONObject responseObj = userService.updateUser(user, userId);
            if(responseObj.has("errorMessage")) {
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<String>(isValid.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("user updated", HttpStatus.OK);
    }

    @DeleteMapping("delete-user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }

//    private JSONObject validateLogin(String loginDetails) {
//        JSONObject loginJson = new JSONObject(loginDetails);
//        JSONObject errorList = new JSONObject();
//        if(!loginJson.has("email/username")){
//            errorList.put("email/username","Missing parameter");
//        }
//        if(!loginJson.has("password")) {
//            errorList.put("password", "Missing parameter");
//        }
//        return errorList;
//    }



    private JSONObject validateUserRequest(String userData) {
        JSONObject userJson = new JSONObject(userData);
        JSONObject errorList = new JSONObject();

        if(userJson.has("username")){
            String username = userJson.getString("username");
            if(!userJson.has("isUpdate")) {
                List<Users> usersList = userRepository.findByUserName(username);
                if (usersList.size() > 0) {
                    errorList.put("username", "This username already exist");
                    return errorList;
                }
            }
        }else {
            errorList.put("username","Missing parameter");
        }

        if(!userJson.has("isUpdate")) {
            if (userJson.has("password")) {
                String password = userJson.getString("password");
                if (!CommonUtils.isValidPassword(password)) {
                    errorList.put("password", "Please enter valid password eg: User@123");
                }
            } else {
                errorList.put("password", "Missing parameter");
            }
        }

        if(userJson.has("firstName")){
            String firstName = userJson.getString("firstName");
        }else {
            errorList.put("firstName","Missing parameter");
        }

        if(userJson.has("email")){
            String email = userJson.getString("email");
            if(!CommonUtils.isValidEmail(email)){
                errorList.put("email","Please enter valid email");
            }
        }else {
            errorList.put("email","Missing parameter");
        }

        if(userJson.has("phoneNumber")){
            String phoneNumber = userJson.getString("phoneNumber");
            if(!CommonUtils.isValidPhoneNumber(phoneNumber)){
                errorList.put("phoneNumber","Please enter valid phone number");
            }
        }else {
            errorList.put("phoneNumber","Missing parameter");
        }

        return errorList;
    }

    private Users setUser(String userData) {
        Users user = new Users();
        JSONObject json = new JSONObject(userData);

        user.setEmail(json.getString("email"));
        if(!json.has("isUpdate")) {
            user.setPassword(json.getString("password"));
        }
        user.setFirstname(json.getString("firstName"));
        user.setUsername(json.getString("username"));
        user.setPhoneNumber(json.getString("phoneNumber"));
        if(json.has("lastName")) {
            user.setLastname(json.getString("lastName"));
        }
        if(json.has("age")) {
            user.setAge(json.getInt("age"));
        }
        if(json.has("gender")) {
            user.setGender(json.getString("gender"));
        }

        Timestamp createdTime = new Timestamp(System.currentTimeMillis());
        user.setCreatedDate(createdTime);

        Status status = statusRepository.findById(1).get();
        user.setStatusId(status);

        return user;
    }
}
