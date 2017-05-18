package com.example.cs167.dartmouthcoach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by xinbeifu on 5/17/17.
 */

public class UserProfile extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

    }

    public void onSaveClicked(View view){
        finish();
    }
}
