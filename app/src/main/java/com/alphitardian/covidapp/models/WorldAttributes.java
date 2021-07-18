package com.alphitardian.covidapp.models;

import com.google.gson.annotations.SerializedName;

public class WorldAttributes {
    @SerializedName("OBJECTID")
    private int objectID;

    @SerializedName("Country_Region")
    private String countryRegion;

    @SerializedName("Last_Update")
    private long lastUpdate;

    @SerializedName("Lat")
    private float latitude;

    @SerializedName("Long_")
    private float longitude;

    @SerializedName("Confirmed")
    private int confirmedCase;

    @SerializedName("Deaths")
    private int deadCase;

    @SerializedName("Recovered")
    private int recoveredCase;

    @SerializedName("Active")
    private int activeCase;

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getConfirmedCase() {
        return confirmedCase;
    }

    public void setConfirmedCase(int confirmedCase) {
        this.confirmedCase = confirmedCase;
    }

    public int getDeadCase() {
        return deadCase;
    }

    public void setDeadCase(int deadCase) {
        this.deadCase = deadCase;
    }

    public int getRecoveredCase() {
        return recoveredCase;
    }

    public void setRecoveredCase(int recoveredCase) {
        this.recoveredCase = recoveredCase;
    }

    public int getActiveCase() {
        return activeCase;
    }

    public void setActiveCase(int activeCase) {
        this.activeCase = activeCase;
    }
}
