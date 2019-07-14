package com.example.raihan.foodforall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Adapters.ResponeAdapter;
import com.example.raihan.foodforall.Interfaces.Ifetch;
import com.example.raihan.foodforall.Iterators.ResponseList_Iterator;
import com.example.raihan.foodforall.Iterators.UserDataList_Iterator;
import com.example.raihan.foodforall.Object.FoodRequest;
import com.example.raihan.foodforall.Object.ResponseObject;
import com.example.raihan.foodforall.Object.Userdata;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDescription extends IActivity {

    TextView location,phoneNo,foodFor,description,expiaryTime,pickUpTime;
    TextView test;
    Button button;
    View included_view;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private ResponeAdapter responeAdapter;
    ScrollView scrollView;

    public UserDataList_Iterator userDataList_iterator;
    public ResponseList_Iterator responseList_iterator;

    public ArrayList<ResponseObject> arrayList;
    public ArrayList<String> responseIDs = new ArrayList<>();
    public TreeSet<ResponseObject> arrTreeSet = new TreeSet<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_description);

        Intent intent = getIntent();
        final  FoodRequest foodRequest = intent.getParcelableExtra("foodRequest");
        final String s = intent.getStringExtra("type");

        description = findViewById(R.id.Details_Description);
        expiaryTime = findViewById(R.id.Details_ExpiaryTime);
        pickUpTime  = findViewById(R.id.Details_PickUpTime);
        button = findViewById(R.id.Details_Response);
        scrollView = findViewById(R.id.scorll_view);

        if(s.equals("MyRequest")) {
            button.setVisibility(View.GONE);

        }


        included_view  = findViewById(R.id.included_tempalte);
        location = included_view.findViewById(R.id.FoodRequest_Location);
        phoneNo = included_view.findViewById(R.id.FoodRequest_PhoneNo);
        foodFor = included_view.findViewById(R.id.FoodRequest_Amount);



        location.setText(foodRequest.getLocation());
        phoneNo.setText("Phone Number: "+foodRequest.getContno());
        foodFor.setText("Food For: "+String.valueOf(foodRequest.getAmount())+" Person");
        description.setText(foodRequest.getFooddesc());
        expiaryTime.setText(foodRequest.getFoodtype());
        pickUpTime.setText(foodRequest.getPickuptime());

        StringTokenizer st = new StringTokenizer(foodRequest.getResponse()," ,");
        while (st.hasMoreTokens()) {
            responseIDs.add(st.nextToken().toString().trim());
        }


//        for(int i=0;i<responseIDs.size();i++)
//        {
//            for(int j=0;j<userdataList.size();j++)
//            {
//
//                if(responseIDs.get(i).trim().equals(userdataList.get(i).getId().trim()))
//                {
//                    arrTreeSet.add(new ResponseObject(userdataList.get(j).getName(),userdataList.get(j).getContno()));
//                }
//            }
//        }

//        for(int i=0;i<responseIDs.size();i++)
//        {
//            while (userDataList_iterator.hasNext())
//            {
//                Userdata userdata =(Userdata) userDataList_iterator.next();
//                if(responseIDs.get(i).trim().equals(userdata.getId().trim()))
//                {
//                    arrTreeSet.add(new ResponseObject(userdata.getName(),userdata.getContno()));
//                }
//            }
//        }



        userDataList_iterator = new UserDataList_Iterator(HomePage.userdataList);

            while (userDataList_iterator.hasNext()) {
                Userdata userdata = (Userdata) userDataList_iterator.next();
                responseList_iterator = new ResponseList_Iterator(responseIDs);
                while (responseList_iterator.hasNext())
                {
                    String responseID = (String) responseList_iterator.next();
                    if (responseID.trim().equals(userdata.getId().trim())) {
                        arrTreeSet.add(new ResponseObject(userdata.getName(), userdata.getContno()));
                    }
               }
            }


        arrayList = new ArrayList<>(arrTreeSet);

        recyclerView = (RecyclerView) findViewById(R.id.response_recycler);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        responeAdapter = new ResponeAdapter(arrayList,this);
        responeAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(responeAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Void> call = AppClient.getApiClient().create(Ifetch.class).putState2(foodRequest,Login.currentUser.getId());
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(PostDescription.this,"OnResponse",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(PostDescription.this,"OnFailure",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });



    }
}
