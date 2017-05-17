package com.example.cs167.dartmouthcoach;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.cs167.dartmouthcoach.Fragments.DiscountFragment;
import com.example.cs167.dartmouthcoach.Fragments.NoticesFragment;
import com.example.cs167.dartmouthcoach.Fragments.ScheduleFragment;
import com.example.cs167.dartmouthcoach.Fragments.TicketsFragment;
import com.example.cs167.dartmouthcoach.Fragments.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int PERMISSIONS_REQUEST = 1;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private TicketsFragment ticketsFragment;
    private ScheduleFragment scheduleFragment;
    private DiscountFragment discountFragment;
    private NoticesFragment noticesFragment;
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check user permissions
        checkPermission(this);
        pageSetup();

    }

    // set up all fragments for the view pager
    public void pageSetup(){
        ticketsFragment = new TicketsFragment();
        scheduleFragment = new ScheduleFragment();
        discountFragment = new DiscountFragment();
        noticesFragment = new NoticesFragment();
        userFragment = new UserFragment();

        fragments = new ArrayList<Fragment>();
        fragments.add(ticketsFragment);
        fragments.add(scheduleFragment);
        fragments.add(discountFragment);
        fragments.add(noticesFragment);
        fragments.add(userFragment);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getFragmentManager(), fragments, this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOffscreenPageLimit(5);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        // hide keyboard for other fragments
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                try {
                    imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
                }catch (Exception e) {}
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void checkPermission(Activity activity){
        if(Build.VERSION.SDK_INT < 23) return;
        boolean i,r,w;
        i = ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET) !=
                PackageManager.PERMISSION_GRANTED;
        r = ContextCompat.checkSelfPermission(
                activity, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED;
        w = ContextCompat.checkSelfPermission(
                activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED;
        if(i || r || w ){
            List<String> s = new ArrayList<String>();
            if(i)
                s.add(Manifest.permission.INTERNET);
            if(r)
                s.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            if(w)
                s.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            String[] permissions = new String[s.size()];
            s.toArray(permissions);
            ActivityCompat.requestPermissions(activity, permissions, PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                boolean a = false;
                if (grantResults.length == permissions.length) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED)
                            a = true;
                    }
                } else {
                    a = true;
                }
                if (a) {
                    Toast.makeText(this, "Sorry, but we need these permissions :)",
                            Toast.LENGTH_SHORT);
                    checkPermission(this);
                }
                return;
            }

        }
    }
}
