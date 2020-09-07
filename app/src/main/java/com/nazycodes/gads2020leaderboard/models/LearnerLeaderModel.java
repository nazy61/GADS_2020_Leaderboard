package com.nazycodes.gads2020leaderboard.models;

import com.google.gson.annotations.SerializedName;

public class LearnerLeaderModel {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("badgeUrl")
    private String badgeUrl;
    @SerializedName("hours")
    private int hours;

    public LearnerLeaderModel(String name, String country, String badgeUrl, int hours) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.hours = hours;
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

    public void setHours(int hours) {
        this.hours = hours;
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

    public int getHours() {
        return hours;
    }
}
