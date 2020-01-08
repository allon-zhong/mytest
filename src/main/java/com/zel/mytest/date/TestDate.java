package com.zel.mytest.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        String dateStr = "2020-12-31 16:00:00";
        test3(dateStr);
    }

    private static void test1(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse(dateStr);
        Date date2 = new Date();
        long difference = (date2.getTime() - date1.getTime()) / 86400000;
    }
    private static void test2(String dateStr) throws ParseException {
        for(int i=0;i<30;i++){
            String serialNo = UUID.randomUUID().toString();
            System.out.println(serialNo);
        }
    }
    private static void test3(String dateStr) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date parse = format2.parse(dateStr);
        String format = format2.format(parse);
        System.out.println(format);
    }

}
