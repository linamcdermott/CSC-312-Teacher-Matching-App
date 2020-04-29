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
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


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

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("SnowyArea");

        mImageUrls.add("https://i.redd.it/y4obra59imv41.jpg");
        mNames.add("GrandCanyon");

        mImageUrls.add("https://i.redd.it/sltavh1wumv41.jpg");
        mNames.add("SierraSkys");

        mImageUrls.add("https://i.redd.it/t2xy63875kv41.jpg");
        mNames.add("NetherlandsBeach");

        mImageUrls.add("https://i.redd.it/z74mauwfskv41.jpg");
        mNames.add("SecedaHills");

        mImageUrls.add("https://i.redd.it/hu927ravplv41.jpg");
        mNames.add("GullfossWaterfall");

        mImageUrls.add("https://i.redd.it/ng6sr1zualv41.jpg");
        mNames.add("BrazilSky");

        mImageUrls.add("https://i.redd.it/7aftvdrx8ov41.jpg");
        mNames.add("PacificBeach");

        mImageUrls.add("https://i.redd.it/vgqlg9j8sjv41.jpg");
        mNames.add("Jyrgalan");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "init RecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
