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

public class FoodRequestDataEntry_Description extends IActivity implements Istate {

    EditText description;
    ImageButton left,right;
    StateController stateController;
    FoodRequest foodRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_request_data_entry__description);

        description = findViewById(R.id.Description);
        right = findViewById(R.id.Description_Right);
        left = findViewById(R.id.Description_Left);
        Intent intent = getIntent();
        stateController = intent.getParcelableExtra("stateController");
        foodRequest = intent.getParcelableExtra("foodRequest");
        exec(stateController);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                foodRequest.setFooddesc(description.getText().toString());
                Intent intent =  new Intent(FoodRequestDataEntry_Description.this,stateController.getNextState().getClass());
                intent.putExtra("foodRequest",foodRequest);
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodRequestDataEntry_Description.this,stateController.getPrviousState().getClass());
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });
    }

    @Override
    public void exec(StateController stateController) {

        stateController.setPrviousState(new FoodRequestDataEntry_Amout());
        stateController.setNextState(new FoodRequestDataEntry_ExpiaryTime());
    }
}
