package com.example.raihan.foodforall;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Interfaces.Ifetch;
import com.example.raihan.foodforall.Object.Userdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends IActivity {

    public ActivityFactory activityFactory = ActivityFactorySingleTon.getActivityFactory();
    public static Userdata currentUser;

    EditText contactNo,password;
    Button button;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        contactNo = findViewById(R.id.login_contactNo);
        password = findViewById(R.id.login_password);
        button = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog Dialog = new ProgressDialog(Login.this);
                Dialog.setMessage("Please Wait.....");
                Dialog.show();

                Call<Userdata> call = AppClient.getApiClient().create(Ifetch.class).postLogin(
                        contactNo.getText().toString().trim(),password.getText().toString().trim()
                );
              call.enqueue(new Callback<Userdata>() {
                  @Override
                  public void onResponse(Call<Userdata> call, Response<Userdata> response) {
                      currentUser = response.body();
                      if(currentUser==null)
                      {
                          Toast.makeText(Login.this,"Login Input Error",Toast.LENGTH_LONG).show();
                      }
                      else
                      {

                        IActivity iActivity = activityFactory.createRequestPage("Home Page");
                        Intent intent = new Intent(Login.this,iActivity.getClass());
                        Dialog.dismiss();
                        startActivity(intent);
                        //Toast.makeText(Login.this,currentUser.getName(),Toast.LENGTH_SHORT).show();
                      }


                  }

                  @Override
                  public void onFailure(Call<Userdata> call, Throwable t) {
                      Toast.makeText(Login.this,"Failed To Login",Toast.LENGTH_SHORT).show();
                  }
              });


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IActivity iActivity = activityFactory.createRequestPage("Register");
                Intent intent = new Intent(Login.this,iActivity.getClass());
                startActivity(intent);
            }
        });


    }
}
