package com.example.cs167.dartmouthcoach.Authen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cs167.dartmouthcoach.R;
import com.example.cs167.dartmouthcoach.MainActivity;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // START:set button OnClickListener
        findViewById(R.id.btnForgetPassword).setOnClickListener(this);
        findViewById(R.id.btnNewAcc).setOnClickListener(this);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btn_google_signin).setOnClickListener(this);
        findViewById(R.id.btnGuest).setOnClickListener(this);
        // END: set button onclick listener

    }

    @Override
    public void onStart(){
        super.onStart();
        //addAuthListener to mAuth
    }

    @Override
    public void onStop(){
        super.onStop();
        //removeAuthListener from mAuth

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // START: create_new_account
            case R.id.btnNewAcc:
                break;
            // END: create_new_account

            // START: sign_in_with_email_and_password
            case R.id.btnLogin:
                Intent int_email = new Intent(this,MainActivity.class);
                startActivity(int_email);
                finish();
                break;
            // END: sign_in_with_email_and_password

            // START:continue_as_guest
            case R.id.btnGuest:
                Intent int_guest = new Intent(this,MainActivity.class);
                startActivity(int_guest);
                finish();
                break;
            // END:continue_as_guest

            // START:sign_in_with_google_account
            case R.id.btn_google_signin:
                // END: sign_in_with_google_account

                // START: SEND PASSWORD RESET EMAIL
            case R.id.btnForgetPassword:
                break;
            // END: SEND PASSWORD RESET EMAIL

            default:break;
        }
    }

}
