package com.example.squirrel_trip.squirreltrip.post.view;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.squirrel_trip.squirreltrip.R;
import com.example.squirrel_trip.squirreltrip.adapter.PictureAdapterRecyclerView;
import com.example.squirrel_trip.squirreltrip.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {


    private static final int REQUEST_CAMERA = 1;
    private FloatingActionButton fabCamera;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =     inflater.inflate(R.layout.fragment_menu, container,false);
        showToolbar(getResources().getString(R.string.home),false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        fabCamera = (FloatingActionButton) view.findViewById(R.id.fabCamera);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_evaluate,getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);


        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });


        return view;
    }

    private void takePicture() {
        Intent intentTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentTakePicture.resolveActivity(getActivity().getPackageManager())!= null){
            startActivityForResult(intentTakePicture,REQUEST_CAMERA);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CAMERA && resultCode == getActivity().RESULT_OK){
            Log.d("HomeFragment","CAMERA OK!! :)");
        }
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Chipasionate","Chiapas","0 likes"));
        pictures.add(new Picture("http://mw2.google.com/mw-panoramio/photos/medium/23655604.jpg","Veracruz","Mazatlan","47 likes"));
        pictures.add(new Picture("https://www.turimexico.com/wp-content/uploads/2015/07/chico3.jpg","Pachuca","Mineral del Chico","77 likes"));
        return pictures;
    }


    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        assert ((AppCompatActivity) getActivity()).getSupportActionBar()!= null;
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
