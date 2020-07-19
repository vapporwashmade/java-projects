package org.apoorv.progfun;

public class RamanujanSum {
    public static double getSum(int n, double acc) {
        // Ramanujan sum not applicable
        if (n <= 1) {
            throw new IllegalArgumentException("No Ramanujan sum for n <= 1");
        }
        // Base case
        if (n == 2) {
            return Math.sqrt(1 + (2 * acc));
        }
        return getSum(n - 1, Math.sqrt(1 + (n * acc)));
    }

    public static void main(String[] args) {
        for (int i = 2; i < 50; i++) {
            double sum = getSum(i, 1);
            System.out.println("n = " + i + ": " + sum);
            System.out.println("ratio to 3: " + sum/3);
        }
    }
}