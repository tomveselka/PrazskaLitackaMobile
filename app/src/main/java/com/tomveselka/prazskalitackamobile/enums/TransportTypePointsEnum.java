package com.tomveselka.prazskalitackamobile.enums;

public enum TransportTypePointsEnum {
    METRO(2),
    BUS_CITY(3),
    TRAM(4),
    BUS_300(5),
    BUS_400(6),
    TRAIN_OS(7),
    TRAIN_R(8),
    FERRY(9),
    TROLLEYBUS(3),
    FUNICULAR(10);

    public final int points;

    private TransportTypePointsEnum(int points){
        this.points=points;
    }

    public int getPoints() {
        return points;
    }
}
