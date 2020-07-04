package com.ygorfx1.dev.android.testeandroidv2ym.network;

import com.ygorfx1.dev.android.testeandroidv2ym.models.ResponseStatement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Statement {

    @GET("statements/{id}")
    Call<ResponseStatement> getExtract(@Path("id") int id);
}
