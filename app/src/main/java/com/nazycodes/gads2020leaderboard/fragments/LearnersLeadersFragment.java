package com.nazycodes.gads2020leaderboard.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nazycodes.gads2020leaderboard.R;
import com.nazycodes.gads2020leaderboard.adapters.LearnersLeadersRecyclerAdapter;
import com.nazycodes.gads2020leaderboard.models.LearnerLeaderModel;
import com.nazycodes.gads2020leaderboard.services.LeadersService;
import com.nazycodes.gads2020leaderboard.services.LeadersServicesBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearnersLeadersFragment extends Fragment {
    public static final String TITLE = "Learners Leaders";

    private RecyclerView recyclerView;
    private LearnersLeadersRecyclerAdapter learnersLeadersRecyclerAdapter;
    private List<LearnerLeaderModel> learnerLeaderModelList;
    private ProgressBar progressBar;

    public static LearnersLeadersFragment newInstance() {
        return new LearnersLeadersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        learnerLeaderModelList = new ArrayList<>();
        progressBar = view.findViewById(R.id.progress_circular);
        getData();
    }

    private void getData() {
        progressBar.setVisibility(View.VISIBLE);

        LeadersService leadersService = LeadersServicesBuilder.buildService(LeadersService.class);
        Call<List<LearnerLeaderModel>> createRequest = leadersService.getAllLearnerLeaders();

        createRequest.enqueue(new Callback<List<LearnerLeaderModel>>() {
            @Override
            public void onResponse(Call<List<LearnerLeaderModel>> request, Response<List<LearnerLeaderModel>> response) {
                Log.d("Success", "learnerLeaderModelList: " + response.body());
                learnerLeaderModelList = response.body();
                progressBar.setVisibility(View.INVISIBLE);
                loadUI();
            }

            @Override
            public void onFailure(Call<List<LearnerLeaderModel>> request, Throwable t) {
                Log.e("Error", "onError: " + t.getMessage());
            }
        });
    }

    private void loadUI(){
        learnersLeadersRecyclerAdapter = new LearnersLeadersRecyclerAdapter(learnerLeaderModelList, getActivity());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(learnersLeadersRecyclerAdapter);
    }

}
