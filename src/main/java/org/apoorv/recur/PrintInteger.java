package org.apoorv.recur;

// ADD-DOC: recur
public class PrintInteger {
    public static void main(String[] args) {
        printInteger(0);
    }

    public static void printInteger(int n) {
        int digits = nDigits(n);
        for (int i = 0; i < digits; i++) {
            System.out.print((char)('0' + ithDigit(n, i)));
        }
    }

    private static int ithDigit(int n, int i) {
        int div = nDigits(n) - i - 1;
        for (int j = 0; j < div; j++) {
            n /= 10;
        }
        return n%10;
    }

    private static int nDigits(int n) {
        int digits = 1;
        while (true) {
            if (n < 10) {
                return digits;
            }
            n /= 10;
            digits++;
        }
    }
}
