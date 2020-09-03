package com.ilyo.gadsapp.model;

import com.google.gson.annotations.SerializedName;

public class Learner {

    @SerializedName("name")
    private String name;

    @SerializedName("hours")
    private int hours;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String badgeUrlImage;

    // For skillful people
    @SerializedName("score")
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrlImage() {
        return badgeUrlImage;
    }

    public void setBadgeUrlImage(String badgeUrlImage) {
        this.badgeUrlImage = badgeUrlImage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
