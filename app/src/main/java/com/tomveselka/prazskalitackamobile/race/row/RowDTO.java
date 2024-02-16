package com.tomveselka.prazskalitackamobile.race.row;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class RowDTO implements Parcelable {
    private int id;
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

    protected RowDTO(Parcel in) {
        id = in.readInt();
        fromDuplicate = in.readByte() != 0;
        fromPoints = in.readInt();
        fromBonus = in.readByte() != 0;
        fromStation = in.readString();
        toDuplicate = in.readByte() != 0;
        toPoints = in.readInt();
        toBonus = in.readByte() != 0;
        toStation = in.readString();
        lineDuplicate = in.readByte() != 0;
        linePoints = in.readInt();
        lineBonus = in.readByte() != 0;
        lineNumber = in.readString();
        lineType = in.readString();
    }

    public static final Creator<RowDTO> CREATOR = new Creator<RowDTO>() {
        @Override
        public RowDTO createFromParcel(Parcel in) {
            return new RowDTO(in);
        }

        @Override
        public RowDTO[] newArray(int size) {
            return new RowDTO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeByte((byte) (fromDuplicate ? 1 : 0));
        parcel.writeInt(fromPoints);
        parcel.writeByte((byte) (fromBonus ? 1 : 0));
        parcel.writeString(fromStation);
        parcel.writeByte((byte) (toDuplicate ? 1 : 0));
        parcel.writeInt(toPoints);
        parcel.writeByte((byte) (toBonus ? 1 : 0));
        parcel.writeString(toStation);
        parcel.writeByte((byte) (lineDuplicate ? 1 : 0));
        parcel.writeInt(linePoints);
        parcel.writeByte((byte) (lineBonus ? 1 : 0));
        parcel.writeString(lineNumber);
        parcel.writeString(lineType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
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

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
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

    public RowDTO() {
    }

    @Override
    public String toString() {
        return "RowDTO{" +
                "id=" + id +
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
                '}';
    }
}
