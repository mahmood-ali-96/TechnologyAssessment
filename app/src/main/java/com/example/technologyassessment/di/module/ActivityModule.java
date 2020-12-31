package com.example.technologyassessment.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.technologyassessment.di.scopes.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * The type Activity module.
 */
@Module
public class ActivityModule {

    private Activity activity;

    /**
     * Instantiates a new Activity module.
     *
     * @param activity the activity
     */
    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Provide activity activity.
     *
     * @return the activity
     */
    @Provides
    Activity provideActivity() {
        return activity;
    }

    /**
     * Provides context context.
     *
     * @return the context
     */
    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }
}