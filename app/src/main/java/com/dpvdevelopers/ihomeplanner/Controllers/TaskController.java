package com.dpvdevelopers.ihomeplanner.Controllers;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Tasks.InsertTask_Task;
import com.dpvdevelopers.ihomeplanner.Tasks.ObtainTask_Task;
import com.dpvdevelopers.ihomeplanner.Tasks.ObtainTasks_Task;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TaskController {
    public static boolean insertTask(Task receivedTask)
    {
        FutureTask t = new FutureTask(new InsertTask_Task(receivedTask));
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

    public static ArrayList<Task> obtainTasks() {
        ArrayList<Task> returnedTasks = null;
        FutureTask t = new FutureTask (new ObtainTasks_Task());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            returnedTasks= (ArrayList<Task>)t.get();
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
        return returnedTasks;
    }

    public static Task obtainTask(String taskTitle){
        Task task = null;
        FutureTask t = new FutureTask (new ObtainTask_Task(taskTitle));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            task =  (Task) t.get();
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
        return task;
    }
    public static boolean removeTask(Task receivedTask)
    {
        FutureTask t = new FutureTask(new removeTask_Task(receivedTask));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
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
            return borradoOK;
        }
    }

    public static boolean updateTask(Task receivedTask) {
        FutureTask t = new FutureTask(new UpdateTask_Task(receivedTask));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean updatedOK = false;
        try {
            updatedOK = (boolean) t.get();
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
            return updatedOK;
        }
    }
}
