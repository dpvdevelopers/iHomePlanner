package com.dpvdevelopers.ihomeplanner.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Classes.TaskListAdapter;
import com.dpvdevelopers.ihomeplanner.Controllers.TaskController;
import com.dpvdevelopers.ihomeplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    RecyclerView rv_tasks;
    ArrayList<Task> receivedTasks;
    TaskListAdapter taskListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        rv_tasks = findViewById(R.id.rv_tasks);
        updateLocalData();
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();


                if(user != null){
                    //La sesión está iniciada
                    if(!user.isEmailVerified()){
                        //Usuario sin correo verificado

                    }else{
                        //Usuario con correo verificado
                    }
                }
            }
        };
    }

    private void updateLocalData() {
        receivedTasks = TaskController.obtainTasks();
        taskListAdapter = new TaskListAdapter(this, receivedTasks);
        rv_tasks.setAdapter(taskListAdapter);
        rv_tasks.setLayoutManager(new LinearLayoutManager(this));
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

    public void createNewTask(View view) {
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }
}