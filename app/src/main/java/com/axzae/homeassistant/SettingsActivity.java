package com.axzae.homeassistant;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.axzae.homeassistant.fragment.SettingsFragment;

public class SettingsActivity extends AppCompatActivity
{
    private int mActivityResult = Activity.RESULT_CANCELED;
    private SettingsFragment settingsFragment;

        public void setActivityResult(int activityResult) {
            this.mActivityResult = activityResult;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.menu_settings));
        setContentView(R.layout.activity_settings);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        settingsFragment = new SettingsFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, settingsFragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        setResult(mActivityResult);
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (isFinishing()) {
            overridePendingTransition(R.anim.activity_open_scale, R.anim.activity_close_translate);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String result=data.getStringExtra("attribute");
        if(result.length() == 0) return;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = prefs.edit();

        // if succeed the button changes state by itself
        if(resultCode != Activity.RESULT_CANCELED){return;}

        // Otherwise we flip it back to its previous state and redraws the screen.
        Boolean newValue = !prefs.getBoolean(result,false);
        edit.putBoolean(result, newValue);
        edit.apply();
        recreate();

    }
}
