package com.example.squirrel_trip.squirreltrip.login.repository;

import com.example.squirrel_trip.squirreltrip.login.presenter.MainPresenter;

/**
 * Created by Enrique on 25/07/2017.
 */

public class MainRepositoryImpl implements MainRepository {

    MainPresenter presenter;

    public MainRepositoryImpl(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signIn(String username, String password) {
        boolean success = true;

        if (success) {
            presenter.loginSuccess();
        } else {
            presenter.loginError("Ocurrio un Error");
        }
    }
}
