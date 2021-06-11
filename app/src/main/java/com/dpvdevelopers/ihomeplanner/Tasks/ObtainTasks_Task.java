package com.dpvdevelopers.ihomeplanner.Tasks;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Models.TaskDB;

import java.util.ArrayList;

public class ObtainTasks_Task implements java.util.concurrent.Callable<ArrayList<Task>> {

    @Override
    public ArrayList<Task> call() throws Exception {
        ArrayList<Task> pais = TaskDB.obtainTasks();
        return pais;
    }
}
