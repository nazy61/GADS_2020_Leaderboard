package com.nazycodes.gads2020leaderboard.models;

public class LearnerLeaderModel {
    final String name;
    final String country;
    final String badgeUrl;
    final int hours;

    public LearnerLeaderModel(String name, String country, String badgeUrl, int hours) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
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
