package com.example.technologyassessment.ui.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.technologyassessment.R;
import com.example.technologyassessment.di.component.ActivityComponent;
import com.example.technologyassessment.di.component.ConfigPersistentComponent;
import com.example.technologyassessment.di.component.DaggerConfigPersistentComponent;
import com.example.technologyassessment.di.module.ActivityModule;
import com.example.technologyassessment.ui.main.MainActivity;
import com.example.technologyassessment.utils.MainApplication;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * Abstract activity that every other Activity in this application must implement.
 * It provides the following functionality: - Handles creation of Dagger components and makes
 * sure that instances of ConfigPersistentComponent are kept across configuration changes.
 * - Set up and handles a GoogleApiClient instance that can be used to access the
 * Google sign in api. - Handles signing out when an authentication error event is received.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ConfigPersistentComponent> componentsArray =
            new LongSparseArray<>();

    private long activityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, getLayout());

        // Create the ActivityComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        activityId =
                savedInstanceState != null
                        ? savedInstanceState.getLong(KEY_ACTIVITY_ID)
                        : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (componentsArray.get(activityId) == null) {
            configPersistentComponent =
                    DaggerConfigPersistentComponent.builder()
                            .appComponent(MainApplication.get(this).getComponent())
                            .build();
            componentsArray.put(activityId, configPersistentComponent);
        } else {
            configPersistentComponent = componentsArray.get(activityId);
        }
        ActivityComponent activityComponent =
                configPersistentComponent.activityComponent(new ActivityModule(this));
        inject(activityComponent);
        attachView();
    }

    /**
     * Gets layout.
     *
     * @return the layout
     */
    protected abstract int getLayout();

    /**
     * Inject.
     *
     * @param activityComponent the activity component
     */
    protected abstract void inject(ActivityComponent activityComponent);

    /**
     * Attach view.
     */
    protected abstract void attachView();

    /**
     * Detach presenter.
     */
    protected abstract void detachPresenter();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_arb) {
            setLocale("ar");
            return true;
        } else {
            setLocale("en");
            return true;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_ACTIVITY_ID, activityId);
    }

    @Override
    protected void onDestroy() {
        if (!isChangingConfigurations()) {
            componentsArray.remove(activityId);
        }
        detachPresenter();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() >= 2)
            getSupportFragmentManager().popBackStack();
        else
            finish();
    }

    private void setLocale(String lang) {

        Locale locale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(locale);
        res.updateConfiguration(conf, dm);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
