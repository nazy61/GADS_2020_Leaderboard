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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.nazycodes.gads2020leaderboard.R;
import com.nazycodes.gads2020leaderboard.adapters.LearnersLeadersRecyclerAdapter;
import com.nazycodes.gads2020leaderboard.adapters.SkillIQLeadersRecyclerAdapter;
import com.nazycodes.gads2020leaderboard.models.LearnerLeaderModel;
import com.nazycodes.gads2020leaderboard.models.SkillIQLeaderModel;

import java.util.ArrayList;
import java.util.List;

public class SkillIQLeaders extends Fragment {
    public static final String TITLE = "Skill IQ Leaders";
    private static final String API = "https://gadsapi.herokuapp.com/api/skilliq";

    private RecyclerView recyclerView;
    private SkillIQLeadersRecyclerAdapter skillIQLeadersRecyclerAdapter;
    private List<SkillIQLeaderModel> skillIQLeaderModelList;
    private ProgressBar progressBar;

    public static SkillIQLeaders newInstance() {

        return new SkillIQLeaders();
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

        AndroidNetworking.get(API)
                .setTag("production")
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(SkillIQLeaderModel.class, new ParsedRequestListener<List<SkillIQLeaderModel>>() {
                    @Override
                    public void onResponse(List<SkillIQLeaderModel> skillIQLeaderModels) {
                        // do anything with response
                        Log.d("Success", "skillIQLeaderModelList size : " + skillIQLeaderModels.size());
                        skillIQLeaderModelList = skillIQLeaderModels;
                        progressBar.setVisibility(View.INVISIBLE);
                        loadUI();
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.e("Error", "onError: " + anError.getMessage());
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
