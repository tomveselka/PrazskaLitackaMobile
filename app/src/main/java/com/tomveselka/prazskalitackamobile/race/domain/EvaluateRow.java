package com.tomveselka.prazskalitackamobile.race.domain;

import com.tomveselka.prazskalitackamobile.enums.BonusPointsEnum;
import com.tomveselka.prazskalitackamobile.enums.TransportTypePointsEnum;

public class EvaluateRow {
    public boolean isStationUnique(String station){
        return true;
    }
    public boolean isStationBonus(String station){
        return false;
    }
    public boolean isStationZoneBonus(String station){return false;}
    public int calculatePointsForStation(String station){
        int points=0;
        if(isStationUnique(station)){
            points += 3;
            if(isStationBonus(station)) {
                points += BonusPointsEnum.STATION.getPoints();
            }
            if(isStationZoneBonus(station)){
                points += BonusPointsEnum.ZONE.getPoints();
            }

        }
        return points;
    }

    public boolean isLineUnique(String station){
        return true;
    }
    public boolean isLineBonus(String station){
        return false;
    }
    public int calculatePointsForLine(String line, String type, boolean isDiversion){
        int points=0;
        if(isStationUnique(line)){
            points += getLinePointsByType(line, type);
            if(isStationBonus(line)) {
                points += BonusPointsEnum.LINE.getPoints();
            }
            if(isDiversion){
                points += BonusPointsEnum.DIVERSION.getPoints();
            }
        }
        return points;
    }

    public int getLinePointsByType(String line, String type){
        switch (type) {
            case "metro": return TransportTypePointsEnum.METRO.getPoints();
            case "bus": return Integer.valueOf(line.replaceAll("[^\\d.]", ""))<300
                    ? TransportTypePointsEnum.BUS_CITY.getPoints()
                    : Integer.valueOf(line.replaceAll("[^\\d.]", ""))<400
                        ?TransportTypePointsEnum.BUS_300.getPoints()
                        : TransportTypePointsEnum.BUS_400.getPoints();
            case "tram": return TransportTypePointsEnum.TRAM.getPoints();
            case "train": return line.substring(0,1).equals("S")
                    ? TransportTypePointsEnum.TRAIN_OS.getPoints()
                    : TransportTypePointsEnum.TRAIN_R.getPoints();
            case "ferry": return TransportTypePointsEnum.FERRY.getPoints();
            case "funicular": return TransportTypePointsEnum.FUNICULAR.getPoints();
            case "trolleybus": return TransportTypePointsEnum.TROLLEYBUS.getPoints();
            default: return 0;
        }
    }
}
