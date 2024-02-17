package com.tomveselka.prazskalitackamobile.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rows_of_races")
public class RowEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int race_id;

    private boolean fromDuplicate;
    private int fromPoints;
    private boolean fromBonus;
    private String fromStation;


    private boolean toDuplicate;
    private int toPoints;
    private boolean toBonus;
    private String toStation;

    private boolean lineDuplicate;
    private int linePoints;
    private boolean lineBonus;
    private String lineNumber;
    private String lineType;

    private boolean isNonStandard;
    private String nonStandardDescription;

    private int totalPoints;

    public boolean isFromDuplicate() {
        return fromDuplicate;
    }

    public void setFromDuplicate(boolean fromDuplicate) {
        this.fromDuplicate = fromDuplicate;
    }

    public int getFromPoints() {
        return fromPoints;
    }

    public void setFromPoints(int fromPoints) {
        this.fromPoints = fromPoints;
    }

    public boolean isFromBonus() {
        return fromBonus;
    }

    public void setFromBonus(boolean fromBonus) {
        this.fromBonus = fromBonus;
    }

    public boolean isToDuplicate() {
        return toDuplicate;
    }

    public void setToDuplicate(boolean toDuplicate) {
        this.toDuplicate = toDuplicate;
    }

    public int getToPoints() {
        return toPoints;
    }

    public void setToPoints(int toPoints) {
        this.toPoints = toPoints;
    }

    public boolean isToBonus() {
        return toBonus;
    }

    public void setToBonus(boolean toBonus) {
        this.toBonus = toBonus;
    }

    public boolean isLineDuplicate() {
        return lineDuplicate;
    }

    public void setLineDuplicate(boolean lineDuplicate) {
        this.lineDuplicate = lineDuplicate;
    }

    public int getLinePoints() {
        return linePoints;
    }

    public void setLinePoints(int linePoints) {
        this.linePoints = linePoints;
    }

    public boolean isLineBonus() {
        return lineBonus;
    }

    public void setLineBonus(boolean lineBonus) {
        this.lineBonus = lineBonus;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNonStandard() {
        return isNonStandard;
    }

    public void setNonStandard(boolean nonStandard) {
        isNonStandard = nonStandard;
    }

    public String getNonStandardDescription() {
        return nonStandardDescription;
    }

    public void setNonStandardDescription(String nonStandardDescription) {
        this.nonStandardDescription = nonStandardDescription;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public RowEntity() {
    }

    public RowEntity(boolean fromDuplicate, int fromPoints, boolean fromBonus, String fromStation, boolean toDuplicate, int toPoints, boolean toBonus, String toStation, boolean lineDuplicate, int linePoints, boolean lineBonus, String lineNumber, String lineType, boolean isNonStandard, String nonStandardDescription, int totalPoints,int race_id) {
        this.fromDuplicate = fromDuplicate;
        this.fromPoints = fromPoints;
        this.fromBonus = fromBonus;
        this.fromStation = fromStation;
        this.toDuplicate = toDuplicate;
        this.toPoints = toPoints;
        this.toBonus = toBonus;
        this.toStation = toStation;
        this.lineDuplicate = lineDuplicate;
        this.linePoints = linePoints;
        this.lineBonus = lineBonus;
        this.lineNumber = lineNumber;
        this.lineType = lineType;
        this.isNonStandard = isNonStandard;
        this.nonStandardDescription = nonStandardDescription;
        this.totalPoints = totalPoints;
        this.race_id = race_id;
    }

    @Override
    public String toString() {
        return "RowEntity{" +
                "id=" + id +
                ", race_id=" + race_id +
                ", fromDuplicate=" + fromDuplicate +
                ", fromPoints=" + fromPoints +
                ", fromBonus=" + fromBonus +
                ", fromStation='" + fromStation + '\'' +
                ", toDuplicate=" + toDuplicate +
                ", toPoints=" + toPoints +
                ", toBonus=" + toBonus +
                ", toStation='" + toStation + '\'' +
                ", lineDuplicate=" + lineDuplicate +
                ", linePoints=" + linePoints +
                ", lineBonus=" + lineBonus +
                ", lineNumber='" + lineNumber + '\'' +
                ", lineType='" + lineType + '\'' +
                ", isNonStandard=" + isNonStandard +
                ", nonStandardDescription='" + nonStandardDescription + '\'' +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
