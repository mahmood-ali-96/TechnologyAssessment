package com.example.technologyassessment.di.component;


import com.example.technologyassessment.di.module.FragmentModule;
import com.example.technologyassessment.di.scopes.PerFragment;
import com.example.technologyassessment.ui.details.DetailsFragment;
import com.example.technologyassessment.ui.listing.ListingFragment;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Fragments across the application
 */
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    /**
     * Inject.
     *
     * @param listingFragment the main activity fragment
     */
    void inject(ListingFragment listingFragment);

    void inject(DetailsFragment detailsFragment);
}
