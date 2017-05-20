package com.example.cs167.dartmouthcoach;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cs167.dartmouthcoach.Model.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class PaymentInfoActivity extends AppCompatActivity {
    public static final String MY_PREFERENCES = "MyPrefs" ;
    public static final String ORDER_LIST = "orderList";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private Order order;
    private Button pay;
    static PaymentInfoActivity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);
        setTitle("Payment Info");
        Bundle b = getIntent().getExtras();
        order = b.getParcelable("order");
        instance = this;

        if(order!=null){
            Toast.makeText(this,Global.LOCATION_LIST[order.getDeparture()],Toast.LENGTH_SHORT).show();
        }

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        pay = (Button)findViewById(R.id.next);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveOrder();
                toConfirmationPage();
            }
        });

    }

    private void saveOrder(){
        Gson gson = new Gson();
        String listJson = sharedPreferences.getString(ORDER_LIST, "");
        List<Order> orderList;
        if(listJson.isEmpty()){
            orderList = new ArrayList<>();
        }else {
            orderList = gson.fromJson(listJson, new TypeToken<List<Order>>(){}.getType());
        }
        orderList.add(order);
        String newListJson = gson.toJson(orderList);
        editor.putString(ORDER_LIST,newListJson);
        editor.commit();
    }
    private void toConfirmationPage(){

        Intent intent = new Intent(this, ConfirmationActivity.class);
        Bundle b = new Bundle();
        b.putParcelable("order", order);
        intent.putExtras(b);
        startActivity(intent);

    }



    public static PaymentInfoActivity getInstance(){
        return instance;
    }
}
