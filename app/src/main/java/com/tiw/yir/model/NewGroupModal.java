package com.tiw.yir.model;

public class NewGroupModal {
    int image;
    int img_like;
    int img_comment;
    int img_share;
    String name;
    String headlines;
    String news;

    public NewGroupModal() {
    }

    public NewGroupModal(int image, int img_like, int img_comment, int img_share, String name, String headlines, String news) {
        this.image = image;
        this.img_like = img_like;
        this.img_comment = img_comment;
        this.img_share = img_share;
        this.name = name;
        this.headlines = headlines;
        this.news = news;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImg_like() {
        return img_like;
    }

    public void setImg_like(int img_like) {
        this.img_like = img_like;
    }

    public int getImg_comment() {
        return img_comment;
    }

    public void setImg_comment(int img_comment) {
        this.img_comment = img_comment;
    }

    public int getImg_share() {
        return img_share;
    }

    public void setImg_share(int img_share) {
        this.img_share = img_share;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadlines() {
        return headlines;
    }

    public void setHeadlines(String headlines) {
        this.headlines = headlines;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
