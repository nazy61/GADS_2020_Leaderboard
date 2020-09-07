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
import com.nazycodes.gads2020leaderboard.adapters.SkillIQLeadersRecyclerAdapter;
import com.nazycodes.gads2020leaderboard.models.SkillIQLeaderModel;
import com.nazycodes.gads2020leaderboard.services.LeadersService;
import com.nazycodes.gads2020leaderboard.services.LeadersServicesBuilder;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeadersFragment extends Fragment {
    public static final String TITLE = "Skill IQ Leaders";

    private RecyclerView recyclerView;
    private SkillIQLeadersRecyclerAdapter skillIQLeadersRecyclerAdapter;
    private List<SkillIQLeaderModel> skillIQLeaderModelList;
    private ProgressBar progressBar;

    public static SkillIQLeadersFragment newInstance() {

        return new SkillIQLeadersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        skillIQLeaderModelList = new ArrayList<>();
        progressBar = view.findViewById(R.id.progress_circular);
        getData();
    }

    private void getData() {
        progressBar.setVisibility(View.VISIBLE);

        LeadersService leadersService = LeadersServicesBuilder.buildService(LeadersService.class);
        Call<List<SkillIQLeaderModel>> createRequest = leadersService.getAllSkillIQLeaders();

        createRequest.enqueue(new Callback<List<SkillIQLeaderModel>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeaderModel>> request, Response<List<SkillIQLeaderModel>> response) {
                Log.d("Success", "skillIQLeaderModelList: " + response.body());
                skillIQLeaderModelList = response.body();
                progressBar.setVisibility(View.INVISIBLE);
                loadUI();
            }

            @Override
            public void onFailure(Call<List<SkillIQLeaderModel>> request, Throwable t) {
                Log.e("Error", "onError: " + t.getMessage());
            }
        });
    }

    private void loadUI(){
        skillIQLeadersRecyclerAdapter = new SkillIQLeadersRecyclerAdapter(skillIQLeaderModelList, getActivity());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(skillIQLeadersRecyclerAdapter);
    }

}
