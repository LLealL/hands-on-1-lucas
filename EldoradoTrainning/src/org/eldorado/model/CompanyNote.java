package org.eldorado.model;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CompanyNote {

    private String Company;

    private List<MonthNote> monthNoteList;


    public CompanyNote() {
        this.monthNoteList = new ArrayList<>();
    }

    public void addMonthNote(MonthNote note){
        monthNoteList.add(note);
    }


    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public List<MonthNote> getMonthNoteList() {
        return monthNoteList;
    }

    public void setMonthNoteList(List<MonthNote> monthNoteList) {
        this.monthNoteList = monthNoteList;
    }

}
