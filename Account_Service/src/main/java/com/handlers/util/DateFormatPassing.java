package com.handlers.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatPassing {

    private static SimpleDateFormat dobDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Date getDobFromString(String dobString) throws ParseException{
        dobDateFormat.setLenient(false);
        Date dob = dobDateFormat.parse(dobString);
        return dob;
    }
}
