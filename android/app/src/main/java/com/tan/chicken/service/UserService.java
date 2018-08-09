
package com.tan.chicken.service;

import com.tan.chicken.domain.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @POST("/signup")
    Call<User> register(@Body User user);

    @POST("/token/generate-token")
    Call<ResponseBody> login(@Body User user);

    @GET("/users")
    Call<List<User>> getUsers(
            @Query("per_page") int per_page,
            @Query("page") int page);

    @GET("/users/{id}")
    User getUser(@Path("id") Long id);

    @GET("/owners")
    List<User> getOwners();

//    @GET("/users")
//    public List<User> listUser();

//    @GET("/users/{username}")
//    public Call<User> getUser(@Path("username") String username);

}

