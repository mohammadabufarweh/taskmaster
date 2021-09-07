package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskModel;

import java.util.List;

public class AddTask extends AppCompatActivity {
    TaskDataBase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button task=findViewById(R.id.task);
        EditText editText1 =findViewById(R.id.editTextTextPersonName2);
        EditText editText2 =findViewById(R.id.editTextTextPersonName3);
        EditText editText3 = findViewById(R.id.editTextTextPersonName4);

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String et1 = editText1.getText().toString();
                String et2 = editText2.getText().toString();
                String et3 = editText3.getText().toString();

                TaskModel taskModel = TaskModel.builder()
                        .title(et1)
                        .body(et2)
                        .state(et3)
                        .build();

                Amplify.API.mutate(
                        ModelMutation.create(taskModel),
                        response -> Log.i("MyAmplifyApp", "Added Todo with id: " + response.getData().getId()),
                        error -> Log.e("MyAmplifyApp", "Create failed", error)
                );

//                Task task = new Task(et1,et2,et3);
//                Intent goToTask=new Intent(AddTask.this,MainActivity.class);
//                appDatabase =  Room.databaseBuilder(getApplicationContext(), TaskDataBase.class, "taskInfo").allowMainThreadQueries()
//                        .build();
//                appDatabase.taskDao().insertAll(task);
//                startActivity(goToTask);

                Toast.makeText(getApplicationContext(), "submitted!", Toast.LENGTH_LONG).show();
            }
        });
    }
}