package com.example.raihan.foodforall;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {
    public static final String Base_URL = "http://foodforallbd.herokuapp.com/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
