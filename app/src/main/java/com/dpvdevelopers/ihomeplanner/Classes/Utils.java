package com.dpvdevelopers.ihomeplanner.Classes;

import android.content.Context;
import android.net.UrlQuerySanitizer;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;


public class Utils {

    public static boolean createNewUser(FirebaseUser user, String pass, Context context){
        String userName = user.getEmail();
        String password = pass;

        if(user != null){
            try {
                File f = new File(context.getFilesDir(),"sec.d");
                if(!f.exists()){
                    f.createNewFile();
                }
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(password);
                bw.flush();
                bw.close();
                Toast.makeText(context, "Escritura en fichero terminada", Toast.LENGTH_LONG);
            } catch (IOException e) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                return false;
            }

            try{
                URL url = new URL("http://dpvdevelopers.com/index.php");
                Map<String, Object> params = new LinkedHashMap<>();

                params.put("username", userName);
                params.put("pass", password);

                StringBuilder postData = new StringBuilder();
                for (Map.Entry<String, Object> param : params.entrySet()) {
                    if (postData.length() != 0)
                        postData.append('&');
                    try {
                        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));

                        postData.append('=');
                        postData.append(URLEncoder.encode(String.valueOf(param.getValue()),
                            "UTF-8"));

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");
                    conn.setRequestProperty("Content-Length",
                            String.valueOf(postDataBytes.length));
                    conn.setDoOutput(true);
                    conn.getOutputStream().write(postDataBytes);

                    Reader in = new BufferedReader(new InputStreamReader(
                            conn.getInputStream(), "UTF-8"));
                    for (int c = in.read(); c != -1; c = in.read())
                        System.out.print((char) c);
                    Toast.makeText(context, "Escritura POST terminada", Toast.LENGTH_LONG);

            }catch (UnsupportedEncodingException u) {

            }catch (ProtocolException p) {

            }catch (IOException i) {
                i.getMessage();
            }

                /*
                URLConnection URLcon = new URLConnection(new URL("dpvdevelopers.com/cuser.php?username="+userName+"&pass="+password)) {
                    @Override
                    public void connect() {
                        
                    }
                };
                URLcon.connect();
                */


        }
        return false;
    }
}
