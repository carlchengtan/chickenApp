package com.tan.chicken.service;

import com.tan.chicken.domain.Chicken;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChickenService {

    @POST(value="/chickens")
    Chicken createChicken(@Body Chicken chicken);

    @GET("/chickens")
    Call<List<Chicken>> getChickens();

    @GET("/chickens/{id}")
    Call<Chicken> getChicken(@Path("id") Long id);

    @PUT("/chickens/{id}")
    Call<Chicken> updateChicken(@Path("id") Long id, @Body Chicken chicken);

    @DELETE("/chickens/{id}")
    void deleteChicken(@Path("id") Long id);

    @GET("/chickens/{rfid}")
    Call<Chicken> findByRfid(@Path("rfid") String rfid);

}
