package com.example.testfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //DatabaseReference fDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mDatabase;
    Button Submit_btn;
    EditText Name_field, Car_field, Location_field, Fuel_field;
    String name, car, location, fuel;
    String tag = "LOGGING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name_field = findViewById(R.id.Name_field);
        Car_field = findViewById(R.id.Car_field);
        Location_field = findViewById(R.id.Location_field);
        Fuel_field = findViewById(R.id.Fuel_field);
        Submit_btn = (Button) findViewById(R.id.Submit_btn);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = Name_field.getText().toString();
                car = Car_field.getText().toString();
                location = Location_field.getText().toString();
                fuel = Fuel_field.getText().toString();
                Log.d(tag , "The value of the variable Name at this point is:" + name);

                mDatabase.child(name).child("Car").setValue(car);
                mDatabase.child(name).child("Location").setValue(location);
                mDatabase.child(name).child("Fuel Level (%)").setValue(fuel);
                Toast.makeText(getApplicationContext(), "Your data has been recorded by our servers", Toast.LENGTH_SHORT).show();
                //mDatabase.child("User_01").child("Lucas").child("Car Model").setValue("Corolla");
                //mDatabase.child("User_01").child("Lucas").child("Birthday").setValue("April 16");
            }
        });
    }
}
