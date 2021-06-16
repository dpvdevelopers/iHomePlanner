package com.dpvdevelopers.ihomeplanner.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dpvdevelopers.ihomeplanner.Classes.Task;
import com.dpvdevelopers.ihomeplanner.Classes.User;
import com.dpvdevelopers.ihomeplanner.Controllers.TaskController;
import com.dpvdevelopers.ihomeplanner.Controllers.UserController;
import com.dpvdevelopers.ihomeplanner.Models.ConfigDB;
import com.dpvdevelopers.ihomeplanner.R;
import com.dpvdevelopers.ihomeplanner.Utils.DatePickerFragment;
import com.google.firebase.auth.FirebaseAuth;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;


public class NewTaskActivity extends AppCompatActivity  {
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
        setContentView(R.layout.activity_new_task);
        edtTaskDate = findViewById(R.id.edtTaskDate);
        edtTaskTitle = findViewById(R.id.edtTaskTitle);
        edtTaskDetail = findViewById(R.id.edtTaskDetail);
        chkFD = findViewById(R.id.chkTaskFullDay);
        edtTaskDate.setText(new SimpleDateFormat("yyyy-mm-dd").format(Date.from(Instant.now())));
        this.user = UserController.getUser(ConfigDB.USUARIODB);
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void CreateUserTask(View view) {
        this.userTask = new Task(user.getId(), edtTaskTitle.getText().toString(), edtTaskDetail.getText().toString());
        if(TaskController.insertTask(userTask)){
            Toast.makeText(this, "Tarea creada correctamente", Toast.LENGTH_SHORT);
            finish();
        }else{
            Toast.makeText(this, "No se ha podido crear la tarea", Toast.LENGTH_SHORT);
        }
    }
}