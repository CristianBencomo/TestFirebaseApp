package com.example.testfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserSelect extends AppCompatActivity
{

    private ImageButton backBtn;
    private Button submitBtn;
    private TextInputEditText usernameField;
    public String user;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        usernameField = findViewById(R.id.User_Field);

        submitBtn = findViewById(R.id.Submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                signIn();
            }
        });

        //backbutton
        backBtn = findViewById(R.id.BackUser_btn);
        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goHome();
            }
        });


    }

    public void goHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void userRetrieveActivity()
    {
        Intent intent = new Intent(this, RetrieveActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void signIn()
    {
        user = usernameField.getText().toString().trim();
        Log.d("DEBUGGING", "signIn: the valuse in user is : " + user);


        userRetrieveActivity();
    }
}