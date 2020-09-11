package org.apoorv.recur;

/**
 * Exercise 3-1 from "Thinking Recursively" by Eric Roberts.
 * Problem Statement:
 * Unlike languages designed for scientific computation, Java contains no operator to raise a number to a given power,
 * although it does have a function in the Math class that accomplishes the task. Assuming that the exponent k is always
 * a nonnegative integer, write a recursive function power(x, k) that raises the real value x to the k power.
 */
public class Power {
    public static double power(double x, int k) {
        // Base Case
        if (k == 0) {
            return 1;
        }
        return power(x, k-1) * x;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(power(1.618, i));
        }
    }
}
