package com.example.ashutosh.supertourism.model;

/**
 * Created by Ashutosh on 01-10-2016.
 */
public class Place {

    private String type, name, summary, image, link;
    private int imageLocation;

    public Place(String type, String name, String summary, String image, String link) {
        this.type = type;
        this.name = name;
        this.summary = summary;
        this.image = image;
        this.link = link;
    }

    public Place(String type, String name, int imageLocation){
        this.type = type;
        this.name = name;
        this.imageLocation = imageLocation;
    }

    public int getImageLocation() {
        return imageLocation;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }
}
