package org.apoorv.progfun;

import java.util.Arrays;

// ADD-DOC: determinant
// directly calculates the determinant of a given square matrix
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
        System.out.println(determinant(new double[][]{{6, 5, 1, 2}, {9, 2, 8, 6}, {7, 5, 10, 8}, {4, 6, 2, 10}}));
    }

    public static double determinant(double[][] a) {
        // Base Case
        if (a.length == 2) {
            return a[0][0] * a[1][1] - a[0][1] * a[1][0];
        }
        // Recursive Case
        double determinant = 0;
        int multiplier = 1;
        for (int i = 0; i < a.length; i++) {
            double x = determinant(remove(a, i));
            x = a[0][i] * x * multiplier;
            determinant += x;
            multiplier *= -1;
        }
        return determinant;
    }

    public static double[][] remove(double[][] a, int index) {
        a = Arrays.copyOfRange(a, 1, a.length);
        for (int i = 0; i < a.length; i++) {
            double[] newA = new double[a.length];
            int count = 0;
            for (int j = 0; j < a.length + 1; j++) {
                if (j != index) {
                    newA[count] = a[i][j];
                    count++;
                }
            }
            a[i] = newA;
        }
        return a;
    }
}
