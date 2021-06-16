package com.dpvdevelopers.ihomeplanner.Tasks;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Classes.User;
import com.dpvdevelopers.ihomeplanner.Models.TaskDB;
import com.dpvdevelopers.ihomeplanner.Models.UserDB;

import java.util.concurrent.Callable;

public class ObtainUser_Task implements Callable<User> {
    private String userMail;
    public ObtainUser_Task(String userMail) {
        this.userMail = userMail;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public User call() throws Exception {
        User user = UserDB.getUser(userMail);
        return user;
    }
}
