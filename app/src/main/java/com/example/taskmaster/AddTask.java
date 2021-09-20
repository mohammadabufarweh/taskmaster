package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AddTask extends AppCompatActivity {
    int lat;
    int lon;
    TaskDataBase appDatabase;
    private FusedLocationProviderClient fusedLocationClient;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button task = findViewById(R.id.task);
        EditText editText1 = findViewById(R.id.editTextTextPersonName2);
        EditText editText2 = findViewById(R.id.editTextTextPersonName3);
        EditText editText3 = findViewById(R.id.editTextTextPersonName4);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        Button location = findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                location();

            }
        });
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

    public void location() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            showLocation();
        else
            ActivityCompat.requestPermissions(AddTask.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 5);

//        fusedLocationClient.getLastLocation()
//                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        // Got last known location. In some rare situations this can be null.
//                        if (location != null) {
//
//                        }
//                    }
//                });
    }
    @SuppressLint("MissingPermission")
    private void showLocation() {
    fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
        @Override
        public void onComplete(@NonNull Task<Location> task) {
            Location location=task.getResult();
            if (location!=null){
                Geocoder geocoder = new Geocoder(AddTask.this, Locale.getDefault());
                try {
                    List<Address> address = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    Log.i("Location", String.valueOf(address.get(0).getLatitude()));

                    System.out.println("======================================" +address.get(0).getCountryName() );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    }
}