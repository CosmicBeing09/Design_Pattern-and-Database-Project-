package com.example.raihan.foodforall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Interfaces.Istate;
import com.example.raihan.foodforall.Object.FoodRequest;

public class FoodRequestDataEntry_Volunteer extends IActivity implements Istate {

    EditText volunteer;
    ImageButton left,right;
    StateController stateController;
    FoodRequest foodRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_description_data_entry__volunteer);


        volunteer = findViewById(R.id.Volunteer);
        right = findViewById(R.id.Volunteer_Right);
        left = findViewById(R.id.Volunteer_Left);
        Intent intent = getIntent();
        stateController = intent.getParcelableExtra("stateController");
        foodRequest = intent.getParcelableExtra("foodRequest");
        exec(stateController);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                foodRequest.setVolunteerAmount(Integer.valueOf(volunteer.getText().toString()));
                Intent intent =  new Intent(FoodRequestDataEntry_Volunteer.this,Visualize_Volunteer.class);
                intent.putExtra("foodRequest",foodRequest);
                startActivity(intent);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodRequestDataEntry_Volunteer.this,stateController.getPrviousState().getClass());
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });
    }

    @Override
    public void exec(StateController stateController) {

        stateController.setPrviousState(new FoodRequestDataEntry_ExpiaryTime());

    }
}
