package com.example.raihan.foodforall.Object;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodRequest implements Parcelable{


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("contno")
    @Expose
    private String contno;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("expiretime")
    @Expose
    private String foodtype;

    @SerializedName("fooddesc")
    @Expose
    private String fooddesc;

    @SerializedName("pickuptime")
    @Expose
    private String pickuptime;

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("amount")
    @Expose
    private int amount;

    @SerializedName("volunteerAmount")
    @Expose
    private int volunteerAmount;

    public FoodRequest() {
    }

    public FoodRequest(String id, String location, String contno, String userid, String foodtype, String fooddesc, String pickuptime, String response, String state, int amount,int volunteerAmount) {

        this.id = id;
        this.location = location;
        this.contno = contno;
        this.userid = userid;
        this.foodtype = foodtype;
        this.fooddesc = fooddesc;
        this.pickuptime = pickuptime;
        this.response = response;
        this.state = state;
        this.amount = amount;
        this.volunteerAmount = volunteerAmount;
    }

    protected FoodRequest(Parcel in) {
        id = in.readString();
        location = in.readString();
        contno = in.readString();
        userid = in.readString();
        foodtype = in.readString();
        fooddesc = in.readString();
        pickuptime = in.readString();
        response = in.readString();
        state = in.readString();
        amount = in.readInt();
        volunteerAmount = in.readInt();
    }

    public static final Creator<FoodRequest> CREATOR = new Creator<FoodRequest>() {
        @Override
        public FoodRequest createFromParcel(Parcel in) {
            return new FoodRequest(in);
        }

        @Override
        public FoodRequest[] newArray(int size) {
            return new FoodRequest[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContno() {
        return contno;
    }

    public void setContno(String contno) {
        this.contno = contno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public String getFooddesc() {
        return fooddesc;
    }

    public void setFooddesc(String fooddesc) {
        this.fooddesc = fooddesc;
    }

    public String getPickuptime() {
        return pickuptime;
    }

    public void setPickuptime(String pickuptime) {
        this.pickuptime = pickuptime;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getVolunteerAmount() {
        return volunteerAmount;
    }

    public void setVolunteerAmount(int volunteerAmount) {
        this.volunteerAmount = volunteerAmount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(location);
        parcel.writeString(contno);
        parcel.writeString(userid);
        parcel.writeString(foodtype);
        parcel.writeString(fooddesc);
        parcel.writeString(pickuptime);
        parcel.writeString(response);
        parcel.writeString(state);
        parcel.writeInt(amount);
        parcel.writeInt(volunteerAmount);
    }

}
