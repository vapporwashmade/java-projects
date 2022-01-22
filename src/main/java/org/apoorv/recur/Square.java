package org.apoorv.recur;

// ADD-DOC: recur
public class Square {
    public static int square(int n) {
        // Base Case
        if (n == 0) {
            return 0;
        }
        return square(n - 1) + 2 * n - 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 36; i++) {
            System.out.printf("%d^2 = %d\n", i, square(i));
        }
    }
}
