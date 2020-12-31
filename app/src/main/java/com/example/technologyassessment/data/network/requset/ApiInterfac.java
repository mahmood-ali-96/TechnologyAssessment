package com.example.technologyassessment.data.network.requset;

import com.example.technologyassessment.data.network.response.Articles;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterfac {

    /**
     * Gets Articles.
     *
     * @return the Articles
     */
    @GET("/svc/mostpopular/v2/viewed/7.json")
    Single<Articles> getArticles(@Query("api-key") String api_key);

    /**
     * Gets Article.
     *
     * @article id the id
     * @return the Article
     */
    @GET("")
    Single<Articles> getArticle(@Path("id") int id);
}
