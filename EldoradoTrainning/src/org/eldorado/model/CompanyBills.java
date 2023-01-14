package org.eldorado.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyBills {

    private String name;

    private List<Billing> billingList;

    public CompanyBills() {
        this.billingList = new ArrayList<>();
    }

    public void addBilling(Billing billing){
        this.billingList.add(billing);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Billing> getBillingList() {
        return billingList;
    }

    public void setBillingList(List<Billing> billingList) {
        this.billingList = billingList;
    }

}
