package com.tiw.yir.model;

import java.io.Serializable;

public class GenderModal  implements Serializable {
    private String genderId;
    private String genderType;

    public GenderModal(String genderId, String genderType) {
        this.genderId = genderId;
        this.genderType = genderType;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }
}
