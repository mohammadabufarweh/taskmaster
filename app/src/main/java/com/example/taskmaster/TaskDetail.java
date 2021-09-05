package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
//        String textTask =getIntent().getStringExtra("textTask");
//        TextView textView = findViewById(R.id.title);
//        textView.setText(textTask);
        Intent intent = getIntent();
        String taskTitle = intent.getExtras().getString("taskTitle");
        TextView textView1 =findViewById(R.id.taskTitle);
        textView1.setText(taskTitle);


        String taskBody = intent.getExtras().getString("taskBody");
        TextView textView2 =findViewById(R.id.taskBody);
        textView2.setText(taskBody);

        String taskState = intent.getExtras().getString("taskState");
        TextView textView3 =findViewById(R.id.taskState);
        textView3.setText(taskState);

    }


}