package org.apoorv.progfun;

public class CounterfeitCoin {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 100);
        System.out.println("number: " + n + ", weighings: " + simulate(n));
    }

    private static double weigh() {
        return Math.random();
    }

    public static int simulate(int n) {
        // base case
        if (n <= 3) {
            return 1;
        }
        // recursive case
        int remainder = n % 3;
        int weighings;
        if (remainder == 0) {
            weighings = simulate(n / 3);
        } else if (remainder == 1) {
            double balance = weigh();
            if (balance <= 0.66) {
                weighings = simulate((n - 1) / 3);
            } else {
                weighings = simulate((n + 2) / 3);
            }
        } else {
            double balance = weigh();
            if (balance <= 0.66) {
                weighings = simulate((n + 1) / 3);
            } else {
                weighings = simulate((n - 2) / 3);
            }
        }
        return weighings + 1;
    }
}
