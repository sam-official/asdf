package com.example.collaborators;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProfileAdaptor extends ArrayAdapter<profile> {
    private final Activity context;
    private final ArrayList<profile> members;

    public ProfileAdaptor(Activity context, ArrayList<profile> members) {
        super(context,R.layout.list_item,members);
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater infalter = context.getLayoutInflater();
        View rowView = infalter.inflate(R.layout.list_item,null,true);

        //initializing the views in the list item xml
        TextView name,status,mail,team;
        ImageView img;
        name = rowView.findViewById(R.id.name);
        status = rowView.findViewById(R.id.position);
        mail = rowView.findViewById(R.id.mail_id);
        team = rowView.findViewById(R.id.team);
        img = rowView.findViewById(R.id.imageView);

        //setting values
        name.setText(members.get(position).getName());
        status.setText(members.get(position).getPosition());
        mail.setText(members.get(position).getMail());
        team.setText(members.get(position).getTeam());

        return rowView;
    }
}
