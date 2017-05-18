package com.example.cs167.dartmouthcoach;

import com.example.cs167.dartmouthcoach.Model.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinbeifu on 5/14/17.
 */

public class Global {
    public static final String USER_NAME = "username";
    public static final String USER_EMAIL = "email";

    public static final String LOGIN_METHOD_KEY = "login_method_key";
    public static final String EMAIL_LOGIN = "email_login";
    public static final String GUEST_LOGIN = "guest_login";

    public static final String[] LOCATION_LIST = {"None", "Hanover","Lebanon",
            "New London","South Station", "Logan Airport", "New York"};

    public static final List<Route> BOSTON_SERVICE_SOUTHBOUND = new ArrayList<>();
    public static final List<Route> NEW_YORK_SERVICE = new ArrayList<>();

    public static final List<Route> BOSTON_SERVICE_NORTHBOUND = new ArrayList<>();

    static {
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("5:00 AM", "8:05 AM", 1, 35));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("7:00 AM", "9:50 AM", 2, 33));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("9:00 AM", "11:50 AM", 3, 12));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("11:00 AM", "2:50 PM", 4, 13));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("12:00 AM", "1:50 PM", 5, 15));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("1:00 PM", "3:50 PM", 6, 26));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("2:00 PM", "4:50 PM", 7, 25));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("3:00 PM", "5:50 PM", 8, 36));
        BOSTON_SERVICE_SOUTHBOUND.add(new Route("5:00 PM", "7:50 PM", 9, 2));
    }

    static {
        BOSTON_SERVICE_NORTHBOUND.add(new Route("8:55 AM", "12:00 PM", 1, 35));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("10:55 AM", "2:00 PM", 2, 33));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("12:55 PM", "4:00 PM", 3, 12));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("2:55 PM", "6:00 PM", 4, 13));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("3:55 PM", "7:00 PM", 5, 15));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("4:55 PM", "8:00 PM", 6, 26));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("5:55 PM", "9:00 PM", 7, 25));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("6:55 PM", "10:00 PM", 8, 36));
        BOSTON_SERVICE_NORTHBOUND.add(new Route("8:55 PM", "12:00 PM", 9, 2));
    }
}
