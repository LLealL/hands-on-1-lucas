package org.eldorado.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyBills {

    private String name;


    private BigDecimal parcel1;

    private Date date1;

    private BigDecimal parcel2;

    private Date date2;

    private BigDecimal parcel3;

    private Date date3;

    private Integer year;

    private Integer month;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getParcel1() {
        return parcel1;
    }

    public void setParcel1(BigDecimal parcel1) {
        this.parcel1 = parcel1;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public BigDecimal getParcel2() {
        return parcel2;
    }

    public void setParcel2(BigDecimal parcel2) {
        this.parcel2 = parcel2;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public BigDecimal getParcel3() {
        return parcel3;
    }

    public void setParcel3(BigDecimal parcel3) {
        this.parcel3 = parcel3;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
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
