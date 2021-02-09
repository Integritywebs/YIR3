package com.tiw.yir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id")
    @Expose
    private Integer id;
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
    private String electionGroup;
    @SerializedName("about_yourself")
    @Expose
    private String aboutYourself;
    @SerializedName("election_menifesto")
    @Expose
    private String electionMenifesto;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created")
    @Expose
    private String created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getElectionGroup() {
        return electionGroup;
    }

    public void setElectionGroup(String electionGroup) {
        this.electionGroup = electionGroup;
    }

    public String getAboutYourself() {
        return aboutYourself;
    }

    public void setAboutYourself(String aboutYourself) {
        this.aboutYourself = aboutYourself;
    }

    public String getElectionMenifesto() {
        return electionMenifesto;
    }

    public void setElectionMenifesto(String electionMenifesto) {
        this.electionMenifesto = electionMenifesto;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
