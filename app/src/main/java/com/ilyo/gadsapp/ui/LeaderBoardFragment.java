package com.ilyo.gadsapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ilyo.gadsapp.LeaderBoardAdapter;
import com.ilyo.gadsapp.R;
import com.ilyo.gadsapp.api.GadsService;
import com.ilyo.gadsapp.api.ServiceBuilder;
import com.ilyo.gadsapp.model.Learner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardFragment extends Fragment {

    private RecyclerView recyclerViewLearners;
    private static final String TAG = LeaderBoardFragment.class.getSimpleName();
    private Context context;
    private Integer position;

    public LeaderBoardFragment(Integer position) {
        this.position = position;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leader_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // init views
        initViews(view);

        // Display data
        if (position == 0) {
            getLearnersByHours();
        } else {
            getLearnersBySkills();
        }
    }

    private void initViews(View view) {
        recyclerViewLearners = view.findViewById(R.id.list_learners);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerViewLearners.setLayoutManager(layoutManager);
    }

    private void displayData(List<Learner> listLearners) {
        LeaderBoardAdapter adapter = new LeaderBoardAdapter(context, listLearners);
        recyclerViewLearners.setAdapter(adapter);
    }

    public void getLearnersByHours() {
        // Build service
        GadsService gadsService = ServiceBuilder.buildService(GadsService.class);
        Call<List<Learner>> call = gadsService.getLearnersByHours();
        // Invoke api call
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                displayData(response.body());
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
                Toast.makeText(context, "Network error: " + t.getCause(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getLearnersBySkills() {
        // Build service
        GadsService gadsService = ServiceBuilder.buildService(GadsService.class);
        Call<List<Learner>> call = gadsService.getLearnersBySkills();
        // Invoke api call
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                displayData(response.body());
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
                Toast.makeText(context, "Network error: " + t.getCause(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}