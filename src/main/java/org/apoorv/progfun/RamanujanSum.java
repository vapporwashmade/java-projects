package org.apoorv.progfun;

// ADD-DOC: infinite sum
// estimates the sum of a divergent infinite series until calculation is done m times
// the infinite series is: sqrt(1 + 2 * sqrt (1 + 3 * sqrt (...)))
// series written in latex <a href="https://latex2png.com/pngs/2b912a3ea21ea9d1b8e890b8286e88d7.png">here</a>
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
        // Recursive case
        return getSum(n - 1, Math.sqrt(1 + (n * acc)));
    }

    public static void main(String[] args) {
        int m = 50;
        for (int i = 2; i < m; i++) {
            double sum = getSum(i, 1);
            System.out.println("n = " + i + ": " + sum);
            System.out.println("ratio to 3: " + sum / 3);
        }
    }
}