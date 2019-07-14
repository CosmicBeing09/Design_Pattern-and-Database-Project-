package com.example.raihan.foodforall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Interfaces.Ifetch;
import com.example.raihan.foodforall.Object.FoodRequest;
import com.example.raihan.foodforall.Object.Userdata;

import org.apache.commons.logging.Log;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends IActivity {

    EditText name,location,contno,password,c_password;
    Button submit;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.Register_Title);
        location = findViewById(R.id.Register_Location);
        contno = findViewById(R.id.Register_Contno);
        password = findViewById(R.id.Register_password);
        c_password = findViewById(R.id.Register_CPassword);
        submit = findViewById(R.id.Register_Button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(password.getText().toString().equals(c_password.getText().toString())){

                    Userdata userdata = new Userdata(String.valueOf(random.nextInt()),name.getText().toString(),
                            contno.getText().toString(),location.getText().toString(),"Person",false,password.getText().toString());
                    Call<String> call = AppClient.getApiClient().create(Ifetch.class).postUser(userdata);
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Toast.makeText(Registration.this,response.body().toString(),Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Registration.this, Login.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                            Toast.makeText(Registration.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Registration.this, Login.class);
                            startActivity(intent);
                        }
                    });
                }
                else {
                    Toast.makeText(Registration.this,"Password Didn't Match",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
