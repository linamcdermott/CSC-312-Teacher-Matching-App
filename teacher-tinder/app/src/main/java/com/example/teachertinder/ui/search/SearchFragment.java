package com.example.teachertinder.ui.search;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.teachertinder.R;
import com.example.teachertinder.RecyclerViewAdapter;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

/** Fragment for SearchActivity. **/
public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;
    private ArrayList<String> mNames = new ArrayList<>(); // TODO: fix and implement database connection.
    private ArrayList<String> mImageUrls = new ArrayList<>(); // TODO: fix and implement database connection.

    /** Returns a new instance of the fragment. */
    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    /** Method to inflate the view. */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_fragment, container, false);
    }

    /** Method that is run when activity is created. */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        String jobInfo = mViewModel.getJobInfo();
        // TODO: use ViewModel to populate search
        final Button searchButton = getView().findViewById(R.id.search_btn);
        final EditText editText = getView().findViewById(R.id.search_box);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                initImageBitmaps();
            }
        });
    }

    /** Temporary hard-coded image information. */
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

    /** Initializes the RecyclerView to populate the UI. */
    private void initRecyclerView(){
        Log.d(TAG, "init RecyclerView: init recyclerview.");
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
