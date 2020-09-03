package com.ilyo.gadsapp.api;

import com.ilyo.gadsapp.model.Learner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsService {

    @GET("api/hours")
    Call<List<Learner>> getLearnersByHours();

    @GET("api/skilliq")
    Call<List<Learner>> getLearnersBySkills();

}
