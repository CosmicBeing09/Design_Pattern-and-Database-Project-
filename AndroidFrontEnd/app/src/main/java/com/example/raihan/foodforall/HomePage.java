package com.example.raihan.foodforall;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.raihan.foodforall.AbstractClasses.IActivity;
import com.example.raihan.foodforall.Adapters.FoodRequestAdapter;
import com.example.raihan.foodforall.Interfaces.Ifetch;
import com.example.raihan.foodforall.Interfaces.ItemClickListener;
import com.example.raihan.foodforall.Object.FoodRequest;
import com.example.raihan.foodforall.Object.Userdata;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends IActivity
        implements NavigationView.OnNavigationItemSelectedListener,ItemClickListener {

    ActivityFactory activityFactory = ActivityFactorySingleTon.getActivityFactory();
    private FoodRequestAdapter foodRequestAdapter;
    public List<FoodRequest> foodRequests = new ArrayList<>();
    public RecyclerView homePageRecycler;
    public static List<Userdata> userdataList = new ArrayList<>();
    public StateController stateController = new StateController();

    TextView Cname,CphoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        Call<List<Userdata>> call1 = AppClient.getApiClient().create(Ifetch.class).getAllUser();
        call1.enqueue(new Callback<List<Userdata>>() {
            @Override
            public void onResponse(Call<List<Userdata>> call, Response<List<Userdata>> response) {

                for (Userdata userdata : response.body()) {
                    userdataList.add(userdata);

                }
            }

            @Override
            public void onFailure(Call<List<Userdata>> call, Throwable t) {


            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IActivity iActivity = activityFactory.createRequestPage("Location");
                Intent intent = new Intent(HomePage.this,iActivity.getClass());
                intent.putExtra("stateController",stateController);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);

        Cname = headerView.findViewById(R.id.nav_name);
        CphoneNo = headerView.findViewById(R.id.nav_phoneNo);

        Cname.setText(Login.currentUser.getName());
        CphoneNo.setText(Login.currentUser.getContno());


        //----------------------------------------------------------------

        homePageRecycler = findViewById(R.id.HomePageRecyclerView);
        foodRequestAdapter = new FoodRequestAdapter(this,foodRequests);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HomePage.this);
        homePageRecycler.setLayoutManager(mLayoutManager);
        Call<List<FoodRequest>> call = AppClient.getApiClient().create(Ifetch.class).getFoodRequests();
        call.enqueue(new Callback<List<FoodRequest>>() {
            @Override
            public void onResponse(Call<List<FoodRequest>> call, Response<List<FoodRequest>> response) {
                for (FoodRequest requestObject : response.body()) {
                    if(!Login.currentUser.getContno().equals(requestObject.getContno()))
                    foodRequests.add(requestObject);
                    foodRequestAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<FoodRequest>> call, Throwable t) {

            }
        });
        homePageRecycler.setAdapter(foodRequestAdapter);
        foodRequestAdapter.setClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id == R.id.my_request) {
            IActivity IActivity = activityFactory.createRequestPage("My Request");
            Intent intent = new Intent(HomePage.this, IActivity.getClass());
          startActivity(intent);


        } else if (id == R.id.my_response) {
            IActivity IActivity = activityFactory.createRequestPage("My Response");
            Intent intent = new Intent(HomePage.this, IActivity.getClass());
           startActivity(intent);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view, int position) {

        final FoodRequest npo = foodRequests.get(position);
//        Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show();
        Intent i = new Intent(HomePage.this,PostDescription.class);
        i.putExtra("foodRequest",npo);
        i.putExtra("type","Home Page");
        startActivity(i);
    }
}
