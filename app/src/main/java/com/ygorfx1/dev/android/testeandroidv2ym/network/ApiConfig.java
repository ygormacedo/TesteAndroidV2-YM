package com.ygorfx1.dev.android.testeandroidv2ym.network;

import com.ygorfx1.dev.android.testeandroidv2ym.helpers.GlobalValues;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GlobalValues.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttp.okHttpClient)
            .build();

    public static <S> S create(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


}
