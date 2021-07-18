package com.alphitardian.covidapp.models;

import com.google.gson.annotations.SerializedName;

public class ProvinceAttributes {
    @SerializedName("FID")
    private int FID;

    @SerializedName("Kode_Provi")
    private int provinceCode;

    @SerializedName("Provinsi")
    private String provinceName;

    @SerializedName("Kasus_Posi")
    private int positiveCase;

    @SerializedName("Kasus_Semb")
    private int healedCase;

    @SerializedName("Kasus_Meni")
    private int deadCase;

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getPositiveCase() {
        return positiveCase;
    }

    public void setPositiveCase(int positiveCase) {
        this.positiveCase = positiveCase;
    }

    public int getHealedCase() {
        return healedCase;
    }

    public void setHealedCase(int healedCase) {
        this.healedCase = healedCase;
    }

    public int getDeadCase() {
        return deadCase;
    }

    public void setDeadCase(int deadCase) {
        this.deadCase = deadCase;
    }
}
