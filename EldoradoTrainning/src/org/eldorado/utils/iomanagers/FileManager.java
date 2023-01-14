package org.eldorado.utils.iomanagers;

import org.eldorado.model.*;
import org.eldorado.utils.converters.DateConverter;
import org.eldorado.utils.converters.LocaleConverter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileManager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class.getName());

    static final String PATH = "resources/";



    public void writeFile(){

    }

    public List<CompanyBills> readCompanyBillsFile(String fileName){
        List<CompanyBills> companiesBilling = new ArrayList<>();
        LocaleConverter converter = new LocaleConverter("pt","BR");
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format("%s/%s",PATH, fileName)));
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while(line !=null){
                String[] vector = line.split(";");
                var companyBills = new CompanyBills();
                companyBills.setName(vector[0]);
                var billing = new Billing();
                billing.setMonth(Integer.parseInt(vector[1]));
                billing.setYear(Integer.parseInt(vector[2]));
                var parcel = new Parcel(converter.convertDoubleValues(vector[4]),
                        DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY,vector[3]));
                billing.addParcel(parcel);
                parcel = new Parcel(converter.convertDoubleValues(vector[6]),
                        DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY,vector[5]));
                billing.addParcel(parcel);
                parcel = new Parcel(converter.convertDoubleValues(vector[8]),
                        DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY,vector[7]));
                billing.addParcel(parcel);
                companyBills.addBilling(billing);
                companiesBilling.add(companyBills);
                line = bufferedReader.readLine();
            }

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return companiesBilling;
    }

    public List<CompanyNote> readCompanyNoteFile(String fileName){
        List<CompanyNote> companiesNote = new ArrayList<>();
        LocaleConverter converter = new LocaleConverter("pt","BR");
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format("%s/%s",PATH, fileName)));
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while(line !=null){
                String[] vector = line.split(";",6);
                var companyNote = new CompanyNote();
                companyNote.setCompany(vector[0]);
                var note = new MonthNote();
                note.setMonth(Integer.parseInt(vector[1]));
                note.setYear(Integer.parseInt(vector[2]));
                note.setValue(converter.convertDoubleValues(vector[3]));
                if(vector[4]!="") {
                    note.setEmissionDate(DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY, vector[4]));
                }
                companyNote.addMonthNote(note);
                companiesNote.add(companyNote);

                line = bufferedReader.readLine();
            }

        }catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return companiesNote;
    }


}
