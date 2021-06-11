package com.dpvdevelopers.ihomeplanner.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.dpvdevelopers.ihomeplanner.Classes.Task;

import java.util.ArrayList;

public class TaskDB {
    public static boolean insertTaskDB(Task receivedTask) {
        return false;
    }

    public static ArrayList<Task> obtainTasks() {
        return new ArrayList<Task>();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Task obtainTask(String taskTitle) {
        return new Task();
    }

    public static Boolean removeTask(Task receivedTask) {
        return false;
    }

    public static Boolean updateTask(Task t) {
        return false;
    }


//--------------------------------------------------------------
}
