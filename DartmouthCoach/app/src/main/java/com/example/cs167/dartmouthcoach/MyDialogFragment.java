package com.example.cs167.dartmouthcoach;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.Model.Notice;

/**
 * Created by xinbeifu on 5/17/17.
 */

public class MyDialogFragment extends DialogFragment {

    public static final String NOTICE_DIALOG_KEY = "notice_dialog_key";
    public static final String DISCOUNT_DIALOG_TITLE_KEY = "discount_title_key";
    public static final String DISCOUNT_DIALOG_CONTENT_KEY = "discount_content_key";

    public static final String DIALOG_SOURCE = "dialog_source";

    public static final String DISCOUNT_DIALOG_ID = "discount_dialog_id";

    private ViewHolder viewHolder = new ViewHolder();

    public static MyDialogFragment newInstance(Notice notice){
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DIALOG_SOURCE, 0);
        bundle.putParcelable(NOTICE_DIALOG_KEY, notice);
        myDialogFragment.setArguments(bundle);

        return myDialogFragment;
    }

    public static MyDialogFragment newInstance(int discountId, String title, String content){
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DIALOG_SOURCE, 1);
        bundle.putInt(DISCOUNT_DIALOG_ID, discountId);
        bundle.putString(DISCOUNT_DIALOG_TITLE_KEY, title);
        bundle.putString(DISCOUNT_DIALOG_CONTENT_KEY, content);
        myDialogFragment.setArguments(bundle);

        return myDialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        LayoutInflater i = getActivity().getLayoutInflater();
        View v;
        v = i.inflate(R.layout.dialog, null);
        viewHolder.title = (TextView) v.findViewById(R.id.dialog_title);
        viewHolder.content = (TextView) v.findViewById(R.id.dialog_content);

        Button btn_ok = (Button) v.findViewById(R.id.btn_ok);
        Button btn_purchase = (Button) v.findViewById(R.id.btn_purchase);

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        p.weight = 1;

        if(getArguments().getInt(DIALOG_SOURCE) == 0){

            Notice notice = getArguments().getParcelable(NOTICE_DIALOG_KEY);

            viewHolder.title.setText(notice.getTitle());
            viewHolder.content.setText(notice.getDetails());

            btn_ok.setLayoutParams(p);
            btn_purchase.setVisibility(View.GONE);

        }

        if(getArguments().getInt(DIALOG_SOURCE) == 1){

            int discountId = getArguments().getInt(DISCOUNT_DIALOG_ID);
            String title = getArguments().getString(DISCOUNT_DIALOG_TITLE_KEY);
            String content = getArguments().getString(DISCOUNT_DIALOG_CONTENT_KEY);

            viewHolder.title.setText(title);
            viewHolder.content.setText(content);

            if(discountId != 1){

                btn_purchase.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view){
                        //TODO: go to buying tickets activity
                    }
                });
            }else{

                btn_ok.setLayoutParams(p);
                btn_purchase.setVisibility(View.GONE);

            }

        }

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
