package org.eldorado.model;


import java.util.ArrayList;
import java.util.List;

public class Billing {

    private List<Parcel> parcelList;

    private Integer year;

    private Integer month;

    public Billing() {
        this.parcelList = new ArrayList<>();
    }

    public void addParcel(Parcel parcel){
        parcelList.add(parcel);
    }

    public List<Parcel> getParcelList() {
        return parcelList;
    }

    public void setParcelList(List<Parcel> parcelList) {
        this.parcelList = parcelList;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
