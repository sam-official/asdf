package com.example.collaborators;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class feedActivity extends AppCompatActivity {

    private Button submit;
    private Button contacts;
    private Button addFeed;
    private EditText name;
    private EditText position;
    private EditText mail;
    private EditText team;
    private EditText image;
    private EditText des;
    private EditText ilink;
    private EditText llink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        submit =findViewById(R.id.submit);
        contacts = findViewById(R.id.contacts);
        name = findViewById(R.id.names);
        position = findViewById(R.id.positions);
        mail = findViewById(R.id.mail);
        team = findViewById(R.id.teams);
        image = findViewById(R.id.imagelink);
        des = findViewById(R.id.description);
        ilink = findViewById(R.id.instalink);
        llink = findViewById(R.id.linkedinlink);
        addFeed =findViewById(R.id.update);

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(feedActivity.this,ListActivity.class));

            }
        });

        functionsOnProfile bot = new functionsOnProfile();
        functionsOnFeed feedBot = new functionsOnFeed();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(feedActivity.this,ListActivity.class));
                profile member = new profile(name.getText().toString(),position.getText().toString(),mail.getText().toString(),team.getText().toString());
                bot.update(member).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(feedActivity.this, "member sucessfully updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(feedActivity.this, "sorry failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        addFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feed post = new feed(image.getText().toString(),des.getText().toString(),ilink.getText().toString(),llink.getText().toString());
                feedBot.add(post).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(feedActivity.this, "your post have been published", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(feedActivity.this, "sorry not posted yet", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}