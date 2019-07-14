package com.example.raihan.foodforall.Adapters.FoodRequestPageDecoratorComponents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.raihan.foodforall.Adapters.FoodRequestAdapter;
import com.example.raihan.foodforall.Interfaces.Widget;
import com.example.raihan.foodforall.Object.FoodRequest;

import java.util.List;

public class FoodRequestDrawPickUpTime extends FoodRequestAdapter{

    public FoodRequestDrawPickUpTime(Context context, List<FoodRequest> obj) {
        super(context, obj);

    }
    public FoodRequestDrawPickUpTime(FoodRequestAdapter foodRequestAdapter){

    }

}
