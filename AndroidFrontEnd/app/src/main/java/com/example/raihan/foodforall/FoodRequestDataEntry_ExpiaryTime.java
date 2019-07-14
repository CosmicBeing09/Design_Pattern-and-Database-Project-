package com.example.raihan.foodforall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Interfaces.Istate;
import com.example.raihan.foodforall.Object.FoodRequest;

public class FoodRequestDataEntry_ExpiaryTime extends IActivity implements Istate {

    EditText expiaryTime;
    ImageButton left,right;
    StateController stateController;
    FoodRequest foodRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_request_entry__expiary_time);

        expiaryTime = findViewById(R.id.ExpiaryTime);
        right = findViewById(R.id.ExpiaryTime_Right);
        left = findViewById(R.id.ExpiaryTime_Left);
        Intent intent = getIntent();
        stateController = intent.getParcelableExtra("stateController");
        foodRequest = intent.getParcelableExtra("foodRequest");
        exec(stateController);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                foodRequest.setFoodtype(expiaryTime.getText().toString());
                Toast.makeText(FoodRequestDataEntry_ExpiaryTime.this
                ,expiaryTime.getText()+" "+foodRequest.getFoodtype(),Toast.LENGTH_LONG).show();
                Intent intent =  new Intent(FoodRequestDataEntry_ExpiaryTime.this,
                        stateController.getNextState().getClass());
                intent.putExtra("foodRequest",foodRequest);
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodRequestDataEntry_ExpiaryTime.this,stateController.getPrviousState().getClass());
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });

    }

    @Override
    public void exec(StateController stateController) {
        stateController.setPrviousState(new FoodRequestDataEntry_Description());
        stateController.setNextState(new FoodRequestDataEntry_Volunteer());
    }
}
