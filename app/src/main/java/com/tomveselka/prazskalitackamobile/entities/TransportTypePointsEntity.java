package com.tomveselka.prazskalitackamobile.entities;

public class TransportTypePointsEntity {
    private String englishName;
    private String czechName;
    private int points;

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getCzechName() {
        return czechName;
    }

    public void setCzechName(String czechName) {
        this.czechName = czechName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "TransportTypePointsEntity{" +
                "englishName='" + englishName + '\'' +
                ", czechName='" + czechName + '\'' +
                ", points=" + points +
                '}';
    }
}
