package com.example.teachertinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teachertinder.ui.dashboard.DashboardFragment;

/** Activity to show user dashboard. **/
public class DashboardActivity extends AppCompatActivity {

    /** Method that is run when the activity is created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DashboardFragment.newInstance())
                    .commitNow();
        }
    }
}
