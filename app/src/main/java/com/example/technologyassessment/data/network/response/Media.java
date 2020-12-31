package com.example.technologyassessment.data.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *  Media Model From Api
 */
public class Media {

    @SerializedName("type")
    private String type;

    @SerializedName("caption")
    private String caption;

    @SerializedName("media-metadata")
    private List<MetaData> media_metadata;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<MetaData> getMedia_metadata() {
        return media_metadata;
    }

    public void setMedia_metadata(List<MetaData> media_metadata) {
        this.media_metadata = media_metadata;
    }
}
