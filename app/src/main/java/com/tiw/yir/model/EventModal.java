package com.tiw.yir.model;

public class EventModal {
    int image;
    String date;
    String topic;
    String news;

    public EventModal() {
    }

    public EventModal(int image, String date, String topic, String news) {
        this.image = image;
        this.date = date;
        this.topic = topic;
        this.news = news;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}

