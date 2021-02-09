package com.tiw.yir.model;

public class SelectedStudentModal {
    int image;
    String name;
    String mobile;
    String group;
    String vote;
    public SelectedStudentModal() {
    }

    public SelectedStudentModal(int image, String name, String mobile, String group, String vote) {
        this.image = image;
        this.name = name;
        this.mobile = mobile;
        this.group = group;
        this.vote = vote;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
