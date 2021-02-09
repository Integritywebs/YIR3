package com.tiw.yir.model;

public class EMagazineModal {

    int magazine_image;
    String magazine_comapany_name;
    String magazine_title;
    String magazine_price;
    String magazine_status;
    String magazine_content;

    public EMagazineModal() {
    }

    public EMagazineModal(int magazine_image, String magazine_comapany_name, String magazine_title, String magazine_price, String magazine_status, String magazine_content) {
        this.magazine_image = magazine_image;
        this.magazine_comapany_name = magazine_comapany_name;
        this.magazine_title = magazine_title;
        this.magazine_price = magazine_price;
        this.magazine_status = magazine_status;
        this.magazine_content = magazine_content;
    }

    public int getMagazine_image() {
        return magazine_image;
    }

    public void setMagazine_image(int magazine_image) {
        this.magazine_image = magazine_image;
    }

    public String getMagazine_comapany_name() {
        return magazine_comapany_name;
    }

    public void setMagazine_comapany_name(String magazine_comapany_name) {
        this.magazine_comapany_name = magazine_comapany_name;
    }

    public String getMagazine_title() {
        return magazine_title;
    }

    public void setMagazine_title(String magazine_title) {
        this.magazine_title = magazine_title;
    }

    public String getMagazine_price() {
        return magazine_price;
    }

    public void setMagazine_price(String magazine_price) {
        this.magazine_price = magazine_price;
    }

    public String getMagazine_status() {
        return magazine_status;
    }

    public void setMagazine_status(String magazine_status) {
        this.magazine_status = magazine_status;
    }

    public String getMagazine_content() {
        return magazine_content;
    }

    public void setMagazine_content(String magazine_content) {
        this.magazine_content = magazine_content;
    }
}
