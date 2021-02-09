package com.tiw.yir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loginpojo {


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

    public class Data {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_role")
        @Expose
        private Integer userRole;
        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("profile_img")
        @Expose
        private Object profileImg;
        @SerializedName("dob")
        @Expose
        private Object dob;
        @SerializedName("is_mobile_verified")
        @Expose
        private Object isMobileVerified;
        @SerializedName("is_email_verified")
        @Expose
        private Object isEmailVerified;
        @SerializedName("is_voting_candidate")
        @Expose
        private Integer isVotingCandidate;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("st")
        @Expose
        private String st;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserRole() {
            return userRole;
        }

        public void setUserRole(Integer userRole) {
            this.userRole = userRole;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getProfileImg() {
            return profileImg;
        }

        public void setProfileImg(Object profileImg) {
            this.profileImg = profileImg;
        }

        public Object getDob() {
            return dob;
        }

        public void setDob(Object dob) {
            this.dob = dob;
        }

        public Object getIsMobileVerified() {
            return isMobileVerified;
        }

        public void setIsMobileVerified(Object isMobileVerified) {
            this.isMobileVerified = isMobileVerified;
        }

        public Object getIsEmailVerified() {
            return isEmailVerified;
        }

        public void setIsEmailVerified(Object isEmailVerified) {
            this.isEmailVerified = isEmailVerified;
        }

        public Integer getIsVotingCandidate() {
            return isVotingCandidate;
        }

        public void setIsVotingCandidate(Integer isVotingCandidate) {
            this.isVotingCandidate = isVotingCandidate;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }
    }
}