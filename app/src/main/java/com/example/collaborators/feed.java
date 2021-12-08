package com.example.collaborators;

public class feed {
    private String image;
    private String description;
    private String instalink;
    private String linkeninlink;

    public feed(){}
    public feed(String image, String description, String instalink, String linkeninlink) {
        this.image = image;
        this.description = description;
        this.instalink = instalink;
        this.linkeninlink = linkeninlink;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getInstalink() {
        return instalink;
    }

    public String getLinkeninlink() {
        return linkeninlink;
    }
}
