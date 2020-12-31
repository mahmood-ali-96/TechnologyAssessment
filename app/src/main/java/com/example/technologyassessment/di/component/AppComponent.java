package com.example.technologyassessment.di.component;

import android.app.Application;
import android.content.Context;

import com.example.technologyassessment.data.network.requset.DataManager;
import com.example.technologyassessment.di.module.AppModule;
import com.example.technologyassessment.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The interface App component..
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    /**
     * Context context.
     *
     * @return the context
     */
    @ApplicationContext
    Context context();

    /**
     * Application application.
     *
     * @return the application
     */
    Application application();

    /**
     * Api manager data manager.
     *
     * @return the data manager
     */
    DataManager apiManager();

}
