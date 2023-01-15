package org.eldorado.model;

import java.math.BigDecimal;

public class ConformityReport extends BasicReport {
    private BigDecimal totalBills;

    private BigDecimal NotedBills;


    public BigDecimal getTotalBills() {
        return totalBills;
    }

    public void setTotalBills(BigDecimal totalBills) {
        this.totalBills = totalBills;
    }

    public BigDecimal getNotedBills() {
        return NotedBills;
    }

    public void setNotedBills(BigDecimal notedBills) {
        NotedBills = notedBills;
    }

    @Override
    public String printCsv(char CSV_SEPARATOR) {
        return new StringBuilder().append(this.company).append(CSV_SEPARATOR)
                .append(this.year).append(CSV_SEPARATOR)
                .append(this.totalBills).append(CSV_SEPARATOR)
                .append(this.NotedBills).toString();

    }

    @Override
    public String getCompany() {
        return super.getCompany();
    }
    @Override
    public Integer getYear() {
        return super.year;
    }
}
