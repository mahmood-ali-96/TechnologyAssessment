package com.example.technologyassessment.di.component;


import com.example.technologyassessment.di.module.ActivityModule;
import com.example.technologyassessment.di.module.FragmentModule;
import com.example.technologyassessment.di.scopes.ConfigPersistent;
import com.example.technologyassessment.ui.base.BaseActivity;
import com.example.technologyassessment.ui.base.BaseFragment;

import dagger.Component;

/**
 * A dagger component that will live during the lifecycle of an Activity or Fragment but it won't be
 * destroy during configuration changes. Check {@link BaseActivity} and {@link BaseFragment} to see
 * how this components survives configuration changes. Use the {@link ConfigPersistent} scope to
 * annotate dependencies that need to survive configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = AppComponent.class)
public interface ConfigPersistentComponent {

    /**
     * Activity component activity component.
     *
     * @param activityModule the activity module
     * @return the activity component
     */
    ActivityComponent activityComponent(ActivityModule activityModule);

    /**
     * Fragment component fragment component.
     *
     * @param fragmentModule the fragment module
     * @return the fragment component
     */
    FragmentComponent fragmentComponent(FragmentModule fragmentModule);
}
