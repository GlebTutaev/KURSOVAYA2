package com.example.kursovaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText userName, pass;
    Button signIn, guest;

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new DbHelper(this);
        try {
            dbHelper.updateDataBase();
        } catch (IOException e) {
            throw new Error("Oshibka");
        }

        try {
            db = dbHelper.getWritableDatabase();

        } catch (SQLException sqlException) {
            throw sqlException;
        }

        userName = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        signIn = findViewById(R.id.SignIn);
        guest = findViewById(R.id.guestClick);

        guest.setOnClickListener(view -> {

            Intent intent = new Intent(this, GuestActivity.class);
            startActivity(intent);
        });

        signIn.setOnClickListener(view -> {

            String user = userName.getText().toString();
            String password = pass.getText().toString();

            if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Not all fields are filled", Toast.LENGTH_SHORT).show();
            } else {
                Boolean checkuserpass = dbHelper.checkusernamepassword(user, password);
                if (checkuserpass == true) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}