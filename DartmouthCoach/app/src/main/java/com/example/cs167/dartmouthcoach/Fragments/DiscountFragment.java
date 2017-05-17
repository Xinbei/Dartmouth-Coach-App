package com.example.cs167.dartmouthcoach.Fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cs167.dartmouthcoach.R;

import java.util.ArrayList;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class DiscountFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discount, container, false);

        return rootView;
    }
}
