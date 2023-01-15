package org.eldorado.model;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyNote {

    private String Company;

    private Integer month;

    private Integer year;

    private BigDecimal value;

    private Date emissionDate;

    private Integer note;

    public String getCompany() {
        return Company;
    }


    public void setCompany(String company) {
        Company = company;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
