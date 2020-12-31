package com.example.technologyassessment.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.technologyassessment.R;
import com.example.technologyassessment.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import dagger.Module;
import dagger.Provides;

/**
 * The type App module.
 */
@Module(includes = {ApiModule.class})
public class AppModule {

    private final Application application;

    /**
     * Instantiates a new App module.
     *
     * @param application the application
     */
    public AppModule(Application application) {
        this.application = application;
    }

    /**
     * Provide application application.
     *
     * @return the application
     */
    @Provides
    Application provideApplication() {
        return application;
    }

    /**
     * Provide context context.
     *
     * @return the context
     */
    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    /**
     * Provide shared preference shared preferences.
     *
     * @param context the context
     * @return the shared preferences
     */
    @Provides
    @ApplicationContext
    SharedPreferences provideSharedPreference(@ApplicationContext Context context) {
        return context.getSharedPreferences("PREF_FILE_NAME", Context.MODE_PRIVATE);
    }

    /**
     * Provide StaggeredGridLayoutManager for recycler.
     *
     * @param context the context
     * @return the layout manager
     */
    @Provides
    @Singleton
    StaggeredGridLayoutManager providerLayoutManager(@ApplicationContext Context context) {
        return new StaggeredGridLayoutManager(
                context.getResources().getInteger(R.integer.coloms_num),
                LinearLayoutManager.VERTICAL);
    }

    /**
     * Provide Bundle.
     */
    @Provides
    @Singleton
    Bundle providerBundle() {
        return new Bundle();
    }
}
