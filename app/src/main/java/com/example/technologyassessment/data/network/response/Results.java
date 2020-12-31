package com.example.technologyassessment.data.network.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Results Model From Api
 */
public class Results implements Serializable {

    @SerializedName("id")
    private double id;

    @SerializedName("source")
    private String source;

    @SerializedName("published_date")
    private String published_date;

    @SerializedName("updated")
    private String updated;

    @SerializedName("adx_keywords")
    private String adx_keywords;

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
        this.adx_keywords = adx_keywords;
    }

    @SerializedName("byline")
    private String byline;

    @SerializedName("title")
    private String title;

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    @SerializedName("abstract")
    private String _abstract;

    @SerializedName("media")
    private List<Media> media;

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }
}
