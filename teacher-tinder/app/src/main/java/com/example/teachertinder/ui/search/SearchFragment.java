package com.example.teachertinder.ui.search;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.teachertinder.R;
import com.example.teachertinder.RecyclerViewAdapter;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

/** Fragment for SearchActivity. **/
public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        String jobInfo = mViewModel.getJobInfo();
        // TODO: use ViewModel to populate search
        final Button searchButton = getView().findViewById(R.id.search_btn);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initImageBitmaps();
            }
        });
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("School 1");

        mImageUrls.add("https://i.redd.it/y4obra59imv41.jpg");
        mNames.add("School 2");

        mImageUrls.add("https://i.redd.it/sltavh1wumv41.jpg");
        mNames.add("School 3");

        mImageUrls.add("https://i.redd.it/t2xy63875kv41.jpg");
        mNames.add("School 4");

        mImageUrls.add("https://i.redd.it/z74mauwfskv41.jpg");
        mNames.add("School 5");

        mImageUrls.add("https://i.redd.it/hu927ravplv41.jpg");
        mNames.add("School 6");

        mImageUrls.add("https://i.redd.it/ng6sr1zualv41.jpg");
        mNames.add("School 7");

        mImageUrls.add("https://i.redd.it/7aftvdrx8ov41.jpg");
        mNames.add("School 8");

        mImageUrls.add("https://i.redd.it/vgqlg9j8sjv41.jpg");
        mNames.add("School 9");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "init RecyclerView: init recyclerview.");
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
