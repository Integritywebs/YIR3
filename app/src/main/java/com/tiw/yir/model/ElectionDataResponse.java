package com.tiw.yir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElectionDataResponse {


    @SerializedName("ack")
    @Expose
    private int status;
    @SerializedName("msg")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Result result;



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result{
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("user_role")
        @Expose
        private int user_role;
        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("dob")
        @Expose
        private String dob;
        @SerializedName("election_group")
        @Expose
        private String election_group;
        @SerializedName("about_yourself")
        @Expose
        private String about_yourself;
        @SerializedName("election_menifesto")
        @Expose
        private String election_menifesto;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
        public int getUser_role() {
            return user_role;
        }

        public void setUser_role(int user_role) {
            this.user_role = user_role;
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

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getElection_group() {
            return election_group;
        }

        public void setElection_group(String election_group) {
            this.election_group = election_group;
        }

        public String getAbout_yourself() {
            return about_yourself;
        }

        public void setAbout_yourself(String about_yourself) {
            this.about_yourself = about_yourself;
        }

        public String getElection_menifesto() {
            return election_menifesto;
        }

        public void setElection_menifesto(String election_menifesto) {
            this.election_menifesto = election_menifesto;
        }
    }
}
