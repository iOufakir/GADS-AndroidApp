package com.ilyo.gadsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ilyo.gadsapp.api.GadsService;
import com.ilyo.gadsapp.api.ServiceBuilder;
import com.ilyo.gadsapp.api.model.Learner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Build service
        GadsService gadsService = ServiceBuilder.buildService(GadsService.class);
        Call<List<Learner>> call = gadsService.getLearners();
        // Invoke api call
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                System.out.println("ilyaso : "+response.body());
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {

            }
        });

    }


    private void startActivity(){

    }
}