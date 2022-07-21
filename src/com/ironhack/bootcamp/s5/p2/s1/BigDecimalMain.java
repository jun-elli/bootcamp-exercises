package com.ironhack.bootcamp.s5.p2.s1;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class BigDecimalMain {
    public static void main(String[] args) {
        double a = .7;
        double b = .1;
        double c = .2;
        System.out.println(a + b);
        System.out.println(c + b);


        BigDecimal bdA = new BigDecimal(".7");
        BigDecimal bdB = new BigDecimal(".1");
        BigDecimal sum = bdA.add(bdB);
        BigDecimal displayVal = sum.setScale(20, RoundingMode.HALF_EVEN);
        System.out.println(displayVal);
    }
}