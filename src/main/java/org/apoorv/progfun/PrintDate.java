package org.apoorv.progfun;

import java.util.Scanner;

// ADD-DOC: print date
// prints the date for the nth day in a year (1 <= n < 367)
// e.g. Jan 1st is the 1st day, Feb 4th is the 35th day, etc.
public class PrintDate {
    private static final int[] numOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an integer from 1 to 365 (366 for leap years): ");
        int num = in.nextInt();
        System.out.print("In which year? ");
        int year = in.nextInt();
        boolean isLeapYear = false;
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                isLeapYear = true;
            }
        } else if (year % 4 == 0) {
            isLeapYear = true;
        }
        String res = getDate(num, isLeapYear);
        System.out.println(res);
    }

    public static String getDate(int day, boolean leapYear) {
        if (leapYear) {
            numOfDays[1]++;
            if (day > 366) {
                day %= 366;
            }
        } else {
            if (day > 365) {
                day %= 365;
            }
        }
        for (int i = 0; i < numOfDays.length; i++) {
            if (day > numOfDays[i]) {
                day -= numOfDays[i];
            } else {
                return months[i] + " " + day;
            }
        }
        return "Some error occurred. Please try again.";
    }
}