package com.example.rosebud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class StartScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView welcome;
    private Button buttonExistingUser, buttonNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        buttonNewUser = findViewById(R.id.buttonNewUser);
        buttonExistingUser = findViewById(R.id.buttonExistingUser);
        welcome = findViewById(R.id.welcome);

        buttonNewUser.setOnClickListener(this);
        buttonExistingUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonNewUser){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

        else if (v == buttonExistingUser){
            Intent i = new Intent(getApplicationContext(), LoginScreen.class);
            startActivity(i);
        }
    }
}
