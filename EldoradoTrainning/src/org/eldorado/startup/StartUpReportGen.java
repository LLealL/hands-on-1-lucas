package org.eldorado.startup;

import org.eldorado.model.CompanyBills;
import org.eldorado.model.CompanyNote;
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
        System.out.println("Choose the routine you want to execute:");
        System.out.println("1- Create Conformity Billing Report");
        System.out.println("2- Create Non-Conformity Billing Report");
        System.out.println("0- Exit");




        LOGGER.info("fim");

    }


}
