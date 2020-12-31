package com.example.technologyassessment.utils;

import android.app.Application;
import android.content.Context;
import com.example.technologyassessment.BuildConfig;
import com.example.technologyassessment.di.component.AppComponent;
import com.example.technologyassessment.di.component.DaggerAppComponent;
import com.example.technologyassessment.di.module.AppModule;
import com.example.technologyassessment.di.module.NetworkModule;

/**
 * The type Main application.
 *
 */
public class MainApplication extends Application {

    private AppComponent appComponent;

    /**
     * Get main application.
     *
     * @param context the context
     * @return the main application
     */
    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Gets component.
     *
     * @return the component
     */
    public AppComponent getComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule(this, BuildConfig.API_URL))
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    /**
     * Sets component.
     * Needed to replace the component with a test specific one
     * @param appComponent the app component
     */
    public void setComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
