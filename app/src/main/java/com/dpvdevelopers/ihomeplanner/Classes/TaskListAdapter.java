package com.dpvdevelopers.ihomeplanner.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dpvdevelopers.ihomeplanner.R;

import java.util.ArrayList;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TasksViewHolder> {

    private Context c;
    private ArrayList<Task> taskList;
    private LayoutInflater mInflater;

    public TaskListAdapter(Context c, ArrayList<Task> taskList) {
        this.c = c;
        this.taskList = taskList;
        mInflater = LayoutInflater.from(c);
    }
    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public ArrayList<Task> getTasksList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public void setmInflater(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.task_item, parent, false);
        return new TasksViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {

        Task actTask = taskList.get(position);
        holder.txt_rv_task_title.setText( actTask.getTitle());
        holder.txt_rv_task_status.setText(actTask.getEndTime().toString());
        holder.txt_rv_task_detail.setText(actTask.getDetail());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
