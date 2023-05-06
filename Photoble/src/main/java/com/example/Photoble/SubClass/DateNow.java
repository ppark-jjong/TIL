package com.example.Photoble.SubClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateNow {
    static public String timeNow(){
        Date now = new Date();
        SimpleDateFormat dayf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        return dayf.format(now).toString();
    }
}
