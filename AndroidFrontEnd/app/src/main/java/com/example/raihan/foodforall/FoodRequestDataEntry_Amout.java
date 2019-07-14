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

public class FoodRequestDataEntry_Amout extends IActivity implements Istate {

    EditText amount;
    ImageButton left,right;
    StateController stateController;
    FoodRequest foodRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_request_data_entry__amout);

        amount = findViewById(R.id.Amount);
        right = findViewById(R.id.Amount_Right);
        left = findViewById(R.id.Amount_Left);
        Intent intent = getIntent();
        stateController = intent.getParcelableExtra("stateController");
        foodRequest = intent.getParcelableExtra("foodRequest");
        exec(stateController);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                foodRequest.setAmount(Integer.valueOf(amount.getText().toString().trim()));
                Intent intent =  new Intent(FoodRequestDataEntry_Amout.this,stateController.getNextState().getClass());
                intent.putExtra("foodRequest",foodRequest);
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodRequestDataEntry_Amout.this,stateController.getPrviousState().getClass());
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });
    }

    @Override
    public void exec(StateController stateController) {
        this.stateController = stateController;

        stateController.setPrviousState(new FoodRequestDataEntry_Location());
        stateController.setNextState(new FoodRequestDataEntry_Description());
    }
}
