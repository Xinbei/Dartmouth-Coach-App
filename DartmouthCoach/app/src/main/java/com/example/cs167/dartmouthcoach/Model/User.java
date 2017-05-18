package com.example.cs167.dartmouthcoach.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xinbeifu on 5/17/17.
 */

public class User implements Parcelable {

    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPhoNum;
    private CreditCard userPayment;
    private int userGender;

    public User(){}

    public User(String userName, String userEmail, String userPassword, String userPhoNum, CreditCard userPayment, int userGender){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhoNum = userPhoNum;
        this.userPayment = userPayment;
        this.userGender = userGender;
    }

    public String getUserId(){return userId;}

    public void setUserId(String userId){this.userId = userId;}

    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName = userName;}

    public String getUserEmail(){return userEmail;}

    public void setUserEmail(String userEmail){this.userEmail = userEmail;}

    public String getUserPassword(){return userPassword;}

    public void setUserPassword(String userPassword){this.userPassword = userPassword;}

    public String getUserPhoNum(){return userPhoNum;}

    public void setUserPhoNum(String userPhoNum){this.userPhoNum = userPhoNum;}

    public CreditCard getUserPayment(){return userPayment;}

    public void setUserPayment(CreditCard userPayment){this.userPayment = userPayment;}

    public int getUserGender(){return userGender;}

    public void setUserGender(int userGender){this.userGender = userGender;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.userName);
        dest.writeString(this.userEmail);
        dest.writeString(this.userPassword);
        dest.writeString(this.userPhoNum);
        dest.writeParcelable(this.userPayment, flags);
        dest.writeInt(this.userGender);
    }

    protected User(Parcel in) {
        this.userId = in.readString();
        this.userName = in.readString();
        this.userEmail = in.readString();
        this.userPassword = in.readString();
        this.userPhoNum = in.readString();
        this.userPayment = in.readParcelable(CreditCard.class.getClassLoader());
        this.userGender = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
