package com.example.raihan.foodforall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Adapters.FoodRequestAdapter;
import com.example.raihan.foodforall.Interfaces.Ifetch;
import com.example.raihan.foodforall.Interfaces.ItemClickListener;
import com.example.raihan.foodforall.Object.FoodRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyResponses extends IActivity implements ItemClickListener {
    private FoodRequestAdapter foodRequestAdapter;
    public List<FoodRequest> foodRequests = new ArrayList<>();
    public RecyclerView homePageRecycler;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_response);

        homePageRecycler = findViewById(R.id.myResponse_RecyclerView);
        foodRequestAdapter = new FoodRequestAdapter(this,foodRequests);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MyResponses.this);
        homePageRecycler.setLayoutManager(mLayoutManager);
        Call<List<FoodRequest>> call = AppClient.getApiClient().create(Ifetch.class).getFoodRequests();
        call.enqueue(new Callback<List<FoodRequest>>() {
            @Override
            public void onResponse(Call<List<FoodRequest>> call, Response<List<FoodRequest>> response) {
                for (FoodRequest requestObject : response.body()) {
                    if(requestObject.getResponse().contains(Login.currentUser.getId()))
                        foodRequests.add(requestObject);
                    foodRequestAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<FoodRequest>> call, Throwable t) {

            }
        });

        homePageRecycler.setAdapter(foodRequestAdapter);
        foodRequestAdapter.setClickListener(this);
    }



    @Override
    public void onClick(View view, int position) {
        final FoodRequest npo = foodRequests.get(position);
//        Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show();
        Intent i = new Intent(MyResponses.this,PostDescription.class);
        i.putExtra("foodRequest",npo);
        i.putExtra("type","MyResponse");
        startActivity(i);
    }
}
