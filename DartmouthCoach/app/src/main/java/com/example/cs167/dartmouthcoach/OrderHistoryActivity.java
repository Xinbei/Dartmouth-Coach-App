package com.example.cs167.dartmouthcoach;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.cs167.dartmouthcoach.Model.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity {

    public static final String MY_PREFERENCES = "MyPrefs" ;
    public static final String ORDER_LIST = "orderList";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private ListView orderListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        setTitle("Order History");
        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String listJson = sharedPreferences.getString(ORDER_LIST, "");
        List<Order> orderList;
        if(listJson.isEmpty()){
            orderList = new ArrayList<>();
        }else {
            orderList = gson.fromJson(listJson, new TypeToken<List<Order>>(){}.getType());
        }

        orderListView = (ListView) findViewById(R.id.order_list);

        OrderHistoryAdapter adapter = new OrderHistoryAdapter(this,orderList);
        orderListView.setAdapter(adapter);
    }
}
