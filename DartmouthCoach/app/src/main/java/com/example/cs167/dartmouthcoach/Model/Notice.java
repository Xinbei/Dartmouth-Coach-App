package com.example.cs167.dartmouthcoach.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xinbeifu on 5/17/17.
 */

public class Notice implements Parcelable {

    private String post_date;
    private String title;
    private String details;

    public Notice(){}

    public Notice(String post_date, String title, String details){
        this.post_date = post_date;
        this.title = title;
        this.details = details;
    }

    public String getPost_date(){return post_date;}

    public void setDate(String post_date){this.post_date = post_date;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public String getDetails(){return details;}

    public void setDetails(String details){this.details = details;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.post_date);
        dest.writeString(this.title);
        dest.writeString(this.details);
    }

    protected Notice(Parcel in) {
        this.post_date = in.readString();
        this.title = in.readString();
        this.details = in.readString();
    }

    public static final Parcelable.Creator<Notice> CREATOR = new Parcelable.Creator<Notice>() {
        @Override
        public Notice createFromParcel(Parcel source) {
            return new Notice(source);
        }

        @Override
        public Notice[] newArray(int size) {
            return new Notice[size];
        }
    };
}
