package com.example.collaborators;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class functionsOnFeed {
    DatabaseReference db_feed;

    public functionsOnFeed() {
        FirebaseDatabase engine = FirebaseDatabase.getInstance();
        db_feed = engine.getReference(feed.class.getSimpleName());
    }

    public Task<Void> add(feed post){
        return db_feed.push().setValue(post);
    }
}
