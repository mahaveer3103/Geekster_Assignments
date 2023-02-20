package com.example.validationUserManagement.utils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;

public class CommonUtils {
    public static List<String> validatorUser(String user){

        List<String> errorList = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(user);
        if(!validateUserName(jsonObject.getString("userName"))){
            errorList.add("userName");
        }
        if(!validateDOB(jsonObject.getString("dateOfBirth"))){
            errorList.add("dateOfBirth");
        }
        if(!validateEmail(jsonObject.getString("email"))){
            errorList.add("email");
        }
        if(!validatePhoneNumber(jsonObject.getString("phoneNumber"))){
            errorList.add("phoneNumber");
        }
        return errorList;
    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length()!=12){
            return false;
        }else{
            for(char ch:phoneNumber.toCharArray()){
                if(!(ch>=48 && ch<=57)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    private static boolean validateDOB(String dateOfBirth) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        return dateOfBirth.matches(regex);
    }


    private static boolean validateUserName(String userName) {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (userName == null) {
            return false;
        }
        Matcher m = p.matcher(userName);
        return m.matches();
    }
}
