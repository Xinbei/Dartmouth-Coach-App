package com.example.cs167.dartmouthcoach.Fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.R;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class ScheduleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        drawBostonTable(rootView);
        drawNYCSouthTable(rootView);
        drawNYCNorthTable(rootView);

        final LinearLayout boston_schedue = (LinearLayout) rootView.findViewById(R.id.boston_schedule);
        final LinearLayout nyc_schedule = (LinearLayout) rootView.findViewById(R.id.nyc_schedule);

        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.boston){
                    nyc_schedule.setVisibility(View.GONE);
                    boston_schedue.setVisibility(View.VISIBLE);
                }else{
                    boston_schedue.setVisibility(View.GONE);
                    nyc_schedule.setVisibility(View.VISIBLE);

                }
            }
        });

        return rootView;
    }

    private void drawNYCSouthTable(View rootView){

        String[][] data = new String[5][3];

        data[0] = getActivity().getResources().getStringArray(R.array.nyc_south_row1);
        data[1] = getActivity().getResources().getStringArray(R.array.nyc_south_row2);
        data[2] = getActivity().getResources().getStringArray(R.array.nyc_south_row3);
        data[3] = getActivity().getResources().getStringArray(R.array.nyc_south_row4);
        data[4] = getActivity().getResources().getStringArray(R.array.nyc_south_row5);

        drawNYCTable(rootView.findViewById(R.id.nyc_south), data);

    }

    private void drawNYCNorthTable(View rootView){

        String[][] data = new String[5][3];

        data[0] = getActivity().getResources().getStringArray(R.array.nyc_north_row1);
        data[1] = getActivity().getResources().getStringArray(R.array.nyc_north_row2);
        data[2] = getActivity().getResources().getStringArray(R.array.nyc_north_row3);
        data[3] = getActivity().getResources().getStringArray(R.array.nyc_north_row4);
        data[4] = getActivity().getResources().getStringArray(R.array.nyc_north_row5);

        drawNYCTable(rootView.findViewById(R.id.nyc_north), data);
    }

    private void drawNYCTable(View v, String[][] data){

        TableLayout tableLayout = (TableLayout) v;

        int width1 = (int) getActivity().getResources().getDimension(R.dimen.col_width5);
        int width2 = (int) getActivity().getResources().getDimension(R.dimen.col_width4);
        int height1 = (int) getActivity().getResources().getDimension(R.dimen.col_height1);
        int height2 = (int) getActivity().getResources().getDimension(R.dimen.col_height2);

        float titleSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 14,
                getResources().getDisplayMetrics());

        float textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 14,
                getResources().getDisplayMetrics());

        for(int i = 0; i < 5; i++){

            TableRow tableRow = new TableRow(getActivity());
            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(params);

            for(int j = 0; j < 3; j++){
                TextView col = new TextView(getActivity());
                col.setBackgroundResource(R.drawable.cell_shape);
                col.setText(data[i][j]);
                col.setTextSize(textSize);
                if(i == 0) {
                    col.setHeight(height1);
                    col.setTextSize(titleSize);
                    col.setTypeface(null, Typeface.BOLD);
                    col.setTextColor(getActivity().getResources().getColor(R.color.color1));
                }else{
                    col.setGravity(Gravity.CENTER);
                    col.setHeight(height2);
                }
                if(j == 0 || j == 2){
                    col.setWidth(width1);
                }else{
                    col.setWidth(width2);
                }
                tableRow.addView(col);
            }

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

        }

    }

    private void drawBostonTable(View v){

        TableLayout tableLayout = (TableLayout) v.findViewById(R.id.boston_north);

        int width1 = (int) getActivity().getResources().getDimension(R.dimen.col_width1);
        int width2 = (int) getActivity().getResources().getDimension(R.dimen.col_width2);
        int width3 = (int) getActivity().getResources().getDimension(R.dimen.col_width3);

        int height1 = (int) getActivity().getResources().getDimension(R.dimen.col_height1);
        int height2 = (int) getActivity().getResources().getDimension(R.dimen.col_height3);

        float titleSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 10,
                getResources().getDisplayMetrics());

        float textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 14,
                getResources().getDisplayMetrics());

        String[][] data = new String[10][5];

        data[0] = getActivity().getResources().getStringArray(R.array.boston_north_row1);
        data[1] = getActivity().getResources().getStringArray(R.array.boston_north_row2);
        data[2] = getActivity().getResources().getStringArray(R.array.boston_north_row3);
        data[3] = getActivity().getResources().getStringArray(R.array.boston_north_row4);
        data[4] = getActivity().getResources().getStringArray(R.array.boston_north_row5);
        data[5] = getActivity().getResources().getStringArray(R.array.boston_north_row6);
        data[6] = getActivity().getResources().getStringArray(R.array.boston_north_row7);
        data[7] = getActivity().getResources().getStringArray(R.array.boston_north_row8);
        data[8] = getActivity().getResources().getStringArray(R.array.boston_north_row9);
        data[9] = getActivity().getResources().getStringArray(R.array.boston_north_row10);

        for(int i = 0; i < 10; i++){

            TableRow tableRow = new TableRow(getActivity());
            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(params);

            for(int j = 0; j < 5; j++){

                TextView col = new TextView(getActivity());
                col.setBackgroundResource(R.drawable.cell_shape);
                col.setText(data[i][j]);
                col.setWidth(width1);
                col.setTextSize(textSize);
                if(i == 0) {
                    col.setHeight(height1);
                    col.setTextSize(titleSize);
                    col.setTypeface(null, Typeface.BOLD);
                    col.setTextColor(getActivity().getResources().getColor(R.color.color1));
                }else{
                    col.setGravity(Gravity.CENTER);
                    col.setHeight(height2);
                }
                if(j == 0 || j == 4){
                    col.setWidth(width3);
                }else{
                    col.setWidth(width2);
                }
                tableRow.addView(col);
            }

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

        }
    }

}
