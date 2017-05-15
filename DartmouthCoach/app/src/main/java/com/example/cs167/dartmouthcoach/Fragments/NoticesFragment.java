package com.example.cs167.dartmouthcoach.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs167.dartmouthcoach.R;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class NoticesFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notices, container, false);

        return rootView;
    }

}
