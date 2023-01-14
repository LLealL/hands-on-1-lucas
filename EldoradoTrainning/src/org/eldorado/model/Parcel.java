package org.eldorado.model;

import java.util.Date;

public class Parcel {

    private Double Value;

    private Date date;

    public Parcel(Double value, Date date) {
        Value = value;
        this.date = date;
    }

    public Parcel(){

    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
