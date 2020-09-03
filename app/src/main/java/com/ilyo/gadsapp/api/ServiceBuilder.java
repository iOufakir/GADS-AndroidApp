package com.ilyo.gadsapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // use generic class to build our different services
    public static <S> S buildService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }
}
