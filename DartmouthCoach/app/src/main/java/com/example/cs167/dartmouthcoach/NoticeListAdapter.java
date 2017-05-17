package com.example.cs167.dartmouthcoach;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.Model.Notice;

import java.util.List;

/**
 * Created by xinbeifu on 5/17/17.
 */

public class NoticeListAdapter extends ArrayAdapter<Notice> {

    private Context context;
    private List<Notice> data;

    public NoticeListAdapter(Context context, List<Notice> data){
        super(context, R.layout.list_item_notices, data);
        this.data = data;
        this.context = context;
    }

    @Override
    public void add(Notice notice){
        data.add(notice);
        notifyDataSetChanged();
    }

    @Override
    public Notice getItem(int i){ return data.get(i);}

    @Override
    public int getCount(){ return data.size();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get item for selected view
        Notice notice = getItem(position);

        final NoticeListAdapter.ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new NoticeListAdapter.ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_notices, parent, false);

            //binding view parts to view holder
            viewHolder.post_date = (TextView) convertView.findViewById(R.id.notice_post_date);
            viewHolder.title = (TextView) convertView.findViewById(R.id.notice_title);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (NoticeListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.post_date.setText(notice.getPost_date());
        viewHolder.title.setText(notice.getTitle());

        return convertView;
    }

    private class ViewHolder{
        TextView post_date;
        TextView title;
    }
}
