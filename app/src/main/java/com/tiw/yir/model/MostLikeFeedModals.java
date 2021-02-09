package com.tiw.yir.model;

public class MostLikeFeedModals {
    int video_image,play_img;

    public MostLikeFeedModals(int video_image, int play_img) {
        this.video_image = video_image;
        this.play_img = play_img;
    }

    public int getVideo_image() {
        return video_image;
    }

    public void setVideo_image(int video_image) {
        this.video_image = video_image;
    }

    public int getPlay_img() {
        return play_img;
    }

    public void setPlay_img(int play_img) {
        this.play_img = play_img;
    }
}
