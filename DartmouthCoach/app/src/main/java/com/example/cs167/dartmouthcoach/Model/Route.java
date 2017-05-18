package com.example.cs167.dartmouthcoach.Model;

/**
 * Created by apple on 2017/5/17.
 */

public class Route {
    private String time1;
    private String time2;
    private int avaSeats;
    private int route;

    public Route(String t1, String t2, int route, int avaSeats){
        this.time1 = t1;
        this.time2 = t2;
        this.avaSeats = avaSeats;
        this.route = route;
    }

    public String getTimeString(){
        return time1+" -- "+time2;
    }

    public int getAvaSeats() {
        return avaSeats;
    }

    public void setAvaSeats(int avaSeats) {
        this.avaSeats = avaSeats;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }
}
