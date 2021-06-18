package com.dpvdevelopers.ihomeplanner.Tasks;

import android.os.Build;

import androidx.annotation.RequiresApi;
import com.dpvdevelopers.ihomeplanner.Classes.User;
import com.dpvdevelopers.ihomeplanner.Models.UserDB;
import java.util.concurrent.Callable;

public class InsertUser_Task implements Callable<Boolean> {
    private User receivedUser = null;


    public InsertUser_Task(User receivedUser) {
        this.receivedUser = receivedUser;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = UserDB.insertUser(receivedUser);
        return insertadoOK;
    }

}
