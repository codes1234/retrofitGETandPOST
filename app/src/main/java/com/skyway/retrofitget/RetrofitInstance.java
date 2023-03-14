package com.skyway.retrofitget;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static Retrofit retrofit;
    public static ApiService retrofitInstance(){
        if (retrofit == null){
            Gson gson = new GsonBuilder().setLenient().create();
             retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
