package org.apoorv.progfun;

import java.util.Arrays;

public class Transpose {
    /**
     * A matrix, as you may know, is a tabular arrangement of numbers (or other things). An mxn (m by n) matrix has
     * m rows, each containing n numbers, or, it has m rows and n columns. As an example, here is a 2x3 matrix:
     * 1 2 4
     * 3 6 9
     * <p>
     * An mxn matrix can be represented as an int[][] in Java.
     * <p>
     * The transpose of a given matrix M is defined as another matrix N such that rows of M become columns of N.
     * Thus, if M has m rows and n columns, N, its transpose, has n rows and m columns.
     *
     * @param a
     * @return
     */
    public static final double[][] transpose(double[][] a) {
        int m = a.length;
        int n = a[0].length;
        double[][] transpose = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = a[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        double[][] a = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(transpose(a)));
    }
}
