package com.tiw.yir.model;

public class MagazineProductModal {
    int magazine_image;
    String magazine_title;
    String Magazine_price;
    String magazine_download;

    public MagazineProductModal() {
    }

    public MagazineProductModal(int magazine_image, String magazine_title, String magazine_price, String magazine_download) {
        this.magazine_image = magazine_image;
        this.magazine_title = magazine_title;
        Magazine_price = magazine_price;
        this.magazine_download = magazine_download;
    }

    public int getMagazine_image() {
        return magazine_image;
    }

    public void setMagazine_image(int magazine_image) {
        this.magazine_image = magazine_image;
    }

    public String getMagazine_title() {
        return magazine_title;
    }

    public void setMagazine_title(String magazine_title) {
        this.magazine_title = magazine_title;
    }

    public String getMagazine_price() {
        return Magazine_price;
    }

    public void setMagazine_price(String magazine_price) {
        Magazine_price = magazine_price;
    }

    public String getMagazine_download() {
        return magazine_download;
    }

    public void setMagazine_download(String magazine_download) {
        this.magazine_download = magazine_download;
    }
}
