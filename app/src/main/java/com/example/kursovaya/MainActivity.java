package com.example.kursovaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    Button signIn, guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.SignIn);
        guest = findViewById(R.id.guestClick);

        guest.setOnClickListener(view -> {

        });

        signIn.setOnClickListener(view -> {

        });
    }

}