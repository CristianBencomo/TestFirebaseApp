package com.example.testfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    private Button sendBtn, rtvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        sendBtn = findViewById(R.id.Send_btn);
        rtvBtn = findViewById(R.id.Retrieve_btn);

        sendBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openSendActivity();
            }
        });

        rtvBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openRetrieveActivity();
            }
        });
    }

    public void openSendActivity()
    {
        Intent intent = new Intent(this, SendActivity.class);
        startActivity(intent);
    }

    public void openRetrieveActivity()
    {
        Intent intent = new Intent(this, RetrieveActivity.class);
        startActivity(intent);
    }
}
