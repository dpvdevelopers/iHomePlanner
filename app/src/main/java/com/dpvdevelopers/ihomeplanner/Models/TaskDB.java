package com.dpvdevelopers.ihomeplanner.Models;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.dpvdevelopers.ihomeplanner.Classes.Task;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class TaskDB {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean insertTaskDB(Task rT) {

        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO tasks (TaskUser, TaskTitle, TaskDetail, TaskDate, TaskEndDate, TaskFullDay, TaskDuration) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setDouble(1, rT.getUserId());
            pst.setString(2, rT.getTitle());
            pst.setString(3, rT.getDetail());
            pst.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(rT.getDate()));
            pst.setString( 5,new SimpleDateFormat("yyyy-MM-dd").format(rT.getEndTime()));
            pst.setBoolean( 6, rT.isFullDay());
            pst.setBigDecimal(7, rT.getDuration());
            int affectedRows = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(affectedRows > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static ArrayList<Task> obtainTasks() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Task> obtainedTasks = new ArrayList<Task>();
        try {
            Statement stmnt = conexion.createStatement();
            String ordenSQL = "select * from tasks";
            ResultSet result = stmnt.executeQuery(ordenSQL);
            while(result.next())
            {
                int taskId = result.getInt("TaskId");
                int taskUser = result.getInt("TaskUser");
                String taskTitle = result.getString("TaskTitle");
                String taskDetail = result.getString("TaskDetail");
                Date taskDate = result.getDate("TaskDate");
                Date taskEndDate = result.getDate("TaskEndDate");
                Boolean taskFullDay = result.getBoolean("TaskFullDay");
                BigDecimal taskDuration = result.getBigDecimal("TaskDuration");
                int taskAsignedUser = result.getInt("TaskAsignedUser");
                Task t = new Task(taskId, taskUser, taskTitle, taskDetail, taskDate, taskEndDate, taskFullDay, taskDuration, taskAsignedUser);
                obtainedTasks.add(t);
            }
            result.close();
            stmnt.close();
            conexion.close();
            return obtainedTasks;
        } catch (SQLException e) {
            Log.i("sql", "error sql al recuperar tareas \n"+ e.getMessage());
            return obtainedTasks;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Task obtainTask(String taskTitle) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        //---------------------------------
        Task foundTask = null;
        try {
            ResultSet result = BaseDB.buscarFilasEnTabla(conexion, "tasks", "TaskTitle", taskTitle);
            //------------------------------------------------
            if(result == null)
            {
                return null;
            }
            while(result.next())
            {
                int taskId = result.getInt("TaskId");
                int taskUser = result.getInt("TaskUser");
                String taskDetail = result.getString("TaskDetail");
                Date taskDate = result.getDate("TaskDate");
                Date taskEndDate = result.getDate("TaskEndDate");
                Boolean taskFullDay = result.getBoolean("TaskFullDay");
                BigDecimal taskDuration = result.getBigDecimal("TaskDuration");
                int taskAsignedUser = result.getInt("TaskAsignedUser");
                foundTask = new Task(taskId, taskUser, taskTitle, taskDetail, taskDate, taskEndDate, taskFullDay, taskDuration, taskAsignedUser);

            }
            result.close();
            conexion.close();
            return foundTask;
        } catch (SQLException e) {
            Log.i("sql", "error sql al recuperar la tarea \n"+ e.getMessage());
            return null;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Task obtainTask(int taskId) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        //---------------------------------
        Task foundTask = null;
        try {
            ResultSet result = BaseDB.buscarFilasEnTabla(conexion, "tasks", "TaskId", String.valueOf(taskId));
            //------------------------------------------------
            if(result == null)
            {
                return null;
            }
            while(result.next())
            {
                String taskTitle = result.getString("TaskTitle");
                int taskUser = result.getInt("TaskUser");
                String taskDetail = result.getString("TaskDetail");
                Date taskDate = result.getDate("TaskDate");
                Date taskEndDate = result.getDate("TaskEndDate");
                Boolean taskFullDay = result.getBoolean("TaskFullDay");
                BigDecimal taskDuration = result.getBigDecimal("TaskDuration");
                int taskAsignedUser = result.getInt("TaskAsignedUser");
                foundTask = new Task(taskId, taskUser, taskTitle, taskDetail, taskDate, taskEndDate, taskFullDay, taskDuration, taskAsignedUser);

            }
            result.close();
            conexion.close();
            return foundTask;
        } catch (SQLException e) {
            Log.i("sql", "error sql al recuperar la tarea \n"+ e.getMessage());
            return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Boolean removeTask(Task receivedTask) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM tasks WHERE id = ?;";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setInt(1, receivedTask.getId());
            int affectedRows = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(affectedRows > 0)
            {
                return true;

            }else {

                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Boolean updateTask(Task t) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE tasks SET TaskUser = ?, TaskTitle = ?, TaskDetail = ?," +
                    "TaskDate = ?, TaskEndDate = ?, TaskFullDay = ?, TaskDuration = ?, " +
                    "TaskAsignedUser = ? WHERE id = ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setInt(1, t.getUserId());
            pst.setString(2, t.getTitle());
            pst.setString(3, t.getDetail());
            pst.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(t.getDate()));
            pst.setString( 5,new SimpleDateFormat("yyyy-MM-dd").format(t.getEndTime()));
            pst.setBoolean( 6, t.isFullDay());
            pst.setBigDecimal(7, t.getDuration());
            pst.setDouble(8, t.getId());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
