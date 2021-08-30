package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   public String textTask ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button allTask = findViewById(R.id.allTask);
        allTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAllTask = new Intent(MainActivity.this, AllTask.class);
                startActivity(goToAllTask);
            }
        });

        Button addTask = findViewById(R.id.addTask);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddTask = new Intent(MainActivity.this, AddTask.class);
                startActivity(goToAddTask);
            }
        });

        Button task1 =findViewById(R.id.task1);

        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 textTask = task1.getText().toString();
                Intent doToTask1=new Intent(MainActivity.this,TaskDetail.class);
                doToTask1.putExtra("textTask",textTask);
                startActivity(doToTask1);
            }
        });

        Button task2 =findViewById(R.id.task2);
        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTask = task2.getText().toString();
                Intent doToTask2=new Intent(MainActivity.this,TaskDetail.class);
                doToTask2.putExtra("textTask",textTask);
                startActivity(doToTask2);
            }
        });

        Button task3 =findViewById(R.id.task3);
        task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTask = task3.getText().toString();
                Intent doToTask3=new Intent(MainActivity.this,TaskDetail.class);
                doToTask3.putExtra("textTask",textTask);
                startActivity(doToTask3);
            }
        });

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTosettingsPage=new Intent(MainActivity.this,SettingsPage.class);
                startActivity(goTosettingsPage);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String userNameMessage = "  tasks ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String userName = sharedPreferences.getString("userName", "userName");

        TextView instructorNameView = findViewById(R.id.settingsText);
        instructorNameView.setText( userName+ userNameMessage );
    }
}