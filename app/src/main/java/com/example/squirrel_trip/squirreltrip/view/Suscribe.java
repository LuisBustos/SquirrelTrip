package com.example.squirrel_trip.squirreltrip.view;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;


import com.example.squirrel_trip.squirreltrip.R;

public class Suscribe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suscribe);
        showToolbar(getResources().getString(R.string.toolbar_tittle_suscribe), true);
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar()!= null;
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


    public void onClickSignIn(View Button){
        Intent Suscribirse = new Intent(Suscribe.this,com.example.squirrel_trip.squirreltrip.view.ContainerActivity.class);
        startActivity(Suscribirse);
    }

}
