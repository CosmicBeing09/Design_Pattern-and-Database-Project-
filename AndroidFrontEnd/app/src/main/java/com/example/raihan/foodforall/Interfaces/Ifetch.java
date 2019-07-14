package com.example.raihan.foodforall.Interfaces;

import com.example.raihan.foodforall.Object.FoodRequest;
import com.example.raihan.foodforall.Object.Userdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Ifetch {
    @GET("foodrequest")
    Call<List<FoodRequest>> getFoodRequests();

    @POST("/postreq")
    Call<List<FoodRequest>> postFoodRequest(@Body FoodRequest recordObject);

    @GET("all")
    Call<List<Userdata>> getAllUser();

    @GET("loginuser/{contno}/{password}")
    Call<Userdata> postLogin(@Path("contno") String contno,@Path("password") String password);

    @POST("/reguser")
    Call<String> postUser(@Body Userdata userdata);

    @PUT("/response/{userid}")
    Call<Void> putState2(@Body FoodRequest foodRequest,@Path("userid") String userid);



}
