package com.example.squirrel_trip.squirreltrip.login.presenter;

import com.example.squirrel_trip.squirreltrip.login.interactor.MainInteractor;
import com.example.squirrel_trip.squirreltrip.login.interactor.MainInteractorImpl;
import com.example.squirrel_trip.squirreltrip.login.view.MainView;

/**
 * Created by Enrique on 25/07/2017.
 */

public class MainPresenterImpl implements MainPresenter{

    private MainView mainView;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        interactor = new MainInteractorImpl(this);
    }


    @Override
    public void signIn(String userName, String userPassword) {
        mainView.disableInputs();
        mainView.showProgressBar();

        interactor.SignIn(userName,userPassword);
    }

    @Override
    public void loginSuccess() {
        mainView.onClickSignIn();
        mainView.hideProgressBar();
    }

    @Override
    public void loginError(String error) {
        mainView.enableInputs();
        mainView.hideProgressBar();
        mainView.loginError(error);
    }

    @Override
    public void singUp() {
        mainView.onCLickSignUp();
    }
}
