package com.example.raihan.foodforall.Iterators;

import com.example.raihan.foodforall.Interfaces.I_Iterator;
import com.example.raihan.foodforall.Object.ResponseObject;
import com.example.raihan.foodforall.Object.Userdata;

import java.util.ArrayList;
import java.util.List;

public class ResponseList_Iterator implements I_Iterator {

    ArrayList<String> responseObjects;
    int position = 0;

    public ResponseList_Iterator(ArrayList<String>responseObjects)
    {
        this.responseObjects = responseObjects;
    }

    @Override
    public boolean hasNext() {
        if(position>=responseObjects.size())
        {
            return false;
        }
        else
            return true;
    }

    @Override
    public Object next() {
        String string = responseObjects.get(position);
        position++;
        return string;
    }
}
