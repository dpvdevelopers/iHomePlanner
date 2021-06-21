package com.dpvdevelopers.ihomeplanner.Tasks;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Models.TaskDB;

import java.util.concurrent.Callable;

public class UpdateTask_Task implements Callable<Boolean> {
    private Task t;
    public UpdateTask_Task(Task receivedTask) {
        this.t = receivedTask;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Boolean call() throws Exception {
        return TaskDB.updateTask(t);
    }
}
