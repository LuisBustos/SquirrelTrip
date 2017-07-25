package com.example.squirrel_trip.squirreltrip.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.squirrel_trip.squirreltrip.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritePlacesFragment extends Fragment {


    public FavoritePlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_places, container, false);
    }

}
