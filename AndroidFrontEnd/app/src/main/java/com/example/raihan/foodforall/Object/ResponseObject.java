package com.example.raihan.foodforall.Object;

import android.support.annotation.NonNull;

public class ResponseObject implements Comparable<ResponseObject>{
    private String name;
    private String contactNo;

    public ResponseObject(String name, String contactNo) {
        this.name = name;
        this.contactNo = contactNo;
    }

    public ResponseObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public int compareTo(@NonNull ResponseObject responseObject) {
        return Integer.valueOf(this.contactNo) - Integer.valueOf(responseObject.contactNo);
    }
}
