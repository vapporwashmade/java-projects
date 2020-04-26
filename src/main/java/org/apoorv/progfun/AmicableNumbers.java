package org.apoorv.progfun;

/**
 * Finds the pairs of amicable numbers between 1 and 1,000,000.
 * Amicable numbers are pairs of numbers where each are the sum of the proper divisors of the other.
 * The proper divisors of a number are the numbers beside the 
 */
public class AmicableNumbers {
    private static int[] divisorSums = new int[1000000]; // for each i, divisorSums[i] is the sum of proper divisors of i

    public static void main(String[] args) {
        for (int i = 0; i < divisorSums.length; i++) {
            int sum = 1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sum += j;
                    if (j != i / j) {
                        sum += (i / j);
                    }
                }
            }
            divisorSums[i] = sum;
        }
        for (int i = 0; i < divisorSums.length; i++) {
            if (divisorSums[i] < divisorSums.length && divisorSums[i] >= 0 && i != divisorSums[i] && i == divisorSums[divisorSums[i]] && divisorSums[i] != -1) {
                System.out.println(i + ", " + divisorSums[i]);
                divisorSums[divisorSums[i]] = -1;
            }
        }
    }

}
