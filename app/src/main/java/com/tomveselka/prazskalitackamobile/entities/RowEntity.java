package com.tomveselka.prazskalitackamobile.entities;

public class RowEntity {

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

    public RowEntity(boolean fromDuplicate, int fromPoints, boolean fromBonus, String fromStation, boolean toDuplicate, int toPoints, boolean toBonus, String toStation, boolean lineDuplicate, int linePoints, boolean lineBonus, String lineNumber, String lineType) {
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
    }

    public RowEntity() {
    }

    @Override
    public String toString() {
        return "RowEntity{" +
                "fromDuplicate=" + fromDuplicate +
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
                '}';
    }
}
