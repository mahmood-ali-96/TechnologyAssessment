package com.example.technologyassessment.di.component;

import com.example.technologyassessment.di.module.ActivityModule;
import com.example.technologyassessment.di.scopes.PerActivity;
import com.example.technologyassessment.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activity across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * Inject.
     *
     * @param mainActivity the main activity
     */
    void inject(MainActivity mainActivity);
}
