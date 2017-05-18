package com.example.cs167.dartmouthcoach.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by apple on 2017/5/17.
 */

public class Order implements Parcelable {
    private Date date;
    private int departure, destination;
    private int adults, children;
    private int route;
    private List<String> firstname, lastname;
    private int bags, price;
    private int ticketNum;
    private boolean roundtrip;

    public Order(){
        firstname = new ArrayList<>();
        lastname = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public List<String> getFirstname() {
        return firstname;
    }

    public void setFirstname(List<String> firstname) {
        this.firstname = firstname;
    }

    public List<String> getLastname() {
        return lastname;
    }

    public void setLastname(List<String> lastname) {
        this.lastname = lastname;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public boolean isRoundtrip() {
        return roundtrip;
    }

    public void setRoundtrip(boolean roundtrip) {
        this.roundtrip = roundtrip;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeInt(this.departure);
        dest.writeInt(this.destination);
        dest.writeInt(this.adults);
        dest.writeInt(this.children);
        dest.writeInt(this.route);
        dest.writeStringList(this.firstname);
        dest.writeStringList(this.lastname);
        dest.writeInt(this.bags);
        dest.writeInt(this.price);
        dest.writeInt(this.ticketNum);
        dest.writeByte(this.roundtrip ? (byte) 1 : (byte) 0);
    }

    protected Order(Parcel in) {
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.departure = in.readInt();
        this.destination = in.readInt();
        this.adults = in.readInt();
        this.children = in.readInt();
        this.route = in.readInt();
        this.firstname = in.createStringArrayList();
        this.lastname = in.createStringArrayList();
        this.bags = in.readInt();
        this.price = in.readInt();
        this.ticketNum = in.readInt();
        this.roundtrip = in.readByte() != 0;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
