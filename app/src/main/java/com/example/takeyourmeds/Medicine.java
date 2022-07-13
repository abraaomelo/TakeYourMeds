package com.example.takeyourmeds;

public class Medicine {
    private Integer medID;
    private String medName;

    public Integer getMedID() {
        return medID;
    }

    public void setMedID(Integer medID) {
        this.medID = medID;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    @Override
    public String toString() {
        return medName;
    }
}
