package com.dpvdevelopers.ihomeplanner.Tasks;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Models.TaskDB;

import java.util.concurrent.Callable;

public class InsertTask_Task implements Callable<Boolean> {
    private Task receivedTask = null;


    public InsertTask_Task(Task receivedTask) {
            this.receivedTask = receivedTask;
        }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = TaskDB.insertTaskDB(receivedTask);
        return insertadoOK;
    }

}
