package com.example.raihan.foodforall.Iterators;

import com.example.raihan.foodforall.Interfaces.I_Iterator;
import com.example.raihan.foodforall.Object.FoodRequest;
import com.example.raihan.foodforall.Object.ResponseObject;
import com.example.raihan.foodforall.Object.Userdata;

import java.util.ArrayList;
import java.util.List;

public class UserDataList_Iterator implements I_Iterator{
    List<Userdata> userdatas;
    int position = 0;

    public UserDataList_Iterator(List<Userdata> userdatas)
    {
        this.userdatas = userdatas;
    }


    @Override
    public boolean hasNext() {
        if(position>=userdatas.size())
        {
            return false;
        }
        else
            return true;
    }

    @Override
    public Object next() {
        Userdata userdata = userdatas.get(position);
        position++;
        return userdata;
    }
}
