package com.example.raihan.foodforall;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Interfaces.Ifetch;
import com.example.raihan.foodforall.Interfaces.Istate;
import com.example.raihan.foodforall.Object.FoodRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodRequestDataEntry extends IActivity{

    EditText location,contno,userid,foodtype,fooddesc,response,state,amount,volunteerAmount;
    ImageButton submit;

    Random random = new Random();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy*hh:mm aa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_request_data_entry);
        exec();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodRequest foodRequest = new FoodRequest(String.valueOf(random.nextInt()),location.getText().toString(),
                        Login.currentUser.getContno(),Login.currentUser.getId(),foodtype.getText().toString(),fooddesc.getText().toString(),
                        String.valueOf(dateFormat.format(new Date())),
                        "","1",Integer.valueOf(amount.getText().toString()),
                        Integer.valueOf(volunteerAmount.getText().toString())
                        );



                Intent intent = new Intent(FoodRequestDataEntry.this,Visualize_Volunteer.class);
                intent.putExtra("foodRequest",foodRequest);
                startActivity(intent);

            }
        });
    }




    public void exec() {
        location = findViewById(R.id.FoodRequestEntry_Location);
        fooddesc = findViewById(R.id.FoodRequestEntry_FoodDesc);
        foodtype = findViewById(R.id.FoodRequestEntry_ExpiaryTime);

        amount = findViewById(R.id.FoodRequestEntry_Amount);
        volunteerAmount = findViewById(R.id.FoodRequestEntry_VolunteerNeede);
        submit = findViewById(R.id.FoodRequestEntry_Next);

    }
}
