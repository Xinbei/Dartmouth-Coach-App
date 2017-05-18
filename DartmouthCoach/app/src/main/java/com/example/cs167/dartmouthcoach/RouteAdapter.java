package com.example.cs167.dartmouthcoach;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.Model.Route;

import java.util.List;

import static com.example.cs167.dartmouthcoach.R.id.route;

/**
 * Created by apple on 2017/5/17.
 */

public class RouteAdapter extends ArrayAdapter<Route> {

    List<Route> routes;

    public RouteAdapter(@NonNull Context context,@NonNull List<Route> objects) {
        super(context, R.layout.list_item_route, objects);
        routes = objects;
    }

    @Override
    public int getCount(){
        return routes.size();
    }

    @Override
    public Route getItem(int i){
        return routes.get(i);
    }



    public View getView(int position, View convertView, ViewGroup parent){

        //get item for selected view
        Route r = routes.get(position);

        final RouteAdapter.ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new RouteAdapter.ViewHolder();
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_route, parent, false);

            //binding view parts to view holder
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            viewHolder.route = (TextView) convertView.findViewById(route);
            viewHolder.ava = (TextView) convertView.findViewById(R.id.ava);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (RouteAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.time.setText(r.getTimeString());
        viewHolder.route.setText(String.valueOf(r.getRoute()));
        viewHolder.ava.setText(String.valueOf(r.getAvaSeats()));

        return convertView;
    }

    private class ViewHolder{
        TextView time;
        TextView route;
        TextView ava;
    }


}
