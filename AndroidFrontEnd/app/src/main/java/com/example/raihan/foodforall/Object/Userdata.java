package com.example.raihan.foodforall.Object;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Userdata implements Parcelable{
    @SerializedName("catagory")
    @Expose
    private String catagory;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("admin")
    @Expose
    private Boolean admin;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("contno")
    @Expose
    private String contno;

    public Userdata(String id,String name,String contno,String location,String catagory,Boolean admin,String password) {
        this.catagory = catagory;
        this.password = password;
        this.name = name;
        this.admin = admin;
        this.location = location;
        this.id = id;
        this.contno = contno;
    }

    public Userdata() {
    }

    protected Userdata(Parcel in) {
        catagory = in.readString();
        password = in.readString();
        name = in.readString();
        byte tmpAdmin = in.readByte();
        admin = tmpAdmin == 0 ? null : tmpAdmin == 1;
        location = in.readString();
        id = in.readString();
        contno = in.readString();
    }

    public static final Creator<Userdata> CREATOR = new Creator<Userdata>() {
        @Override
        public Userdata createFromParcel(Parcel in) {
            return new Userdata(in);
        }

        @Override
        public Userdata[] newArray(int size) {
            return new Userdata[size];
        }
    };

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContno() {
        return contno;
    }

    public void setContno(String contno) {
        this.contno = contno;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(catagory);
        parcel.writeString(password);
        parcel.writeString(name);
        parcel.writeByte((byte) (admin == null ? 0 : admin ? 1 : 2));
        parcel.writeString(location);
        parcel.writeString(id);
        parcel.writeString(contno);
    }
}
