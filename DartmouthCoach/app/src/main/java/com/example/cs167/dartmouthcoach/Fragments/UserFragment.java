package com.example.cs167.dartmouthcoach.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs167.dartmouthcoach.R;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class UserFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        addPreferencesFromResource(R.xml.user_center);
    }

}
