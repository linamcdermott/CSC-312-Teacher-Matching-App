package com.example.teachertinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.teachertinder.ui.search.SearchFragment;

import java.util.ArrayList;

/** Activity to display search and search results. **/
public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";
    //vars



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SearchFragment.newInstance())
                    .commitNow();
        }
        Log.d(TAG, "onCreate: started.");
    }
}
