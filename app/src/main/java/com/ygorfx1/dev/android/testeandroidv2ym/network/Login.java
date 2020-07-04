package com.ygorfx1.dev.android.testeandroidv2ym.network;

import com.ygorfx1.dev.android.testeandroidv2ym.models.ResponseLoginUser;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Login {

    @POST("login")
    Call<ResponseLoginUser> login(@Body HashMap loginObject);
}
