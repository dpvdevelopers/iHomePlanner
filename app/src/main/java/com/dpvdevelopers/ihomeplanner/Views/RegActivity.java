package com.dpvdevelopers.ihomeplanner.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dpvdevelopers.ihomeplanner.R;

public class RegActivity extends AppCompatActivity {
    private EditText edtLoginUserName;
    private EditText edtLoginPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        edtLoginUserName = findViewById(R.id.edtLoginUserName);
        edtLoginPass = findViewById(R.id.edtLoginPass);
    }

    public void CreateNewUser(View view) {

    }
}