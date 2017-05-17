package com.example.cs167.dartmouthcoach.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xinbeifu on 5/17/17.
 */

public class CreditCard implements Parcelable {

    private String cardNum;
    private String securityCode;
    private String expirationDate;
    private String cardHolderName;
    private String billingAddr;

    public CreditCard(){}

    public CreditCard(String cardNum, String securityCode, String expirationDate,
                      String cardHolderName, String billingAddr){
        this.cardNum = cardNum;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
        this.billingAddr = billingAddr;
    }

    public String getCardNum(){return cardNum;}

    public void setCardNum(String cardNum){this.cardNum = cardNum;}

    public String getSecurityCode(){return securityCode;}

    public void setSecurityCode(String securityCode){this.securityCode = securityCode;}

    public String getExpirationDate(){return expirationDate;}

    public void setExpirationDate(String expirationDate){this.expirationDate = expirationDate;}

    public String getCardHolderName(){return cardHolderName;}

    public void setCardHolderName(String cardHolderName){this.cardHolderName = cardHolderName;}

    public String getBillingAddr(){return billingAddr;}

    public void setBillingAddr(String billingAddr){this.billingAddr = billingAddr;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cardNum);
        dest.writeString(this.securityCode);
        dest.writeString(this.expirationDate);
        dest.writeString(this.cardHolderName);
        dest.writeString(this.billingAddr);
    }

    protected CreditCard(Parcel in) {
        this.cardNum = in.readString();
        this.securityCode = in.readString();
        this.expirationDate = in.readString();
        this.cardHolderName = in.readString();
        this.billingAddr = in.readString();
    }

    public static final Parcelable.Creator<CreditCard> CREATOR = new Parcelable.Creator<CreditCard>() {
        @Override
        public CreditCard createFromParcel(Parcel source) {
            return new CreditCard(source);
        }

        @Override
        public CreditCard[] newArray(int size) {
            return new CreditCard[size];
        }
    };
}
