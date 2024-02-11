package com.tomveselka.prazskalitackamobile.race.domain;

import com.tomveselka.prazskalitackamobile.race.repository.TransportTypePointsRepository;

public class EvaluateNewRow {
    public boolean isStationUnique(String station){
        return true;
    }
    public boolean isStationBonus(String station){
        return true;
    }
    public int calculatePointsForStation(String station){
        int points=0;
        if(isStationUnique(station)){
            if(isStationBonus(station)) {
                points += 23;
            }else{
                points += 3;
            }
        }
        return points;
    }

    public boolean isLineUnique(String station){
        return true;
    }
    public boolean isLineBonus(String station){
        return true;
    }
    public int calculatePointsForLine(String line, String type){
        int points=0;
        TransportTypePointsRepository pointsRepo = new TransportTypePointsRepository();
        int pointsForType =pointsRepo.getPointsFromType(type);
        if(isStationUnique(line)){
            if(isStationBonus(line)) {
                points += 20+pointsForType;
            }else{
                points += pointsForType;
            }
        }
        return points;
    }
}
