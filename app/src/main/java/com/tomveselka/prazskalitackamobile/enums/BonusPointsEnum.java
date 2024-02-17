package com.tomveselka.prazskalitackamobile.enums;

public enum BonusPointsEnum {
    LINE(15),
    STATION(20),
    ZONE(25),
    DIVERSION(4);

    public final int points;

    private BonusPointsEnum(int points){
        this.points=points;
    }

    public int getPoints() {
        return points;
    }
}
