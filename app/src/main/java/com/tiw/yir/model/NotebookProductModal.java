package com.tiw.yir.model;

public class NotebookProductModal {
    int notebook_image;
    String notebook_title;
    String notebook_price;
    String notebook_pages;

    public NotebookProductModal() {
    }

    public NotebookProductModal(int notebook_image, String notebook_title, String notebook_price, String notebook_pages) {
        this.notebook_image = notebook_image;
        this.notebook_title = notebook_title;
        this.notebook_price = notebook_price;
        this.notebook_pages = notebook_pages;
    }

    public int getNotebook_image() {
        return notebook_image;
    }

    public void setNotebook_image(int notebook_image) {
        this.notebook_image = notebook_image;
    }

    public String getNotebook_title() {
        return notebook_title;
    }

    public void setNotebook_title(String notebook_title) {
        this.notebook_title = notebook_title;
    }

    public String getNotebook_price() {
        return notebook_price;
    }

    public void setNotebook_price(String notebook_price) {
        this.notebook_price = notebook_price;
    }

    public String getNotebook_pages() {
        return notebook_pages;
    }

    public void setNotebook_pages(String notebook_pages) {
        this.notebook_pages = notebook_pages;
    }
}
