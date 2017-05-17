package com.example.cs167.dartmouthcoach;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.Model.Notice;

/**
 * Created by xinbeifu on 5/17/17.
 */

public class MyDialogFragment extends DialogFragment {

    public static final String DIALOG_KEY = "dialog_key";

    private ViewHolder viewHolder = new ViewHolder();

    public static MyDialogFragment newInstance(Notice notice){
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(DIALOG_KEY, notice);
        myDialogFragment.setArguments(bundle);

        return myDialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        Notice notice = getArguments().getParcelable(DIALOG_KEY);

        LayoutInflater i = getActivity().getLayoutInflater();
        View v;
        v = i.inflate(R.layout.dialog_detail_notice, null);
        viewHolder.title = (TextView) v.findViewById(R.id.notice_title);
        viewHolder.content = (TextView) v.findViewById(R.id.notice_details);

        viewHolder.title.setText(notice.getTitle());
        viewHolder.content.setText(notice.getDetails());

        Button btn_ok = (Button) v.findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(v);

        return builder.create();
    }

    private static class ViewHolder{
        TextView title;
        TextView content;
    }
}
