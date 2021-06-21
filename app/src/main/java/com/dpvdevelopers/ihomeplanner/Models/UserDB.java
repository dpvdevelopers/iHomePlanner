package com.dpvdevelopers.ihomeplanner.Models;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.dpvdevelopers.ihomeplanner.Classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDB {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getUserId(String email){
        Connection con = BaseDB.conectarConBaseDeDatos();
        if(con == null)
        {
            return "0";
        }
        //---------------------------------
        double UserId = 0;
        try {
            ResultSet result = BaseDB.buscarFilasEnTabla(con, "Users", "UserMail", email);
            //------------------------------------------------
            if(result == null)
            {
                return "0";
            }
            while(result.next())
            {
                UserId = result.getDouble("UserId");


            }
            result.close();
            con.close();
            return String.valueOf(UserId);
        } catch (SQLException e) {
            Log.i("sql", "error sql al recuperar el usuario \n"+ e.getMessage());
            return "0";
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static User getUser(String email) {
        Connection con = BaseDB.conectarConBaseDeDatos();
        if(con == null)
        {
            return null;
        }
        //---------------------------------
        User foundUser = null;
        try {
            ResultSet result = BaseDB.buscarFilasEnTabla(con, "Users", "UserMail", email);
            //------------------------------------------------
            if(result == null)
            {
                return null;
            }
            while(result.next())
            {
                int UserId = result.getInt("UserId");
                int UserLevel = result.getInt("UserLevel");
                int UserLicense = result.getInt("UserLicense");
                String UserName = result.getString("UserName");
                String UserLastName = result.getString("UserLastName");
                int UserGroup = result.getInt("UserGroup");
                foundUser = new User( UserId,  UserLevel, UserLicense, UserName, UserLastName, email, UserGroup);

            }
            result.close();
            con.close();
            return foundUser;
        } catch (SQLException e) {
            Log.i("sql", "error sql al recuperar el usuario \n"+ e.getMessage());
            return null;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static User getUser(int userId) {
        Connection con = BaseDB.conectarConBaseDeDatos();
        if(con == null)
        {
            return null;
        }
        //---------------------------------
        User foundUser = null;
        try {
            ResultSet result = BaseDB.buscarFilasEnTabla(con, "Users", "UserId", String.valueOf(userId));
            //------------------------------------------------
            if(result == null)
            {
                return null;
            }
            while(result.next())
            {
                int UserLevel = result.getInt("UserLevel");
                int UserLicense = result.getInt("UserLicense");
                String UserName = result.getString("UserName");
                String UserLastName = result.getString("UserLastName");
                String UserMail = result.getString("UserMail");
                double UserGroup = result.getDouble("UserGroup");
                foundUser = new User( userId,  UserLevel, UserLicense, UserName, UserLastName, UserMail, UserGroup);

            }
            result.close();
            con.close();
            return foundUser;
        } catch (SQLException e) {
            Log.i("sql", "error sql al recuperar el usuario \n"+ e.getMessage());
            return null;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static ArrayList<User> getUsers() {
        Connection con = BaseDB.conectarConBaseDeDatos();
        ArrayList<User> obtainedUsers = new ArrayList<User>();
        if(con == null)
        {
            return null;
        }
        //---------------------------------
        User user = null;
        try {
            ResultSet result = BaseDB.obtenerDatosTabla(con, "Users");
            //------------------------------------------------
            if(result == null)
            {
                return null;
            }
            while(result.next())
            {
                int UserId = result.getInt("UserId");
                int UserLevel = result.getInt("UserLevel");
                int UserLicense = result.getInt("UserLicense");
                String UserName = result.getString("UserName");
                String UserLastName = result.getString("UserLastName");
                String UserEmail = result.getString("UserMail");
                double UserGroup = result.getDouble("UserGroup");
                user = new User( UserId,  UserLevel, UserLicense, UserName, UserLastName, UserEmail, UserGroup);
                obtainedUsers.add(user);
            }
            result.close();
            con.close();
            return obtainedUsers;
        } catch (SQLException e) {
            Log.i("sql", "error sql al recuperar la lista de usuarios \n"+ e.getMessage());
            return null;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean insertUser(User u) {

        Connection con = BaseDB.conectarConBaseDeDatos();
        if(con == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO Users ( UserLevel, UserLicense, UserName, UserLastName, UserMail, UserGroup) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(ordensql);
            pst.setInt(1, u.getLevel());
            pst.setInt(2, u.getLicense());
            pst.setString(3, u.getName());
            pst.setString(4, u.getLastName());
            pst.setString( 5,u.getMail());
            pst.setDouble( 6, u.getGroupId());
            int affectedRows = pst.executeUpdate();
            pst.close();
            con.close();
            if(affectedRows > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL GUARDAR EL USUARIO ---------------------------" + e.getMessage());
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Boolean removeUser(User receivedUser) {
        Connection con = BaseDB.conectarConBaseDeDatos();
        if(con == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM users WHERE id = ?;";
            PreparedStatement pst = con.prepareStatement(ordensql);
            pst.setDouble(1, receivedUser.getId());
            int affectedRows = pst.executeUpdate();
            pst.close();
            con.close();
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
    public static Boolean updateUser(User u) {
        Connection con = BaseDB.conectarConBaseDeDatos();
        if(con == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE users SET UserLevel = ?, UserLicense = ?, UserName = ?," +
                    "UserLastName = ?, UserMail = ?, UserGroup = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(ordensql);
            pst.setInt(1, u.getLevel());
            pst.setInt(2, u.getLicense());
            pst.setString(3, u.getName());
            pst.setString(4, u.getLastName());
            pst.setString( 5,u.getMail());
            pst.setDouble(8, u.getGroupId());
            int affectedRows = pst.executeUpdate();
            pst.close();
            con.close();
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
}
