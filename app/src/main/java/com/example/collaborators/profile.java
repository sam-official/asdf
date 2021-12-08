package com.example.collaborators;

public class profile {

    private String name;
    private String position;
    private String mail;
    private String team;

    public profile(){}
    public profile(String name, String position, String mail, String team) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getMail() {
        return mail;
    }

    public String getTeam() {
        return team;
    }

}
