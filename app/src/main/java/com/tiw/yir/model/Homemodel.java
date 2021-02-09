package com.tiw.yir.model;

public class Homemodel {
    String id;
    String name;
    int image;
    String count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    public Homemodel(String id, String name, int image, String count) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.count = count;
    }


}
