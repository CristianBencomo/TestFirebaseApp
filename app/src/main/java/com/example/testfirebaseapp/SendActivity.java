package com.example.testfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SendActivity extends AppCompatActivity
{

    private ImageButton backBtn;
    private DatabaseReference mDatabase;
    private Button Submit_btn;
    private EditText Name_field, Car_field, Location_field, Fuel_field;
    private String name, car, location, fuel;
    public String tag = "LOGGING";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        Name_field = findViewById(R.id.Name_field);
        Car_field = findViewById(R.id.Car_field);
        Location_field = findViewById(R.id.Location_field);
        Fuel_field = findViewById(R.id.Fuel_field);
        Submit_btn = (Button) findViewById(R.id.Submit_btn);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Submit button
        Submit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendData();
            }
        });

        //backbutton
        backBtn = findViewById(R.id.BackSend_btn);
        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goHome();
            }
        });
    }

    public void sendData()
    {
        HashMap<String, String> dataMap = new HashMap<String, String>();

        name = Name_field.getText().toString().trim();
        car = Car_field.getText().toString().trim();
        location = Location_field.getText().toString().trim();
        fuel = Fuel_field.getText().toString().trim();

        dataMap.put("Car", car);
        dataMap.put("Location", location);
        dataMap.put("Fuel (%)", fuel);

        mDatabase.child(name).setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>()
        {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {

                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Your data has been recorded by our server", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error... Could not store data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}