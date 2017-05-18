package com.example.cs167.dartmouthcoach.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cs167.dartmouthcoach.Authen.LoginActivity;
import com.example.cs167.dartmouthcoach.R;

/**
 * Created by xinbeifu on 5/18/17.
 */

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_profile_login, container, false);

        Button btn_login = (Button) rootView.findViewById(R.id.btn_switch_to_login);

        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return rootView;

    }

}
