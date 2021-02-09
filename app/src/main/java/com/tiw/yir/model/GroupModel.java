package com.tiw.yir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupModel {
        private String id;
        private String groupName;
        private String groupDetails;
        private String staus;


        public GroupModel(String id, String groupName, String groupDetails, String staus) {
            this.id = id;
            this.groupName = groupName;
            this.groupDetails = groupDetails;
            this.staus = staus;
        }



        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getGroupDetails() {
            return groupDetails;
        }

        public void setGroupDetails(String groupDetails) {
            this.groupDetails = groupDetails;
        }

        public String getStaus() {
            return staus;
        }

        public void setStaus(String staus) {
            this.staus = staus;
        }



    }




//
// @SerializedName("ack")
//    @Expose
//    private Integer ack;
//    @SerializedName("msg")
//    @Expose
//    private String msg;
//    @SerializedName("data")
//    @Expose
//    private List<Datum> data = null;
//
//    public Integer getAck() {
//        return ack;
//    }
//
//    public void setAck(Integer ack) {
//        this.ack = ack;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public List<Datum> getData() {
//        return data;
//    }
//
//    public void setData(List<Datum> data) {
//        this.data = data;
//    }
//
//    public class Datum {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("group_name")
//        @Expose
//        private String groupName;
//        @SerializedName("is_full")
//        @Expose
//        private Integer isFull;
//        @SerializedName("created")
//        @Expose
//        private String created;
//        @SerializedName("group_status")
//        @Expose
//        private String groupStatus;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getGroupName() {
//            return groupName;
//        }
//
//        public void setGroupName(String groupName) {
//            this.groupName = groupName;
//        }
//
//        public Integer getIsFull() {
//            return isFull;
//        }
//
//        public void setIsFull(Integer isFull) {
//            this.isFull = isFull;
//        }
//
//        public String getCreated() {
//            return created;
//        }
//
//        public void setCreated(String created) {
//            this.created = created;
//        }
//
//        public String getGroupStatus() {
//            return groupStatus;
//        }
//
//        public void setGroupStatus(String groupStatus) {
//            this.groupStatus = groupStatus;
//        }
//
//    }
//
//
//    public class GroupStatus {
//
//        @SerializedName("total_seat")
//        @Expose
//        private Integer totalSeat;
//        @SerializedName("left_seat")
//        @Expose
//        private Integer leftSeat;
//        @SerializedName("occupied_seat")
//        @Expose
//        private Integer occupiedSeat;
//        @SerializedName("msg")
//        @Expose
//        private String msg;
//
//        public Integer getTotalSeat() {
//            return totalSeat;
//        }
//
//        public void setTotalSeat(Integer totalSeat) {
//            this.totalSeat = totalSeat;
//        }
//
//        public Integer getLeftSeat() {
//            return leftSeat;
//        }
//
//        public void setLeftSeat(Integer leftSeat) {
//            this.leftSeat = leftSeat;
//        }
//
//        public Integer getOccupiedSeat() {
//            return occupiedSeat;
//        }
//
//        public void setOccupiedSeat(Integer occupiedSeat) {
//            this.occupiedSeat = occupiedSeat;
//        }
//
//        public String getMsg() {
//            return msg;
//        }
//
//        public void setMsg(String msg) {
//            this.msg = msg;
//        }
//
//    }
