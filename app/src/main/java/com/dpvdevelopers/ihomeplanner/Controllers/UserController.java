package com.dpvdevelopers.ihomeplanner.Controllers;

import android.content.Context;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Classes.User;
import com.dpvdevelopers.ihomeplanner.Models.UserDB;
import com.dpvdevelopers.ihomeplanner.Tasks.CreateUser_Task;
import com.dpvdevelopers.ihomeplanner.Tasks.InsertTask_Task;
import com.dpvdevelopers.ihomeplanner.Tasks.ObtainTask_Task;
import com.dpvdevelopers.ihomeplanner.Tasks.ObtainUser_Task;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class UserController {
    public static String getUserId(String email){
        return "";
    }
    public static User getUser(String email){
        User user = null;
        FutureTask t = new FutureTask (new ObtainUser_Task(email));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            user =  (User) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static Boolean createUser(FirebaseUser user, String pass, Context context){
        FutureTask t = new FutureTask(new CreateUser_Task(user, pass, context));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insertOK = false;
        try {
            insertOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insertOK;
        }
    }
}
