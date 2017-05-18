package com.example.cs167.dartmouthcoach;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/5/17.
 */

public class LocationAdapter extends ArrayAdapter<String> {

    private List<String> locations;
    private List<Boolean> enabled;

    public LocationAdapter(@NonNull Context context, @LayoutRes
            int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        locations = objects;
        enabled = new ArrayList<Boolean>();
        this.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for(int i=0; i<locations.size(); i++){
            enabled.add(Boolean.TRUE);
        }
    }

    @Override
    public int getCount() {
        return locations.size();
    }

    public void resetEnabledList(){
        for(int i=0; i<enabled.size(); i++) {
             enabled.set(i,Boolean.TRUE);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }



    @Override
    public boolean isEnabled(int position) {
        return enabled.get(position);
    }

    public List<Boolean> getEnabledList(){
        return enabled;
    }

    public void disableItem(int i){
        if(i<getCount()){
            enabled.set(i, false);
        }
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        // TODO Auto-generated method stub
        /*View mView = super.getDropDownView(position, convertView, parent);

        TextView mTextView = (TextView) mView;
        if (!enabled.get(position)) {
            mTextView.setTextColor(getContext().getResources().getColor(R.color.disable));
        }else{
            mTextView.setTextColor(Color.GRAY);
        }
        return mView;*/
        View v = null;
        if (!enabled.get(position)) {
            TextView tv = new TextView(getContext());
            tv.setVisibility(View.GONE);
            tv.setHeight(0);
            v = tv;

        } else {
            v = super.getDropDownView(position, null, parent);
        }
        return v;
    }

}
