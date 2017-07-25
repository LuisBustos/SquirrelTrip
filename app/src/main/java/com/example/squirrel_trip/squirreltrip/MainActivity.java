package com.example.squirrel_trip.squirreltrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.squirrel_trip.squirreltrip.model.User;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_READ_CONTACTS = 0;
    // UI references.

    EditText userPassword,useremail;
    Button SignIn,SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up the login form.
        User usuario = new User();
        userPassword = (EditText) findViewById(R.id.password);
        useremail = (EditText) findViewById(R.id.email);
        SignIn = (Button) findViewById(R.id.sign_in_button);
        SignUp = (Button) findViewById(R.id.sign_up_button);
    }
    public void onClickSignIn(View button) {

            String clave = userPassword.getText().toString();
            String correo = useremail.getText().toString();
        if (clave.matches("") || correo.matches("")) {
            Toast.makeText(getBaseContext(),"Datos Incompletos",Toast.LENGTH_LONG).show();
        } else {
            Intent Prof = new Intent(MainActivity.this, com.example.squirrel_trip.squirreltrip.view.ContainerActivity.class);
            Prof.putExtra("Contraseña", clave);
            Prof.putExtra("Email", correo);
            startActivity(Prof);
        }
    }
    public void onClickSignUp(View button){
        Intent Suscribe = new Intent(MainActivity.this, com.example.squirrel_trip.squirreltrip.view.Suscribe.class);
        startActivity(Suscribe);
    }


}


