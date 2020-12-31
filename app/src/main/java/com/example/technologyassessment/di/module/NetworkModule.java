package com.example.technologyassessment.di.module;

import android.content.Context;
import android.os.Bundle;

import com.example.technologyassessment.R;
import com.example.technologyassessment.di.scopes.ApplicationContext;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private final Context context;
    private final String baseUrl;

    /**
     * Instantiates a new Network module.
     *
     * @param context the context
     * @param baseUrl the base url
     */
    public NetworkModule(Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

    /**
     * Provide retrofit retrofit.
     *
     * @param okHttpClient the ok http client
     * @return the retrofit
     */
    @Provides
    @Singleton
    Retrofit providerRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }



    /**
     * Provide ok http client ok http client.
     *
     * @return the ok http client
     */
    @Provides
    @Singleton
    public OkHttpClient provideHttpClient() {
        return new OkHttpClient()
                .newBuilder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Provide gson gson.
     *
     * @return the gson
     */
    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }
}
