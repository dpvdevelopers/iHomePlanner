package com.dpvdevelopers.ihomeplanner.Tasks;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.dpvdevelopers.ihomeplanner.Utils.Utils;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Callable;

public class CreateUser_Task implements Callable<Boolean> {
    FirebaseUser user;
    String pass;
    Context context;

    public CreateUser_Task(FirebaseUser user, String pass, Context context){
        this.user = user;
        this.pass = pass;
        this.context= context;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Boolean call() throws Exception {
        return Utils.createNewUser(user, pass, context);
    }
}
