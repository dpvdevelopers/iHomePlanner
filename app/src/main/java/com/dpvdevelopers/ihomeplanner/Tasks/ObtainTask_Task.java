package com.dpvdevelopers.ihomeplanner.Tasks;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Models.TaskDB;

import java.util.concurrent.Callable;

public class ObtainTask_Task implements Callable<Task> {
    private String taskTitle;
    public ObtainTask_Task(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Task call() throws Exception {
        Task task = TaskDB.obtainTask(taskTitle);
        return task;
    }
}
