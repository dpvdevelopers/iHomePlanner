package com.dpvdevelopers.ihomeplanner.Classes;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.dpvdevelopers.ihomeplanner.Controllers.TaskController;
import com.dpvdevelopers.ihomeplanner.R;
import com.dpvdevelopers.ihomeplanner.Views.TaskActivity;

public class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public static final String EXTRA_OBJECT_TASK = "com.dpvdevelopers.ihomeplanner.Task";
    public TextView txt_rv_task_title;
    public TextView txt_rv_task_detail;
    public TextView txt_rv_task_status;
    public TaskListAdapter taskListAdapter;
    boolean result;

    public TasksViewHolder(@NonNull View itemView, TaskListAdapter taskListAdapter) {
        super(itemView);
        txt_rv_task_title = (TextView) itemView.findViewById(R.id.txtTaskName);
        txt_rv_task_detail = (TextView) itemView.findViewById(R.id.txtTaskDetail);
        txt_rv_task_status = (TextView) itemView.findViewById(R.id.txtTaskStatus);
        this.taskListAdapter = taskListAdapter;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int mPosition = getLayoutPosition();
        Task task = this.taskListAdapter.getTasksList().get(mPosition);
        //byte[] banderaPais = ImagesHandler.convertBitmapToByteArray(pais.getBandera());
        //pais.setBandera(null);
        //---------------------------------------------------------------
        Intent intent = new Intent(taskListAdapter.getC(), TaskActivity.class);
        intent.putExtra(EXTRA_OBJECT_TASK, task);
        //intent.putExtra(EXTRA_BYTES_BANDERA, banderaPais);
        taskListAdapter.getC().startActivity(intent);
    }

    @Override
    public boolean onLongClick(View v) {

        result = false;
        int mPosition = getLayoutPosition();
        Task task = this.taskListAdapter.getTasksList().get(mPosition);
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setMessage("Se va a borrar la tarea ¿Desea continuar?");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                if(TaskController.removeTask(task)){
                    Toast toast = new Toast(v.getContext());
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setText("Tarea borrada correctamente");
                    toast.show();
                    taskListAdapter.getTasksList().remove(task);
                    taskListAdapter.notifyDataSetChanged();
                    result = true;
                }
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
        return result;
    }
}
