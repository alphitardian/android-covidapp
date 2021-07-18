package com.alphitardian.covidapp.models;

import com.google.gson.annotations.SerializedName;

public class WorldResponse {
    @SerializedName("attributes")
    private WorldAttributes worldAttributes;

    public WorldAttributes getWorldAttributes() {
        return worldAttributes;
    }

    public void setWorldAttributes(WorldAttributes worldAttributes) {
        this.worldAttributes = worldAttributes;
    }

    public WorldResponse(WorldAttributes worldAttributes) {
        this.worldAttributes = worldAttributes;
    }
}
