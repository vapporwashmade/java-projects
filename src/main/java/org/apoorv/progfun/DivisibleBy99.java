package org.apoorv.progfun;

/**
 * Find the smallest number that contains the digits 1 through 9 and is divisible by 99
 */
public class DivisibleBy99 {
    public static long findNaive() {
        long start = 123456789;
        while (true) {
            if (start % 99 == 0 && hasDigits(start)) {
                return start;
            }
            start++;
        }
    }

    private static boolean hasDigits(long num) {
        int[] digits = new int[10];
        while (num > 9) {
            int rem = (int) (num % 10);
            digits[rem]++;
            num /= 10;
        }
        digits[(int) num]++;
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findNaive());
    }
}
