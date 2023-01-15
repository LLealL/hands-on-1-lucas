package org.eldorado.startup;

import org.eldorado.model.CompanyBills;
import org.eldorado.model.CompanyNote;
import org.eldorado.service.ReportGenerator;
import org.eldorado.utils.iomanagers.FileManager;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class StartUpReportGen {
    private static final Logger LOGGER = Logger.getLogger(StartUpReportGen.class.getName());
    static Scanner scanner = new Scanner(System.in);


    public void start(){

        LOGGER.info("Creating File Manager...");
        FileManager manager = new FileManager();
        LOGGER.info("Reading Bills Files...");
        List<CompanyBills> companyBillsList = manager.readCompanyBillsFile("faturamento.txt");
        LOGGER.info("Reading Notes Files...");
        List<CompanyNote> companyNotesList = manager.readCompanyNoteFile("nota.txt");
        LOGGER.info("Finished Reading Files.");

        System.out.println("Welcome to Report Generator");
        boolean end = false;
        do{
            System.out.println("Choose the routine you want to execute:");
            System.out.println("1- Create Full Billing Report");
            System.out.println("2- Create Conformity Billing Report");
            System.out.println("3- Create Non-Conformity Billing Report");
            System.out.println("0- Exit");
            int resp = Integer.parseInt(scanner.nextLine());
            ReportGenerator reportGenerator = new ReportGenerator();
            switch(resp){
                case 1:
                    LOGGER.info("Generating Report...");
                    manager.writeFile("FullBillingReport.txt",reportGenerator.generateReport(companyBillsList));
                    LOGGER.info("Report Created.");
                    break;
                case 2:
                    LOGGER.info("Generating Report...");
                    manager.writeFile("ConformityBillingReport.txt",reportGenerator.createBillConformityReportFile(companyBillsList,companyNotesList,true));
                    LOGGER.info("Report Created.");
                    break;
                case 3:
                    LOGGER.info("Generating Report...");
                    manager.writeFile("NonConformityBillingReport.txt",reportGenerator.createBillConformityReportFile(companyBillsList,companyNotesList,false));
                    LOGGER.info("Report Created.");
                    break;
                case 0:
                    end=true;
                    break;
                default:
                    LOGGER.info("Invalid Input...");
                    break;
            }
        }while(!end);
        LOGGER.info("fim");

    }


}
