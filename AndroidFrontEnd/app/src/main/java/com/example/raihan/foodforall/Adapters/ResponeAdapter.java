package com.example.raihan.foodforall.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raihan.foodforall.Object.FoodRequest;
import com.example.raihan.foodforall.Object.ResponseObject;
import com.example.raihan.foodforall.R;

import java.util.ArrayList;
import java.util.List;

public class ResponeAdapter extends RecyclerView.Adapter<ResponeAdapter.MyViewHolder> {

    public ResponeAdapter.MyViewHolder holder;
    private List<ResponseObject> obj = new ArrayList<>();
    private Context context;

    public ResponeAdapter(List<ResponseObject> obj,Context context)
    {
        this.obj = obj;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_people_response,parent,false);
        ResponeAdapter.MyViewHolder viewHolder = new ResponeAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        this.holder=holder;
        holder.name.setText(obj.get(position).getName());
        holder.phoneNo.setText(obj.get(position).getContactNo());
    }

    @Override
    public int getItemCount() {
        return obj.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView phoneNo,name;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.ResponseTemplate_name);
            this.phoneNo = itemView.findViewById(R.id.ResponseTemplate_phoneNumber);



        }

    }
}
