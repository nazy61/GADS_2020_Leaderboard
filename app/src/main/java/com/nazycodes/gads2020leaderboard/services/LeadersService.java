package com.nazycodes.gads2020leaderboard.services;

import com.nazycodes.gads2020leaderboard.models.LearnerLeaderModel;
import com.nazycodes.gads2020leaderboard.models.SkillIQLeaderModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeadersService {
    @GET("/api/hours")
    Call<List<LearnerLeaderModel>> getAllLearnerLeaders();

    @GET("/api/skilliq")
    Call<List<SkillIQLeaderModel>> getAllSkillIQLeaders();
}
