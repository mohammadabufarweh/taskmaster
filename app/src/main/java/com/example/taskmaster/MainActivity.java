package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   public String textTask ="";
   TaskDataBase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Add these lines to add the AWSApiPlugin plugins
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }

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

//        appDatabase =  Room.databaseBuilder(getApplicationContext(), TaskDataBase.class, "taskInfo").allowMainThreadQueries()
//                .build();
//
        List<TaskModel> tasks = new ArrayList<>();
//        tasks.add(new Task("Reading","read about RecyclerView ","new"));
//        tasks.add(new Task("Code Challenge","Sort Merge","in progress"));
//        tasks.add(new Task("Lab","RecycleView","complete"));

        RecyclerView tasksRecyclerView = findViewById(R.id.recycleView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Handler handler=new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                tasksRecyclerView.getAdapter().notifyDataSetChanged();

                return false;
            }
        });
        Amplify.API.query(
                ModelQuery.list(TaskModel.class),
                response -> {
                    for (TaskModel taskModel : response.getData()) {
                        tasks.add(taskModel);
                        Log.i("MyAmplifyApp", taskModel.getTitle());
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
        tasksRecyclerView.setAdapter(new TaskAdaptor(tasks));


//        TextView textView = findViewById(R.id.title1);
//        textView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String tt = textView.getText().toString();
//                Intent goToTask=new Intent(MainActivity.this,TaskDetail.class);
//                goToTask.putExtra("textTask",tt);
//                startActivity(goToTask);
//            }
//        });


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