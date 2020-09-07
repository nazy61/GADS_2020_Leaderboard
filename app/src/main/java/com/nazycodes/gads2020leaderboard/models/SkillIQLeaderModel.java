package com.nazycodes.gads2020leaderboard.models;

import com.google.gson.annotations.SerializedName;

public class SkillIQLeaderModel {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("badgeUrl")
    private String badgeUrl;

    @SerializedName("score")
    private int score;

    public SkillIQLeaderModel(String name, String country, String badgeUrl, int score) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public int getScore() {
        return score;
    }
}
