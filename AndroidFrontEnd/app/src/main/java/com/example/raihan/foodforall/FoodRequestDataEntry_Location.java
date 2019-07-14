package com.example.raihan.foodforall;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Interfaces.Istate;
import com.example.raihan.foodforall.Object.FoodRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FoodRequestDataEntry_Location extends IActivity implements Istate{

    EditText location;
    ImageButton left,right;
    StateController stateController;

    Random random = new Random();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy*hh:mm aa");
    FoodRequest foodRequest = new FoodRequest(String.valueOf(random.nextInt()),null,
            Login.currentUser.getContno(),Login.currentUser.getId(),null,null,
            String.valueOf(dateFormat.format(new Date())),
            "","1",0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_request_data_entry__location);
        location = findViewById(R.id.Location);
        right = findViewById(R.id.Location_Right);
        left = findViewById(R.id.Location_Left);
        Intent intent = getIntent();
        stateController = intent.getParcelableExtra("stateController");
        exec(stateController);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodRequestDataEntry_Location.this,HomePage.class);
                startActivity(intent);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                foodRequest.setLocation(location.getText().toString().trim());
                Intent intent =  new Intent(FoodRequestDataEntry_Location.this,stateController.getNextState().getClass());
                intent.putExtra("foodRequest",foodRequest);
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });


    }

    @Override
    public void exec(StateController stateController) {
        this.stateController = stateController;

        stateController.setNextState(new FoodRequestDataEntry_Amout());
    }
}
