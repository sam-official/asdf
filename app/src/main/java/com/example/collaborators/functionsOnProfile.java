package com.example.collaborators;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class functionsOnProfile {
    private DatabaseReference node;

    public functionsOnProfile() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        node = db.getReference(profile.class.getSimpleName());
    }

    public Task<Void> add(profile member){
        return node.child(member.getName()).setValue(member);
    }
    public Task<Void> update(profile member){
        //DatabaseReference child= node.orderByChild("name").equalTo(member.getName()).getRef();
//        HashMap<String,String> hashmap =new HashMap<>();
//        hashmap.put("mail", member.getMail());
//        hashmap.put("position", member.getPosition());
//        hashmap.put("team", member.getTeam());
        return node.child(member.getName()).setValue(member);
        //return node.push().setValue(member);
    }
}
