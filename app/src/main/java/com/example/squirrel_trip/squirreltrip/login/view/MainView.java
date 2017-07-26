package com.example.squirrel_trip.squirreltrip.login.view;

import android.view.View;

/**
 * Created by Enrique on 25/07/2017.
 */

public interface MainView {
    void onClickSignIn();
    void onCLickSignUp();

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

}
