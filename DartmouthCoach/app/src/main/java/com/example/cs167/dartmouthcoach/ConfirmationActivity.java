package com.example.cs167.dartmouthcoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConfirmationActivity extends AppCompatActivity {

    private Button viewOrder;
    private Button setReminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        setTitle("Payment Confirmation");
        closeOtherActivities();

        viewOrder = (Button) findViewById(R.id.view_order);
        viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHistoryPage();
            }
        });

    }

    private void toHistoryPage(){
        Intent intent = new Intent(this, OrderHistoryActivity.class);
        startActivity(intent);
        finish();
    }

    public void closeOtherActivities(){
        RouteChooseActivity.getInstance().finish();
        PassengerInfoActivity.getInstance().finish();
        OrderSummaryActivity.getInstance().finish();
        PaymentInfoActivity.getInstance().finish();
    }
}
