package com.example.cs167.dartmouthcoach.Fragments;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cs167.dartmouthcoach.LocationAdapter;
import com.example.cs167.dartmouthcoach.Model.Order;
import com.example.cs167.dartmouthcoach.R;
import com.example.cs167.dartmouthcoach.RouteChooseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.cs167.dartmouthcoach.R.id.spinner;
import static com.example.cs167.dartmouthcoach.R.id.spinner2;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class TicketsFragment extends Fragment{
    private Order order;

    private Calendar mDateAndTime = Calendar.getInstance();

    private View rootView;

    private List<String> dest;
    private Spinner departure, destination, adults, children;
    private Button leaveDate, returnDate;
    private RadioGroup radioGroup;
    private Button search;
    boolean ifRoundTrip = false;


    private Date leaveDateObject;
    private Date returnDateObject;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] locationArray = getActivity().getResources().getStringArray( R.array.location_array);
        dest = new ArrayList<String>(Arrays.asList(locationArray));

        rootView = inflater.inflate(R.layout.fragment_tickets, container, false);
        departure = (Spinner) rootView.findViewById(spinner);
        destination = (Spinner) rootView.findViewById(spinner2);
        adults = (Spinner) rootView.findViewById(R.id.adults);
        children = (Spinner) rootView.findViewById(R.id.children);

        leaveDate = (Button) rootView.findViewById(R.id.leave_date);
        returnDate = (Button) rootView.findViewById(R.id.return_date);
        search = (Button) rootView.findViewById(R.id.search);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);


        order = new Order();


        final LocationAdapter srcAdapter = new LocationAdapter(getActivity(),
                android.R.layout.simple_spinner_item, dest);
        final LocationAdapter destAdapter = new LocationAdapter(getActivity(),
                android.R.layout.simple_spinner_item, dest);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.adult_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.children_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        departure.setAdapter(srcAdapter);
        destination.setAdapter(destAdapter);
        adults.setAdapter(adapter2);
        children.setAdapter(adapter3);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i == R.id.one_way){
                    order.setRoundtrip(false);
                }else if(i == R.id.round_trip){
                    order.setRoundtrip(true);
                }
            }
        });

        departure.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                destAdapter.resetEnabledList();
                order.setDeparture(i);
                switch (i){
                    case 0:break;
                    case 1:destAdapter.disableItem(1); break;
                    case 2: destAdapter.disableItem(2); break;
                    case 3: destAdapter.disableItem(6); destAdapter.disableItem(3); break;
                    case 4: destAdapter.disableItem(6); destAdapter.disableItem(4); break;
                    case 5: destAdapter.disableItem(6); destAdapter.disableItem(5); break;
                    case 6:
                        destAdapter.disableItem(3);
                        destAdapter.disableItem(4);
                        destAdapter.disableItem(5);
                        destAdapter.disableItem(6);
                        break;
                    default:
                        break;
                }
                destAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                order.setDestination(i);
                // TODO: add logic of preventing error route
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        leaveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog d = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker,
                                                  int year, int monthOfYear, int dayOfMonth) {
                                mDateAndTime.set(year, monthOfYear, dayOfMonth);
                                leaveDateObject = mDateAndTime.getTime();
                                leaveDate.setText(String.format("%d/%d/%d", monthOfYear+1,dayOfMonth,year));
                                order.setDate(leaveDateObject);
                            }
                        },
                        mDateAndTime.get(Calendar.YEAR),
                        mDateAndTime.get(Calendar.MONTH),
                        mDateAndTime.get(Calendar.DAY_OF_MONTH));

                d.show();
            }
        });

        returnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog d = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker,
                                                  int year, int monthOfYear, int dayOfMonth) {
                                mDateAndTime.set(year, monthOfYear, dayOfMonth);
                                returnDateObject = mDateAndTime.getTime();
                                order.setReturnDate(returnDateObject);
                                returnDate.setText(String.format("%d/%d/%d", monthOfYear+1,dayOfMonth, year));
                            }
                        },
                        mDateAndTime.get(Calendar.YEAR),
                        mDateAndTime.get(Calendar.MONTH),
                        mDateAndTime.get(Calendar.DAY_OF_MONTH));
                d.show();
            }
        });

        adults.setAdapter(adapter2);
        adults.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                order.setAdults(i+1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        children.setAdapter(adapter3);
        children.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                order.setChildren(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation())
                    toRouteChoosePage();
            }
        });

        return rootView;
    }

    private void toRouteChoosePage(){
        Intent intent = new Intent(getActivity(), RouteChooseActivity.class);
        Bundle b = new Bundle();
        b.putParcelable("order", order);
        intent.putExtras(b);
        startActivity(intent);
    }

    private boolean validation(){
        boolean flag = true;
        Date dt = new Date();
        mDateAndTime.setTime(dt);
        mDateAndTime.add(Calendar.DATE, -1);
        dt = mDateAndTime.getTime();
        if(order.getDeparture()==0 || order.getDestination()==0){
            Toast.makeText(getActivity(), "Invalid locations", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(order.getDate() == null || order.getDate().before(dt)){
            Toast.makeText(getActivity(), "Invalid dates", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(order.isRoundtrip()){
            if(order.getReturnDate()==null || order.getReturnDate().before(dt)){
                Toast.makeText(getActivity(), "Invalid dates", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }


}
