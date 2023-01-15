package org.eldorado.model;

public abstract class BasicReport {
    protected String company;

    protected Integer year;
    public abstract String printCsv(char CSV_SEPARATOR);

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
