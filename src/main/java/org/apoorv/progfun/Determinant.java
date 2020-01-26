package org.apoorv.progfun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Determinant {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in).useDelimiter("\n");
//        System.out.print("How many rows/columns in the matrix (2-5)? ");
//        int rows = in.nextInt();
//        double[][] matrix = new double[rows][];
//        for (int i = 0; i < rows; i++) {
//            System.out.print("Print row " + (i+1) + " separated by spaces: ");
//            String[] row = in.next().split(" ");
//            double[] a = new double[rows];
//            for (int j = 0; j < row.length; j++) {
//                a[j] = Double.parseDouble(row[j]);
//            }
//            matrix[i] = a;
//        }
//        System.out.println(Arrays.deepToString(matrix));
//        System.out.println(determinant(matrix));
//        System.out.println(determinant(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(Arrays.deepToString(exclude(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public static double determinant(double[][] a) {
        // Base Case
        if (a[0].length == 2) {
            return a[0][0] * a[1][1] - a[0][1] * a[1][0];
        }
        // Recursive Case
        for (int i = 0; i < a.length; i++) {

        }
        return 1;
    }

    public static double[][][] exclude(double[][] a) {
        double[][][] matrices = new double[a.length][][];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 1; j < a.length; j++) {
                
            }
        }
        return matrices;
    }
}
