package com.dpvdevelopers.ihomeplanner.Views;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Classes.TaskListAdapter;
import com.dpvdevelopers.ihomeplanner.Classes.TasksViewHolder;
import com.dpvdevelopers.ihomeplanner.Classes.User;
import com.dpvdevelopers.ihomeplanner.Controllers.TaskController;
import com.dpvdevelopers.ihomeplanner.Controllers.UserController;
import com.dpvdevelopers.ihomeplanner.R;
import com.dpvdevelopers.ihomeplanner.Utils.DatePickerFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    RecyclerView rv_tasks;
    ArrayList<Task> receivedTasks;
    TaskListAdapter taskListAdapter;

    EditText edtTaskTitle;
    EditText edtTaskDetail;
    CheckBox chkFD;
    EditText edtTaskDate;
    Task userTask;
    User user;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userTask = (Task) getIntent().getExtras().getSerializable(TasksViewHolder.EXTRA_OBJECT_TASK);
        setContentView(R.layout.activity_task);
        firebaseAuth = FirebaseAuth.getInstance();
        edtTaskDate = findViewById(R.id.edtTaskDate);
        edtTaskTitle = findViewById(R.id.edtTaskTitle);
        edtTaskDetail = findViewById(R.id.edtTaskDetail);
        chkFD = findViewById(R.id.chkTaskFullDay);
        edtTaskDate.setText(userTask.getDate().toString());
        edtTaskTitle.setText(userTask.getTitle());
        edtTaskDetail.setText(userTask.getDetail());
        chkFD.setChecked(userTask.isFullDay());
        this.user = UserController.getUser(FirebaseAuth.getInstance().getCurrentUser().getEmail());
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

    public void EditUserTask(View view) {
        userTask.setTitle(edtTaskTitle.getText().toString());
        userTask.setDetail(edtTaskDetail.getText().toString());
        userTask.setFullDay(chkFD.isChecked());
        userTask.setDate(Date.valueOf(edtTaskDate.getText().toString()));
        if(TaskController.updateTask(userTask)){
            Toast.makeText(this, "Tarea editada correctamente", Toast.LENGTH_SHORT);
            finish();
        }else{
            Toast.makeText(this, "No se ha podido editar la tarea", Toast.LENGTH_SHORT);
        }
    }
    public void showDatePicker(View view) {
        DatePickerFragment dpf = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                final String selectedDate = day + " - " + (month+1) + " - " + year;
                edtTaskDate.setText(selectedDate);
            }
        }, this.edtTaskDate);

        dpf.show(getSupportFragmentManager(), "datePicker");
    }
}