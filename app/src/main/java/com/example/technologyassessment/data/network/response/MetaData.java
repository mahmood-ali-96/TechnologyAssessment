package com.example.technologyassessment.data.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * media-metadata Model From Api
 */
public class MetaData {

    @SerializedName("url")
    private String url;

    @SerializedName("format")
    private String format;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

