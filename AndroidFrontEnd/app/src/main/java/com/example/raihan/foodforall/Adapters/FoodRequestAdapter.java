package com.example.raihan.foodforall.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raihan.foodforall.Interfaces.ItemClickListener;
import com.example.raihan.foodforall.Interfaces.Widget;
import com.example.raihan.foodforall.Object.FoodRequest;
import com.example.raihan.foodforall.PostDescription;
import com.example.raihan.foodforall.R;
import com.google.gson.Gson;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class FoodRequestAdapter extends RecyclerView.Adapter<FoodRequestAdapter.MyViewHolder> implements Widget {
    public MyViewHolder holder;
    private List<FoodRequest> obj;
    private Context context;
    private ItemClickListener clickListener;

    public FoodRequestAdapter(Context context,List<FoodRequest>obj)
    {
        this.context=context;
        this.obj = obj;
    }

    public FoodRequestAdapter() {
    }


    @Override
    public void drawDescription() {
        holder.description.setVisibility(View.VISIBLE);
    }

    @Override
    public void drawPickUpTime() {
        holder.pickUpTime.setVisibility(View.VISIBLE);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView  location,amount,phoneNo,description,pickUpTime;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.location = itemView.findViewById(R.id.FoodRequest_Location);
            this.amount = itemView.findViewById(R.id.FoodRequest_Amount);
            this.phoneNo = itemView.findViewById(R.id.FoodRequest_PhoneNo);
//            this.description = itemView.findViewById(R.id.FoodRequest_Description);
//            this.pickUpTime = itemView.findViewById(R.id.FoodRequest_PickUpTime);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_food_request,parent,false);
        FoodRequestAdapter.MyViewHolder viewHolder = new FoodRequestAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        this.holder=holder;
        holder.location.setText("Location: "+obj.get(position).getLocation());
        holder.amount.setText("For "+String.valueOf(obj.get(position).getAmount())+" Person");
        holder.phoneNo.setText("Phone Number: "+obj.get(position).getContno());
//        holder.description.setText("Food Description: "+obj.get(position).getFooddesc());
//        holder.pickUpTime.setText("Pick Up Time: "+obj.get(position).getPickuptime());


    }

    @Override
    public int getItemCount() {
        return obj.size();

    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
