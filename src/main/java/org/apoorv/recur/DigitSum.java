package org.apoorv.recur;

// ADD-DOC: recur
public class DigitSum {
    public static void main(String[] args) {
        System.out.println(digitSum(203934));
    }

    public static int digitSum(int n) {
        if (n < 10) {
            return n;
        }
        return digitSum(n / 10) + n % 10;
    }
}
