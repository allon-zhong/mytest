package com.zel.mytest.Bigdecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestBigDecimal {
    public static void main(String[] args) {
        Double aDouble = Double.valueOf("8.44");
        System.out.println(aDouble);
        System.out.println(10-aDouble);
        BigDecimal bigDecimal = new BigDecimal("8.44");
        BigDecimal bigDecimal2 = new BigDecimal("10");
        System.out.println(bigDecimal2.subtract(bigDecimal));
        String s = bigDecimal2.subtract(bigDecimal).setScale(1, BigDecimal.ROUND_HALF_UP).toString();
        System.out.println(s);

    }
}
