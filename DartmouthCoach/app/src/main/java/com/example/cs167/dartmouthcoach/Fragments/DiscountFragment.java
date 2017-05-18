package com.example.cs167.dartmouthcoach.Fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.cs167.dartmouthcoach.MyDialogFragment;
import com.example.cs167.dartmouthcoach.R;

import java.util.ArrayList;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class DiscountFragment extends Fragment{

    private ImageView boston_sdrt;
    private ImageView ten_ride;
    private ImageView children_discount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discount, container, false);

        boston_sdrt = (ImageView) rootView.findViewById(R.id.sameday);
        ten_ride = (ImageView) rootView.findViewById(R.id.commuter);
        children_discount = (ImageView) rootView.findViewById(R.id.children);

        boston_sdrt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MyDialogFragment dialog = MyDialogFragment.newInstance(1, "Same-Day Round-Trip",
                        getActivity().getResources().getString(R.string.discount_sdrt_content));
                dialog.show(getFragmentManager(), "dialog");
            }
        });

        ten_ride.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MyDialogFragment dialog = MyDialogFragment.newInstance(2, "10 Ride Commuter Pass",
                        getActivity().getResources().getString(R.string.discount_commuter_content));
                dialog.show(getFragmentManager(), "dialog");
            }
        });

        children_discount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MyDialogFragment dialog = MyDialogFragment.newInstance(3, "Children's Deals & Discounts",
                        getActivity().getResources().getString(R.string.discount_children));
                dialog.show(getFragmentManager(), "dialog");
            }
        });

        return rootView;
    }

}
