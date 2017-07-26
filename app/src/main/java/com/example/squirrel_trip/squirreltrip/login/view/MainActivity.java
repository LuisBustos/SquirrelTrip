package com.example.squirrel_trip.squirreltrip.login.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.squirrel_trip.squirreltrip.R;
import com.example.squirrel_trip.squirreltrip.login.presenter.MainPresenter;
import com.example.squirrel_trip.squirreltrip.login.presenter.MainPresenterImpl;
import com.example.squirrel_trip.squirreltrip.model.User;

public class MainActivity extends AppCompatActivity implements MainView {

    private TextInputEditText userPassword,userEmail;
    private Button SignIn,SignUp;
    private ProgressBar progressBarLogin;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPassword = (TextInputEditText) findViewById(R.id.password);
        userEmail = (TextInputEditText) findViewById(R.id.email);
        SignIn = (Button) findViewById(R.id.sign_in_button);
        SignUp = (Button) findViewById(R.id.sign_up_button);
        progressBarLogin = (ProgressBar) findViewById(R.id.progressbarLogin);
        hideProgressBar();
        presenter = new MainPresenterImpl(this);

        SignIn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String clave = userPassword.getText().toString();
                String correo = userEmail.getText().toString();
                if (clave.matches("") || correo.matches("")) {
                    Toast.makeText(getBaseContext(),"Datos Incompletos",Toast.LENGTH_LONG).show();
                } else {
                    presenter.signIn(correo,clave);
                }
            }
        });


    }


    @Override
    public void onClickSignIn() {
        Intent Prof = new Intent(MainActivity.this, com.example.squirrel_trip.squirreltrip.view.ContainerActivity.class);
        startActivity(Prof);
    }

    @Override
    public void onCLickSignUp() {
        Intent Suscribe = new Intent(MainActivity.this, com.example.squirrel_trip.squirreltrip.view.Suscribe.class);
        startActivity(Suscribe);
    }

    @Override
    public void enableInputs() {
        userEmail.setEnabled(true);
        userPassword.setEnabled(true);
        SignIn.setEnabled(true);
        SignUp.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        userEmail.setEnabled(false);
        userPassword.setEnabled(false);
        SignIn.setEnabled(false);
        SignUp.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.error_logIn) + error, Toast.LENGTH_SHORT).show();
    }
}


