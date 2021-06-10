package com.dpvdevelopers.ihomeplanner.Models;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.FileReader;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ConfiguracionDB {
    public static final String HOSTDB = "dpvdevelopers.com";
    public static final String NOMBREDB = getUser();
    public static final String USUARIODB = getUser();
    public static final String CLAVEDB = getConn();
    private static final String OPCIONES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String PUERTOMYSQL = "3306";
    public static final String URLMYSQL = "jdbc:mysql://"+ HOSTDB + ":" + PUERTOMYSQL+"/" + NOMBREDB + OPCIONES;
    //----------------------------------------------------------....
    private static String getUser(){
        String user = "";
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        user = firebaseUser.getEmail().split("@")[0];
        return user;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String getConn(){
        try
        {
            FileReader f = new FileReader("sec.d");
            BufferedReader br = new BufferedReader(f);
            String text = br.readLine();
            br.close();
            return text;
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
            return null;
        }
    }
}