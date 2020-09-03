package com.ilyo.gadsapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Singleton class
public class ServiceBuilder {

    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    public static final String GOOGLE_FORM_URL = "https://docs.google.com/forms/u/0/d/e/";

    private static ServiceBuilder instance = null;
    private Retrofit retrofit;

    private ServiceBuilder(){

    }

    public static ServiceBuilder getInstance(String url){
        if(instance == null){
            instance = new ServiceBuilder();
            instance.retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    // use generic class to build our different services
    public <S> S buildService(Class<S> serviceType) {
        return instance.retrofit.create(serviceType);
    }

    public static void destroyInstance(){
       instance = null;
    }

}
