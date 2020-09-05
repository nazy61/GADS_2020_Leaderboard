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
import com.nazycodes.gads2020leaderboard.models.LearnerLeaderModel;

import java.util.ArrayList;
import java.util.List;

public class LearnersLeadersFragment extends Fragment {
    public static final String TITLE = "Learners Leaders";
    private static final String API = "https://gadsapi.herokuapp.com/api/hours";

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

        AndroidNetworking.get(API)
                .setTag("production")
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(LearnerLeaderModel.class, new ParsedRequestListener<List<LearnerLeaderModel>>() {
                    @Override
                    public void onResponse(List<LearnerLeaderModel> learnerLeaderModels) {
                        // do anything with response
                        Log.d("Success", "learnerLeaderModelList size : " + learnerLeaderModels.size());
                        learnerLeaderModelList = learnerLeaderModels;
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
        learnersLeadersRecyclerAdapter = new LearnersLeadersRecyclerAdapter(learnerLeaderModelList, getActivity());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(learnersLeadersRecyclerAdapter);
    }

}
