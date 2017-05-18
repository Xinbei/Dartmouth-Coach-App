package com.example.cs167.dartmouthcoach;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs167.dartmouthcoach.Model.Order;

import java.util.ArrayList;
import java.util.List;

public class PassengerInfoActivity extends AppCompatActivity {
    private Order order;
    List<TextView> lastnames;
    List<TextView> firstnames;
    LinearLayout nameSection;
    Spinner bags;
    Button next;
    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_info);
        setTitle("Passengers Info");
        Bundle b = getIntent().getExtras();
        order = b.getParcelable("order");
        if(order!=null){
            Toast.makeText(this,Global.LOCATION_LIST[order.getDeparture()],Toast.LENGTH_SHORT).show();
        }

        lastnames = new ArrayList<>();
        firstnames = new ArrayList<>();

        nameSection = (LinearLayout) findViewById(R.id.name_section);
        int people = order.getChildren()+order.getAdults();
        for(int i=0; i<people; i++){
            addNewName();
        }

        next = (Button) findViewById(R.id.next);
        summary = (TextView) findViewById(R.id.summary);

        summary.setText(order.getFinalSummary());

        bags=(Spinner) findViewById(R.id.spinner_bags);
        List<String> nums = new ArrayList<>();
        for(int i=0; i<people*3; i++){
            nums.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nums);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        bags.setAdapter(adapter);
        bags.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                order.setBags(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                toSummaryPage();
            }
        });




    }

    private void addNewName(){
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.HORIZONTAL);
        EditText f = new EditText(this);
        EditText la = new EditText(this);
        Space space = new Space(this);
        LinearLayout.LayoutParams param;
        param = new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, (float) 4.0);
        LinearLayout.LayoutParams spaceParam;
        spaceParam = new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, (float) 1.0);
        f.setTextColor(Color.GRAY);
        la.setTextColor(Color.GRAY);
        f.setLayoutParams(param);
        la.setLayoutParams(param);
        space.setLayoutParams(spaceParam);
        l.addView(f);
        l.addView(space);
        l.addView(la);
        lastnames.add(la);
        firstnames.add(f);
        nameSection.addView(l);
    }

    private void saveData(){
        for (int i=0; i<order.getAdults()+order.getChildren(); i++){
            order.getFirstname().add(firstnames.get(i).getText().toString());
            order.getLastname().add(lastnames.get(i).getText().toString());
        }
    }

    private void toSummaryPage(){
        Intent intent = new Intent(this, OrderSummaryActivity.class);
        Bundle b = new Bundle();
        b.putParcelable("order", order);
        intent.putExtras(b);
        startActivity(intent);
    }
}
