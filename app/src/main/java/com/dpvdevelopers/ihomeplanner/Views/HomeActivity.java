package com.dpvdevelopers.ihomeplanner.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.dpvdevelopers.ihomeplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private TableLayout layoutHome;
    private TableLayout layoutFin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        layoutHome = findViewById(R.id.tableLayoutHome);
        layoutFin = findViewById(R.id.tableLayoutFinances);
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();


                if(user != null){

                    if(!user.isEmailVerified()){


                    }else{

                    }
                }else{
                    //Sesión cerrada
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

    public void showHome(View view) {
        layoutHome.setVisibility(View.VISIBLE);

        layoutFin.setVisibility(view.GONE);
    }
    public void showFin(View view) {
        layoutFin.setVisibility(view.VISIBLE);
        layoutHome.setVisibility(View.GONE);
    }

    public void logOut(View view) {
        firebaseAuth.signOut();
        Toast toast = new Toast(HomeActivity.this);
        toast.setText("Sesión cerrada");
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
        finish();
    }
}