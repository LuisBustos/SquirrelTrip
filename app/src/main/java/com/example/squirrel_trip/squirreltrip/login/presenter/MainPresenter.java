package com.example.squirrel_trip.squirreltrip.login.presenter;

/**
 * Created by Enrique on 25/07/2017.
 */

public interface MainPresenter {
    void signIn(String userName, String userPassword); //Interactor
    void loginSuccess();
    void loginError(String error);
    void singUp();
}
