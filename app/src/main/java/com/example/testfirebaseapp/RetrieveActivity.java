package com.example.testfirebaseapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RetrieveActivity extends AppCompatActivity
{

    private ImageButton backBtn;
    private DatabaseReference mDatabase, userDatabase;
    private ListView userInfoListView;
    public String tag = "DEBUGGING:";

    private ArrayList <String> userInfoArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        userInfoListView = (ListView) findViewById(R.id.Info_List);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userInfoArrayList);
        userInfoListView.setAdapter(arrayAdapter);

        String user = getIntent().getStringExtra("user");
        userDatabase = mDatabase.child(user);

        userDatabase.addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot snapshot,String previousChildName)
            {
                String key = snapshot.getKey();
                String value = snapshot.getValue().toString();
                Log.d(tag, "The value of the key is: " + key);
                userInfoArrayList.add(key + ": " + value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName)
            {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot)
            {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName)
            {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });


        //backbutton
        backBtn = findViewById(R.id.BackGet_btn);
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
}