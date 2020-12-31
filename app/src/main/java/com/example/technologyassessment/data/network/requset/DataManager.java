package com.example.technologyassessment.data.network.requset;

import com.example.technologyassessment.BuildConfig;
import com.example.technologyassessment.data.network.response.Articles;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * The type Data manager.
 */
@Singleton
public class DataManager {

    private ApiInterfac apiInterfac;

    /**
     * Instantiates a new Data manager.
     *
     * @param apiInterfac the api service
     */
    @Inject
    public DataManager(ApiInterfac apiInterfac) {
        this.apiInterfac = apiInterfac;
    }

    /**
     * Gets Articles.
     *
     * @return the Articles
     */
    public Single<Articles> getArticles() {
        return apiInterfac.getArticles(BuildConfig.API_KEY);
    }

    /**
     * Gets Article.
     *
     * @param id the id
     * @return the Article
     */
    public Single<Articles> getArticle(int id) {
        return apiInterfac.getArticle(id);
    }
}
