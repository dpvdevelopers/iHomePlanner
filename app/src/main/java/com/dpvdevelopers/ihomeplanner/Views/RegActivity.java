package com.dpvdevelopers.ihomeplanner.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dpvdevelopers.ihomeplanner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegActivity extends AppCompatActivity {
    private EditText edtLoginUserName;
    private EditText edtLoginPass;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        edtLoginUserName = findViewById(R.id.edtLoginUserName);
        edtLoginPass = findViewById(R.id.edtLoginPass);


        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null){
                    Toast.makeText(RegActivity.this, "Usuario creado correctamente", Toast.LENGTH_LONG).show();
                }else{
                    //El usuario salió de la sesión
                }
            }
        };

    }

    public void CreateNewUser(View view) {
        Toast.makeText(this, "Registrando usuario", Toast.LENGTH_SHORT).show();
        String userName = edtLoginUserName.getText().toString();
        String pass = edtLoginPass.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(userName, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(RegActivity.this, "No se ha podido registrar el usuario", Toast.LENGTH_LONG).show();
                }else{
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    user.sendEmailVerification();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener != null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }
}