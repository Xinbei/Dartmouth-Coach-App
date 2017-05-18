package com.example.cs167.dartmouthcoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cs167.dartmouthcoach.Authen.LoginActivity;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private String email;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mEmail = (EditText) findViewById(R.id.create_editEmail);
        mPassword = (EditText) findViewById(R.id.create_editPassword);
        mName = (EditText) findViewById(R.id.create_editName);
        findViewById(R.id.btnCreate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();

        if (email.equals("") ||
                !email.contains("@") ||
                password.equals("") ||
                email == null || password == null) {
            //if input is empty
            Toast.makeText(CreateAccountActivity.this,
                    "Invalid Email or Password",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            //if password is less than 6 character
            Toast.makeText(CreateAccountActivity.this,
                    "Invalid  Password, Password should have at least 6 characters",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(CreateAccountActivity.this,
                "Your account created!",
                Toast.LENGTH_SHORT).show();

        finish();
    }
}
