package com.example.cs167.dartmouthcoach;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs167.dartmouthcoach.Model.Order;

/**
 * Created by apple on 2017/5/17.
 */

public class RouteChooseActivity extends AppCompatActivity {
    private Order order;
    private TextView timeTitle;
    private TextView summary;
    private ListView routeLeave;
    private ListView routeReturn;

    private int route1 = -1, route2 = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_choose);

        Bundle b = getIntent().getExtras();
        order = b.getParcelable("order");
        setTitle(order.getDeptAndDest());
        if(order!=null){
            Toast.makeText(this,Global.LOCATION_LIST[order.getDeparture()],Toast.LENGTH_SHORT).show();
        }
        timeTitle = (TextView) findViewById(R.id.time_title);
        summary = (TextView) findViewById(R.id.summary);
        timeTitle.setText(order.getDeptAndDest());
        summary.setText(order.getSummaryForRoute());

        routeLeave = (ListView) findViewById(R.id.list_route_leave);
        final RouteAdapter adapter = new RouteAdapter(this, Global.BOSTON_SERVICE_SOUTHBOUND);
        routeLeave.setAdapter(adapter);
        routeLeave.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapter.getRoute() < 0){
                    adapter.setRoute(i);
                    view.setBackgroundColor(getResources().getColor(R.color.color1));
                    TextView t = (TextView)view.findViewById(R.id.time);
                    t.setTextColor(Color.WHITE);
                    t = (TextView)view.findViewById(R.id.route);
                    t.setTextColor(Color.WHITE);
                    t = (TextView)view.findViewById(R.id.ava);
                    t.setTextColor(Color.WHITE);
                }else{
                    adapter.notifyDataSetChanged();
                    adapter.setRoute(i);
                    view.setBackgroundColor(getResources().getColor(R.color.color1));
                    TextView t = (TextView)view.findViewById(R.id.time);
                    t.setTextColor(Color.WHITE);
                    t = (TextView)view.findViewById(R.id.route);
                    t.setTextColor(Color.WHITE);
                    t = (TextView)view.findViewById(R.id.ava);
                    t.setTextColor(Color.WHITE);

                }

            }
        });



    }
}
