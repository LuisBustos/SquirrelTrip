package com.example.squirrel_trip.squirreltrip.login.interactor;

import com.example.squirrel_trip.squirreltrip.login.presenter.MainPresenter;
import com.example.squirrel_trip.squirreltrip.login.repository.MainRepository;
import com.example.squirrel_trip.squirreltrip.login.repository.MainRepositoryImpl;

/**
 * Created by Enrique on 25/07/2017.
 */

public class MainInteractorImpl implements MainInteractor {


    private MainPresenter presenter;
    private MainRepository repository;

    public MainInteractorImpl(MainPresenter mainPresenter) {
        this.presenter = mainPresenter;
        repository = new MainRepositoryImpl(mainPresenter);
    }

    @Override
    public void SignIn(String username, String password) {
        repository.signIn(username,password);
    }

}
