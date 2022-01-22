package org.apoorv.recur;

import static org.apoorv.recur.DigitSum.digitSum;

// ADD-DOC: recur
public class DigitalRoot {
    public static void main(String[] args) {
        System.out.println(digitalRoot(1969));
    }

    public static int digitalRoot(int n) {
        if (n < 10) {
            return n;
        }
        return digitalRoot(digitSum(n));
    }
}
