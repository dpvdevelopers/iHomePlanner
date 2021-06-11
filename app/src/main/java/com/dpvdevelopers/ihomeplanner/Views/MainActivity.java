package com.dpvdevelopers.ihomeplanner.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dpvdevelopers.ihomeplanner.Classes.Utils;
import com.dpvdevelopers.ihomeplanner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText edtUser;
    private EditText edtPass;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUsuario);
        edtPass = findViewById(R.id.edtPass);
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();


                if(user != null){
                    Toast.makeText(MainActivity.this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
                    if(!user.isEmailVerified()){
                        Toast.makeText(MainActivity.this, "Debe verificar el correo electrónico", Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(MainActivity.this, "Usuario con correo verificado", Toast.LENGTH_LONG).show();
                        //Utils.createNewUser(user, edtPass.getText().toString(),MainActivity.this);
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
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

    public void Entrar(View view) {
        String userName = edtUser.getText().toString();
        String pass = edtPass.getText().toString();
        if(!userName.equals("") && !pass.equals("")) {
            firebaseAuth.signInWithEmailAndPassword(userName, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast toast = new Toast(getApplicationContext());
                        toast.setText("No ha sido posible iniciar sesión");
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                        //Toast.makeText(MainActivity.this, "No ha sido posible iniciar sesión",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Sesión iniciada en metodo Entrar",Toast.LENGTH_LONG).show();
                        Utils.createNewUser(firebaseAuth.getCurrentUser(), pass, MainActivity.this);
                    }
                }
            });
        }else{
            Toast toast = new Toast(MainActivity.this);
            toast.setText("Debe rellenar sus datos");
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void Recuperar(View view) {
    }

    public void registrarUsuario(View view) {
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }
}