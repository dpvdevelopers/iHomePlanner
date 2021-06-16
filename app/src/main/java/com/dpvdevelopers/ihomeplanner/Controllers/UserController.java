package com.dpvdevelopers.ihomeplanner.Controllers;

import com.dpvdevelopers.ihomeplanner.Classes.User;
import com.dpvdevelopers.ihomeplanner.Models.UserDB;

public class UserController {
    public static String getUserId(String email){
        return UserDB.getUserId(email);
    }
    public static User getUser(String email){
        return UserDB.getUser(email);
    }
}
