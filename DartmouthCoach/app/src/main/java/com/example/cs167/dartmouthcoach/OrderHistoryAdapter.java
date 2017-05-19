package com.example.cs167.dartmouthcoach;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.Model.Order;

import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */

public class OrderHistoryAdapter extends ArrayAdapter<Order> {

    List<Order> data;
    public OrderHistoryAdapter(@NonNull Context context, @NonNull List<Order> objects) {
        super(context, R.layout.list_item_order, objects);
        this.data = objects;
    }
    @Override
    public Order getItem(int i){ return data.get(i);}

    @Override
    public int getCount(){ return data.size();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get item for selected view
        Order r = data.get(position);

        final OrderHistoryAdapter.ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new OrderHistoryAdapter.ViewHolder();
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_order, parent, false);

            //binding view parts to view holder
            viewHolder.summary = (TextView) convertView.findViewById(R.id.summary);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (OrderHistoryAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.summary.setText(r.getSummaryForDisplay());



        return convertView;
    }

    private class ViewHolder{
        TextView summary;
    }
}
