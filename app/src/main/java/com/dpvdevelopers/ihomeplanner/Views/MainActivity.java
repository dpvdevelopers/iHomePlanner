package com.dpvdevelopers.ihomeplanner.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dpvdevelopers.ihomeplanner.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Entrar(View view) {
    }

    public void Recuperar(View view) {
    }

    public void registrarUsuario(View view) {
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }
}