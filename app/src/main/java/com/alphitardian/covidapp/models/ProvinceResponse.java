package com.alphitardian.covidapp.models;

import com.google.gson.annotations.SerializedName;

public class ProvinceResponse {
    @SerializedName("attributes")
    private ProvinceAttributes attributes;

    public ProvinceResponse(ProvinceAttributes attributes) {
        this.attributes = attributes;
    }

    public ProvinceAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(ProvinceAttributes attributes) {
        this.attributes = attributes;
    }
}

