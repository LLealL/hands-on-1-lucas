package org.eldorado.utils.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";

    public static Date convertDate(String format, String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
