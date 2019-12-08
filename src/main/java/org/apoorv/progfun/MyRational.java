package org.apoorv.progfun;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MyRational {
    public static void main(String[] args) {
        String[] x = rep10bit();
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public static String[] rep10bit() {
        String[] binStrings = BinaryString.getStrings(10);
        String[] strings = new String[1024];
        for (int i = 0; i < binStrings.length; i++) {
            strings[i] = interpret10bit(binStrings[i]);
        }
        return strings;
    }

    public static String interpret10bit(String bitStr) {
        String str = "";
        String sig = bitStr.substring(1, 5);
        String exp = bitStr.substring(6, 10);
        int sigsum = 0;
        int expsum = 1;
        for (int i = 0; i < 4; i++) {
            String c = Character.toString(sig.charAt(i));
            int d = Integer.parseInt(c);
            sigsum += d*Math.pow(2, i);
            c = Character.toString(exp.charAt(i));
            d = Integer.parseInt(c);
            expsum += d*Math.pow(2, i);
        }
        if (bitStr.charAt(0) == '1') {
            str = "-";
        }
        str += Integer.toString(sigsum);
        str += "e";
        if (bitStr.charAt(5) == '1') {
            str += "-";
        }
        str += Integer.toString(expsum);
        return str;
    }

//    public static String convert10bit(double num) {
//        BigDecimal n = new BigDecimal(num);
//        int i = n.compareTo(new BigDecimal(0.1));
//        int j = n.compareTo(new BigDecimal(1));
//        if (i == -1) {
//            while ();
//        } else if (j == 1) {
//
//        } else {
//
//        }
//    }
}