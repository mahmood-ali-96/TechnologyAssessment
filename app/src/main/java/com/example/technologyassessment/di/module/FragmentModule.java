package com.example.technologyassessment.di.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.technologyassessment.R;
import com.example.technologyassessment.di.scopes.ActivityContext;
import com.example.technologyassessment.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import dagger.Module;
import dagger.Provides;

/**
 * The type Fragment module.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    /**
     * Instantiates a new Fragment module.
     *
     * @param fragment the fragment
     */
    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    /**
     * Provides fragment fragment.
     *
     * @return the fragment
     */
    @Provides
    Fragment providesFragment() {
        return fragment;
    }

    /**
     * Provide activity activity.
     *
     * @return the activity
     */
    @Provides
    Activity provideActivity() {
        return fragment.getActivity();
    }

    /**
     * Provides context context.
     *
     * @return the context
     */
    @Provides
    @ActivityContext
    Context providesContext() {
        return fragment.getActivity();
    }
}
