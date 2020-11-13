package org.apoorv.progfun;

/**
 * This class evaluates polynomials given the coefficients of all the terms and x, iteratively and recursively.
 */
public class Poly {
    public static void main(String[] args) {
        System.out.println(polyRec(3, new double[]{}, 0));
    }

    public static double polyRec(double c, double[] a, int n) {
        // Base Case
        if (n == a.length - 1) {
            return a[n];
        }
        // Recursive Case
        return c * polyRec(c, a, n + 1) + a[n];
    }

    public static double polyIter(double c, double[] a) {
        double result = a[a.length-1];
        for (int i = a.length - 2; i >= 0; i--) {
            result = c * result + a[i];
        }
        return result;
    }

}
