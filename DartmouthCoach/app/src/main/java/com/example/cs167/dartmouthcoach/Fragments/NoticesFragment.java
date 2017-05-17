package com.example.cs167.dartmouthcoach.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.Model.Notice;
import com.example.cs167.dartmouthcoach.MyDialogFragment;
import com.example.cs167.dartmouthcoach.NoticeListAdapter;
import com.example.cs167.dartmouthcoach.R;

import java.util.ArrayList;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class NoticesFragment extends Fragment{

    private ListView list;
    private NoticeListAdapter noticeListAdapter;
    private ArrayList<Notice> notices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notices, container, false);

        list = (ListView) rootView.findViewById(R.id.notice_list);
        notices = new ArrayList<>();

        String details = "Due to high demand, we are offering additional service\n\n" +
                "Sunday, June 11 – Lebanon 3:15pm/Hanover 3:30pm to NYC 8:30pm\n\n" +
                "Ensure your seat by booking early!\n";

        final Notice notice = new Notice("Posted April 18, 2017", "Additional Dartmouth Commencement Weekend Service", details);

        notices.add(notice);

        noticeListAdapter = new NoticeListAdapter(getActivity(), notices);
        list.setAdapter(noticeListAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                displayDetails(notices.get(i));
            }
        });

        return rootView;
    }

    void displayDetails(Notice notice){
        MyDialogFragment myDialogFragment = MyDialogFragment.newInstance(notice);
        myDialogFragment.show(getFragmentManager(), "dialog");
    }

}
