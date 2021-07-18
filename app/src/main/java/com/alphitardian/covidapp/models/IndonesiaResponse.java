package com.alphitardian.covidapp.models;

import com.google.gson.annotations.SerializedName;

public class IndonesiaResponse {
    @SerializedName("name")
    private String name;

    @SerializedName("positif")
    private String positiveCase;

    @SerializedName("sembuh")
    private String healedCase;

    @SerializedName("meninggal")
    private String deadCase;

    @SerializedName("dirawat")
    private String hospitalizedCase;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositiveCase() {
        return positiveCase;
    }

    public void setPositiveCase(String positiveCase) {
        this.positiveCase = positiveCase;
    }

    public String getHealedCase() {
        return healedCase;
    }

    public void setHealedCase(String healedCase) {
        this.healedCase = healedCase;
    }

    public String getDeadCase() {
        return deadCase;
    }

    public void setDeadCase(String deadCase) {
        this.deadCase = deadCase;
    }

    public String getHospitalizedCase() {
        return hospitalizedCase;
    }

    public void setHospitalizedCase(String hospitalizedCase) {
        this.hospitalizedCase = hospitalizedCase;
    }
}
