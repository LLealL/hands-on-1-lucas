package org.eldorado.utils.converters;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocaleConverter {
    private Locale locale;
    public LocaleConverter(String language, String region) {
        locale = new Locale.Builder().setLanguage(language).setRegion(region).build();
    }

    public Double convertDoubleValues(String value){
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        if(value == null || value == ""){
            value="0";
        }
        try {
            return nf.parse(value).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



}
