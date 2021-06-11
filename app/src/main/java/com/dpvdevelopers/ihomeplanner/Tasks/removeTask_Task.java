package com.dpvdevelopers.ihomeplanner.Tasks;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Models.TaskDB;

import java.util.concurrent.Callable;

public class removeTask_Task implements Callable<Boolean> {
    Task receivedTask;
    public removeTask_Task(Task receivedTask) {
        this.receivedTask = receivedTask;
    }

    @Override
    public Boolean call() throws Exception {
        return TaskDB.removeTask(receivedTask);
    }
}
