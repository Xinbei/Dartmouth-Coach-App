package com.example.cs167.dartmouthcoach.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.cs167.dartmouthcoach.R;

import java.util.List;

import static com.example.cs167.dartmouthcoach.R.id.spinner;
import static com.example.cs167.dartmouthcoach.R.id.spinner2;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class TicketsFragment extends Fragment{

    private View rootView;
    private List<String> locations;
    Spinner departure, destination, adults, children;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Mapview setup
        rootView = inflater.inflate(R.layout.fragment_tickets, container, false);
        departure = (Spinner) rootView.findViewById(spinner);
        destination = (Spinner) rootView.findViewById(spinner2);
        adults = (Spinner) rootView.findViewById(R.id.adults);
        children = (Spinner) rootView.findViewById(R.id.children);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.location_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        departure.setAdapter(adapter);
        destination.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.adult_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.children_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adults.setAdapter(adapter2);
        children.setAdapter(adapter3);
        return rootView;
    }

}
