package com.example.squirrel_trip.squirreltrip.view;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.squirrel_trip.squirreltrip.R;
import com.example.squirrel_trip.squirreltrip.view.fragments.MenuFragment;
import com.example.squirrel_trip.squirreltrip.view.fragments.NearbyPlacesFragment;
import com.example.squirrel_trip.squirreltrip.view.fragments.ProfileFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomBar = (BottomNavigationView) findViewById(R.id.bottomBar);

        ProfileFragment profileFragment = new ProfileFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int selector = item.getItemId();
                switch (selector){
                    case R.id.menuprofile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null).commit()
                        ;
                        break;
                    case R.id.menuSearch:
                        NearbyPlacesFragment nearbyPlaces = new NearbyPlacesFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,nearbyPlaces)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit()
                        ;
                        break;
                    case R.id.menuSettings:
                        MenuFragment menuFragment= new MenuFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit()
                        ;
                        break;
                }

                return false;
            }
        });
    }
}
