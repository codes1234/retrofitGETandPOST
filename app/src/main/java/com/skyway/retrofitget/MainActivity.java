package com.skyway.retrofitget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
 
//    ArrayList<Model> list= new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
    }

  /*  // for POST
    private void loadData() {
//        MyApi myApi= RetrofitInstanse.getRetrofitInstance().create(MyApi.class);
        Call<JsonArray> call=RetrofitInstance.retrofitInstance().userRegister(userName,userMobile,userEmail,userPass,userReferral,section_type);
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                if(response.isSuccessful()) {
                    JSONArray jsonArray= null;
                    try {
                        jsonArray = new JSONArray(new Gson().toJson(response.body()));
                        JSONObject jsonObject=jsonArray.getJSONObject(0);

                        String res=jsonObject.getString("res");
                        String msg=jsonObject.getString("msg");

                        if(res.equalsIgnoreCase("success"))
                        {

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
//                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("sd",t.getMessage());
            }
        });
    }*/

    // for GET
    private void loadData() {
//        ApiService apiService = RetrofitInstance.retrofitInstance().create(ApiService.class);
        Call<JsonArray> call = RetrofitInstance.retrofitInstance().getAnthing();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful()){
                    // agar responce array se start huaa ho to
                    try {
                        Log.d("sdgdse", "onResponse: "+response.body().toString());

                        JSONArray jsonArray = new JSONArray(new Gson().toJson(response.body()));
                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                        // fir ager respon and msg hai to use accec karenge
                        String res = jsonObject.getString("res");
                        String msg = jsonObject.getString("msg");
                        if (res.equalsIgnoreCase("success")) {
                            JSONArray jsonArray1 = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray1.length(); i++) {
//                               Model  model = new Gson().fromJson(jsonArray1.getJSONObject(i).toString(), Model.class);
//                                list.add(model);
                            }
                            }
                    } catch (JSONException e) {
                        Log.d("vefer", "onResponse: "+e.toString());

                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}