package com.tomveselka.prazskalitackamobile.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TransportTypeNameEnum {
    METRO("metro","metro"),
    BUS("bus","bus"),
    TRAM("tram","tramvaj"),
    FERRY("ferry","přívoz"),
    TROLLEYBUS("trolleybus","trolejbus"),
    FUNICULAR("funicular","lanovka"),
    TRAIN("train","vlak");

    private final String enName;
    private final String czName;

    TransportTypeNameEnum(String enName, String czName){
        this.enName=enName;
        this.czName=czName;
    }

    public String getEnName() {
        return enName;
    }

    public String getCzName() {
        return czName;
    }

    public static String getEnNameFromCzName(String czechName){
        return Arrays.stream(TransportTypeNameEnum.values())
                .filter(types -> types.czName.equals(czechName))
                .findFirst()
                .get().enName;
    }

    public static String getCzNameFromEnName(String englishName){
        return Arrays.stream(TransportTypeNameEnum.values())
                .filter(types -> types.enName.equals(englishName))
                .findFirst()
                .get().czName;
    }
}
