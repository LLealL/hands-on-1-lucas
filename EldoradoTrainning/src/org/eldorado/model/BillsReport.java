package org.eldorado.model;

import java.math.BigDecimal;

public class BillsReport extends BasicReport {


    protected BigDecimal totalBillP1;
    protected BigDecimal totalBillP2;
    protected BigDecimal totalBillP3;

    public BigDecimal getTotalBillP1() {
        return totalBillP1;
    }

    @Override
    public String getCompany() {
        return super.getCompany();
    }
    @Override
    public Integer getYear() {
        return super.year;
    }

    public void setTotalBillP1(BigDecimal totalBillP1) {
        this.totalBillP1 = totalBillP1;
    }

    public BigDecimal getTotalBillP2() {
        return totalBillP2;
    }

    public void setTotalBillP2(BigDecimal totalBillP2) {
        this.totalBillP2 = totalBillP2;
    }

    public BigDecimal getTotalBillP3() {
        return totalBillP3;
    }

    public void setTotalBillP3(BigDecimal totalBillP3) {
        this.totalBillP3 = totalBillP3;
    }

    public BigDecimal getTotalBills() {
        return totalBills;
    }

    public void setTotalBills(BigDecimal totalBills) {
        this.totalBills = totalBills;
    }

    private BigDecimal totalBills;


    @Override
    public String printCsv(char CSV_SEPARATOR) {
        return new StringBuilder().append(this.company).append(CSV_SEPARATOR)
                .append(this.year).append(CSV_SEPARATOR)
                .append(this.totalBillP1).append(CSV_SEPARATOR)
                .append(this.totalBillP2).append(CSV_SEPARATOR)
                .append(this.totalBillP3).append(CSV_SEPARATOR)
                .append(this.totalBills).toString();
    }
}
