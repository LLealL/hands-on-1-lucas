package org.eldorado.service;

import org.eldorado.model.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ReportGenerator {

    public List<BasicReport> generateReport(List<CompanyBills> billing){

        Map<String, List<CompanyBills>> mapBills = billing.stream().collect(groupingBy(CompanyBills::getName));
        List<BasicReport> billsReportList  = new ArrayList<>();

        for (var entry : mapBills.entrySet()){
            Map<Integer, List<CompanyBills>> yearBills = entry.getValue().stream().collect(groupingBy(CompanyBills::getYear));

            for(var yearEntry : yearBills.entrySet()){
                var report = new BillsReport();
                report.setCompany(entry.getKey());
                report.setYear(yearEntry.getKey());
                BigDecimal totalBillP1 = BigDecimal.ZERO;
                BigDecimal totalBillP2 = BigDecimal.ZERO;
                BigDecimal totalBillP3 = BigDecimal.ZERO;

                BigDecimal totalBillyear = BigDecimal.ZERO;
                for(var bill : yearEntry.getValue()){
                  totalBillP1= totalBillP1.add(bill.getParcel1());
                  totalBillP2= totalBillP2.add(bill.getParcel2());
                  totalBillP3= totalBillP3.add(bill.getParcel3());

                }
                totalBillyear = totalBillyear.add(totalBillP1);
                totalBillyear = totalBillyear.add(totalBillP2);
                totalBillyear = totalBillyear.add(totalBillP3);
                report.setTotalBills(totalBillyear);
                report.setTotalBillP1(totalBillP1);
                report.setTotalBillP2(totalBillP2);
                report.setTotalBillP3(totalBillP3);

                billsReportList.add(report);
            }


        }
        return billsReportList;
    }

    public List<BasicReport> createBillConformityReportFile(List<CompanyBills> billing, List<CompanyNote> notes,boolean conformity){
        List<BasicReport> billsReportsList = generateReport(billing);
        Map<String, List<BillsReport>> groupedReport = new HashMap<>();
        List<BasicReport> reportList = new ArrayList<>();
        for (BasicReport basicReport : billsReportsList) {
            groupedReport.computeIfAbsent(basicReport.getCompany(), k -> new ArrayList<>()).add((BillsReport) basicReport);
        }

        Map<String,List<CompanyNote>> groupedNotes = notes.stream().collect(Collectors.groupingBy(CompanyNote::getCompany));
        for(var entry: groupedReport.entrySet()){

            for(var bill : entry.getValue()){
                List<CompanyNote> groupedNotesByCompany = groupedNotes.get(bill.getCompany());
                BigDecimal totalValue = BigDecimal.ZERO;
                if(groupedNotesByCompany!=null) {
                    for (var item : groupedNotesByCompany) {
                        if (item.getYear().compareTo(bill.getYear()) == 0) {
                            totalValue = totalValue.add(item.getValue());

                        }
                    }

                    if (bill.getTotalBills().compareTo(totalValue)==0 && conformity) {
                        ConformityReport report = new ConformityReport();
                        report.setCompany(bill.getCompany());
                        report.setYear(bill.getYear());
                        report.setTotalBills(bill.getTotalBills());
                        report.setNotedBills(totalValue);
                        reportList.add(report);
                    }
                    if (bill.getTotalBills().compareTo(totalValue)!=0 && !conformity) {
                        ConformityReport report = new ConformityReport();
                        report.setCompany(bill.getCompany());
                        report.setYear(bill.getYear());
                        report.setTotalBills(bill.getTotalBills());
                        report.setNotedBills(totalValue);
                        reportList.add(report);
                    }
                }
            }
        }
        return reportList;
    }


}
