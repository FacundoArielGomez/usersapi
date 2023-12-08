package com.usersapi.usersapi.StuctureResponse;

import com.usersapi.usersapi.Models.User;

import java.util.HashMap;
import java.util.List;

public class UserResponse {

    public static HashMap<String, List<User>> formateUserResponse (List<User> usersList){
    HashMap<String, List<User>> listOfUserResponse = new HashMap<>();
    listOfUserResponse.put("users", usersList);

    return listOfUserResponse;

    }

    public static HashMap<String, User> formateOneUserResponse(User user){
        HashMap<String,User> userResponse = new HashMap<>();

        userResponse.put("user: ", user);
        return userResponse;
    }

}
