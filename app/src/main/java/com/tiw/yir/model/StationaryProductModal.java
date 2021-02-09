package com.tiw.yir.model;

public class StationaryProductModal {
    int stationary_image;
    String stationary_title;
    String stationary_price;
    String stationary_pages;

    public StationaryProductModal() {
    }

    public StationaryProductModal(int stationary_image, String stationary_title, String stationary_price, String stationary_pages) {
        this.stationary_image = stationary_image;
        this.stationary_title = stationary_title;
        this.stationary_price = stationary_price;
        this.stationary_pages = stationary_pages;
    }

    public int getStationary_image() {
        return stationary_image;
    }

    public void setStationary_image(int stationary_image) {
        this.stationary_image = stationary_image;
    }

    public String getStationary_title() {
        return stationary_title;
    }

    public void setStationary_title(String stationary_title) {
        this.stationary_title = stationary_title;
    }

    public String getStationary_price() {
        return stationary_price;
    }

    public void setStationary_price(String stationary_price) {
        this.stationary_price = stationary_price;
    }

    public String getStationary_pages() {
        return stationary_pages;
    }

    public void setStationary_pages(String stationary_pages) {
        this.stationary_pages = stationary_pages;
    }
}
