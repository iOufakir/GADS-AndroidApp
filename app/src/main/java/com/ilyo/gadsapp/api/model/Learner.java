package com.ilyo.gadsapp.api.model;

public class Learner {
    private String name;
    private int hours;
    private String country;
    private String badgeUrlImage;

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
}
