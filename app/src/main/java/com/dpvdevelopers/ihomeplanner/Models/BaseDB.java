package com.dpvdevelopers.ihomeplanner.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDB {
    //----------------------------------------------------------....
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Connection conectarConBaseDeDatos() {
        try {
            Connection conexion = DriverManager.getConnection(ConfigDB.URLMYSQL, ConfigDB.USUARIODB, ConfigDB.CLAVEDB);
            Statement stmt = conexion.createStatement();
            stmt.execute("use "+ConfigDB.USUARIODB + ";");
            return conexion;
        } catch (SQLException e) {
            System.out.println("no se pudo establecer la conexion con la base de datos: " + e.getMessage() + "//"+ e.getErrorCode());
            return null;
        }
    }
    //-----------------------------------------------------------
    public static ResultSet obtenerDatosTabla(Connection conexion, String nombreTabla)
    {
        try {
            String ordensql = "select * from " + nombreTabla;
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(ordensql);
            return resultado;
        } catch (SQLException e) {
            return null;
        }
    }
    //-----------------------------------------------------------
    public static boolean borrarDatosTabla(Connection conexion, String tabla, String columna, String valorcolumna) {
        try {
            String ordensql= "delete from " + tabla +" where "+ columna + " like ? ";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, valorcolumna);
            int filasafectadas = sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            if(filasafectadas >0 )
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
    //-----------------------------------------------------------------------------------
    public static ResultSet buscarFilasEnTabla(Connection conexion, String nombreTabla, String columna, String valorcolumna)
    {
        try {
            String ordensql = "select * from " + nombreTabla  + " where " + columna + " like ? ";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, valorcolumna);
            ResultSet resultado = sentencia.executeQuery();
            return resultado;
        } catch (SQLException e) {
            return null;
        }
    }
}
