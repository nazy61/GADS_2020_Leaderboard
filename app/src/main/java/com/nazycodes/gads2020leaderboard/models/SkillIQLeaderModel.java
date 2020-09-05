package com.nazycodes.gads2020leaderboard.models;

public class SkillIQLeaderModel {
    final String name;
    final String country;
    final String badgeUrl;
    final int score;

    public SkillIQLeaderModel(String name, String country, String badgeUrl, int score) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
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
