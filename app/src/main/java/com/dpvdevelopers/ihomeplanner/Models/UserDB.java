package com.dpvdevelopers.ihomeplanner.Models;

import com.dpvdevelopers.ihomeplanner.Classes.User;

public class UserDB {
    public static String getUserId(String email){
        return "";
    }

    public static User getUser(String email) {
        return new User(1234, 1, 123456, "nombre", "apellido", "correo@falso.com", 0006);
    }
}
