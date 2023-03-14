package com.skyway.retrofitget;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @GET("posts")
    Call<JsonArray> getAnthing(); //call<JsonArray or JsonObject> responce me jisase start ho yha likhate hai

    @POST("NewRegistration")
    @FormUrlEncoded
    Call<JsonArray> userRegister(@Field("name") String Name,
                                 @Field("mobile") String Mobile,
                                 @Field("email") String Email,
                                 @Field("password") String Password,
                                 @Field("referral_code") String referral_code,
                                 @Field("section") String section);

    @Multipart
    @POST("UpdateProfile")
    Call<JsonArray> updateProfile(@Part("userid") RequestBody userId,
                                  @Part("name") RequestBody name,
                                  @Part("email") RequestBody email,
                                  @Part("education") RequestBody education,
                                  @Part("address") RequestBody address,
                                  @Part MultipartBody.Part profileImage);
}
