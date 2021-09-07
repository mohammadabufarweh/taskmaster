package com.example.taskmaster;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.TaskModel;
import com.example.taskmaster.R;
import com.example.taskmaster.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdaptor extends RecyclerView.Adapter<TaskAdaptor.TaskViweHolder> {
    List<TaskModel> allTask=new ArrayList<TaskModel>();

    public TaskAdaptor(List<TaskModel> allTask) {
        this.allTask = allTask;
    }

    @NonNull
    @Override
    public TaskViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task,parent,false);
        TaskViweHolder taskViweHolder = new TaskViweHolder(view);
        return taskViweHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdaptor.TaskViweHolder holder, int position) {
        holder.task = allTask.get(position);

        TextView title = holder.itemView.findViewById(R.id.title1);
        TextView body = holder.itemView.findViewById(R.id.body);
        TextView state = holder.itemView.findViewById(R.id.state);

        title.setText(holder.task.getTitle());
        body.setText(holder.task.getBody());
        state.setText(holder.task.getState());
    }

    @Override
    public int getItemCount() {
        return allTask.size();
    }

    public static class TaskViweHolder extends RecyclerView.ViewHolder {
        public TaskModel task;
        View itemView;

        public TaskViweHolder(@NonNull  View itemView) {
            super(itemView);
            this.itemView=itemView;

            itemView.findViewById(R.id.taskFragment).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToDetailPageActivity = new Intent(view.getContext(),TaskDetail.class);
                    goToDetailPageActivity.putExtra("taskTitle",task.getTitle());
                    goToDetailPageActivity.putExtra("taskBody",task.getBody());
                    goToDetailPageActivity.putExtra("taskState",task.getState());
                    view.getContext().startActivity(goToDetailPageActivity);
                }
            });
        }
    }
}
