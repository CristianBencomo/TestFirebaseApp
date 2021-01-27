package com.example.testfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
{
    private Button sendActBtn, getActBtn;
    //private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Go to send activity page
        sendActBtn = findViewById(R.id.SendActivity_btn);
        sendActBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UserSendActivity();
            }
        });

        //Go to retrieve data page
        getActBtn = findViewById(R.id.GetActivity_btn);
        getActBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UserSelectActivity();
            }
        });
    }

    public void UserSendActivity()
    {
        Intent intent = new Intent(this, SendActivity.class);
        startActivity(intent);
    }

    public void UserSelectActivity()
    {
        Intent intent = new Intent(this, UserSelect.class);
        startActivity(intent);
    }

//    public String getUser()
//    {
//        return this.user;
//    }
//
//    public void setUser(String user)
//    {
//        this.user = user;
//    }
}
