package com.tiw.yir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplyForScholarshipResponse {
    @SerializedName("ack")
    @Expose
    private Integer ack;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getAck() {
        return ack;
    }

    public void setAck(Integer ack) {
        this.ack = ack;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data{
        @SerializedName("total_seat")
        @Expose
        private Integer totalSeat;
        @SerializedName("left_seat")
        @Expose
        private Integer leftSeat;
        @SerializedName("occupied_seat")
        @Expose
        private Integer occupiedSeat;
        @SerializedName("msg")
        @Expose
        private String msg;

        public Integer getTotalSeat() {
            return totalSeat;
        }

        public void setTotalSeat(Integer totalSeat) {
            this.totalSeat = totalSeat;
        }

        public Integer getLeftSeat() {
            return leftSeat;
        }

        public void setLeftSeat(Integer leftSeat) {
            this.leftSeat = leftSeat;
        }

        public Integer getOccupiedSeat() {
            return occupiedSeat;
        }

        public void setOccupiedSeat(Integer occupiedSeat) {
            this.occupiedSeat = occupiedSeat;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
}
}