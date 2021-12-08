package com.example.collaborators;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    //private String[][] members = new String[4][4];
    private Button next;
    DatabaseReference profiles;
    /*private String[][] members={{"srijith","software developer","srijith@gmail.com","content"},
        {"vinay","software developer","vinay@gmail.com","marketing"},
        {"sameer","software developer","sameer@gmail.com","design"},
        {"jeswell","software developer","jewellh@gmail.com","content"},
            {"jeswell","software developer","jewellh@gmail.com","content"},
            {"jeswell","software developer","jewellh@gmail.com","content"},
            {"jeswell","software developer","jewellh@gmail.com","content"},
            {"jeswell","software developer","jewellh@gmail.com","content"},
            {"jeswell","software developer","jewellh@gmail.com","content"}};*/

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        next =findViewById(R.id.button);
        lv =findViewById(R.id.listview);

        ArrayList<profile> list =new ArrayList<>();
        ProfileAdaptor adptr = new ProfileAdaptor(ListActivity.this,list);
        lv.setAdapter(adptr);

        profiles = FirebaseDatabase.getInstance().getReference(profile.class.getSimpleName());
        profiles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot details: snapshot.getChildren()){
                    profile members = details.getValue(profile.class);
                    list.add(members);
                }
                adptr.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ListActivity.this, "sorry failed", Toast.LENGTH_SHORT).show();
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListActivity.this,feedActivity.class));
            }
        });

    }
}