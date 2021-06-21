package com.dpvdevelopers.ihomeplanner.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ConfigDB {
    public static final String HOSTDB = "http://dpvdevelopers.com";
    public static String NOMBREDB = "";
    public static String USUARIODB = "";
    public static String CLAVEDB = "";
    private static final String OPCIONES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String PUERTOMYSQL = "3306";
    public static final String URLMYSQL = "jdbc:mysql://"+ "dpvdevelopers.com" + ":" + PUERTOMYSQL+"/" + NOMBREDB + OPCIONES;
    //----------------------------------------------------------....

    private static SharedPreferences pref;

    public static Boolean initConfig(Context conn){
        return initNDB(conn) && initUDB(conn) && initPDB(conn);
    }
    private static Boolean initNDB(Context conn){
        NOMBREDB = getUser(conn);
        if (!NOMBREDB.equals(""))
            return true;
        return false;
    }
    private static Boolean initUDB(Context conn){
        USUARIODB = getUser(conn);
        if (!USUARIODB.equals(""))
            return true;
        return false;
    }
    private static Boolean initPDB(Context conn){
        CLAVEDB = getConn(conn);
        if (!CLAVEDB.equals("1"))
            return true;
        return false;
    }
    private static String getUser(Context conn){
        String user = "";

        pref = PreferenceManager.getDefaultSharedPreferences(conn);
        user = pref.getString("N","Name");
        Log.i("Username recuperado", user);


        return user;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getConn(Context conn){
        pref = PreferenceManager.getDefaultSharedPreferences(conn);
        String pass   = pref.getString("P", "1");
        Log.i("Contraseña recuperada", pass);
        return pass;
        /*
        try
        {
            FileReader f = new FileReader("sec.d");
            BufferedReader br = new BufferedReader(f);
            String text = br.readLine();
            br.close();
            text.replaceAll("\n", "");
            return text;
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
            return null;
        }*/
    }
}