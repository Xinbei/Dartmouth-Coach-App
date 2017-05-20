package com.example.cs167.dartmouthcoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs167.dartmouthcoach.Model.Order;

public class OrderSummaryActivity extends AppCompatActivity {

    private int price = 38;
    private int returnPrice = 52;
    private Order order;
    private TextView nameList, priceList;
    private TextView bagFare, bagNum, totalAmount;
    private TextView summary;
    private int bagPrice;
    private Button next;
    static OrderSummaryActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        setTitle("Ticket Details");
        instance = this;
        Bundle b = getIntent().getExtras();
        order = b.getParcelable("order");

        nameList = (TextView) findViewById(R.id.name_list);
        priceList = (TextView) findViewById(R.id. price_list);
        bagFare = (TextView) findViewById(R.id.bag_fare);
        bagNum = (TextView) findViewById(R.id.bag_num);
        totalAmount = (TextView) findViewById(R.id.total_amount);
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPaymentPage();
            }
        });

        calculatePrice();
        displaySummary();

    }

    private void calculatePrice(){
        int people = order.getChildren()+order.getAdults();
        int sum;
        if(order.isRoundtrip()){
            sum = returnPrice * people;
        }else{
            sum = price *people;
        }
        if(order.getBags()>people*2){
            bagPrice = (order.getBags() - people*2)*5;
            sum += bagPrice;
        }
        order.setPrice(sum);
    }

    private void displaySummary(){
        summary = (TextView) findViewById(R.id.summary);
        summary.setText(order.getFinalSummary());
        String ns = "";
        String ps = "";
        for(int i=0; i<order.getLastname().size(); i++){
            ns += (order.getFirstname().get(i)+" "+order.getLastname().get(i)+"\n");
            ps += ("$" +((order.isRoundtrip())?returnPrice: price) + "\n");
        }
        nameList.setText(ns);
        priceList.setText(ps);
        bagNum.setText("Checked Bags: "+order.getBags());
        bagFare.setText("Bags Fare: "+bagPrice);
        totalAmount.setText("Total Amount: $"+order.getPrice());

    }

    private void toPaymentPage(){
        Intent intent = new Intent(this, PaymentInfoActivity.class);
        Bundle b = new Bundle();
        b.putParcelable("order", order);
        intent.putExtras(b);
        startActivity(intent);
    }

    public static OrderSummaryActivity getInstance(){
        return instance;
    }
}
