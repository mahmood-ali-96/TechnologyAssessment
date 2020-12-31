package com.example.technologyassessment.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.technologyassessment.R;
import com.example.technologyassessment.di.component.ActivityComponent;
import com.example.technologyassessment.ui.base.BaseActivity;
import com.example.technologyassessment.ui.listing.ListingFragment;

import javax.inject.Inject;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,new ListingFragment())
                .addToBackStack("List_fragment")
                .commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }
}
