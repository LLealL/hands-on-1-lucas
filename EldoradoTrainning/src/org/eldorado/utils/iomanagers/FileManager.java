package org.eldorado.utils.iomanagers;

import org.eldorado.model.*;
import org.eldorado.utils.converters.DateConverter;
import org.eldorado.utils.converters.LocaleConverter;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileManager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class.getName());

    static final String PATH = "resources/";



    public void writeFile(String filename, List<BasicReport> list ){

        try {
            BufferedWriter writer = new BufferedWriter((new FileWriter(filename)));
            list.forEach(item ->{
                try {
                    writer.append(item.printCsv(';')).append((System.lineSeparator()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CompanyBills> readCompanyBillsFile(String fileName){
        List<CompanyBills> companiesBilling = new ArrayList<>();

        InputStream inputFS = null;

        try{
            inputFS = new FileInputStream(new File(String.format("%s/%s",PATH,fileName)));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFS));
            companiesBilling = bufferedReader.lines().skip(1).map(mapToBill).collect(Collectors.toList());
            bufferedReader.close();

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return companiesBilling;
    }

    public List<CompanyNote> readCompanyNoteFile(String fileName){
        List<CompanyNote> companiesNote = new ArrayList<>();
        InputStream inputFS = null;
        try{
            inputFS = new FileInputStream(new File(String.format("%s/%s",PATH,fileName)));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFS));
            companiesNote = bufferedReader.lines().skip(1).map(mapToNote).collect(Collectors.toList());
            bufferedReader.close();

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return companiesNote;
    }

    private Function<String, CompanyBills> mapToBill = (line)->
    {
        LocaleConverter converter = new LocaleConverter("pt","BR");
        String[] p = line.split(";");
        CompanyBills item = new CompanyBills();

        item.setName(p[0]);
        item.setMonth(Integer.parseInt(p[1]));
        item.setYear(Integer.parseInt(p[2]));
        item.setDate1(DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY,p[3]));
        item.setParcel1(BigDecimal.valueOf(converter.convertDoubleValues(p[4])));
        item.setDate2(DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY,p[5]));
        item.setParcel2(BigDecimal.valueOf(converter.convertDoubleValues(p[6])));
        item.setDate3(DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY,p[7]));
        item.setParcel3(BigDecimal.valueOf(converter.convertDoubleValues(p[8])));

        return item;

    };

    private Function<String, CompanyNote> mapToNote = (line)->
    {
        LocaleConverter converter = new LocaleConverter("pt","BR");
        String[] p = line.split(";",6);
        CompanyNote item = new CompanyNote();

        item.setCompany(p[0]);
        item.setMonth(Integer.parseInt(p[1]));
        item.setYear(Integer.parseInt(p[2]));
        item.setValue(BigDecimal.valueOf(converter.convertDoubleValues(p[3])));
        if(p[4]!=null && p[4]!=""){
            item.setEmissionDate(DateConverter.convertDate(DateConverter.FORMAT_DD_MM_YYYY,p[4]));
        }
        if(p[5]=="") {
            p[5]="0";
        }
        item.setNote(Integer.parseInt(p[5]));

        return item;

    };

}
