package org.apoorv.recur;

public class GCD {
    public static int gcd(int x, int y) {
        // Base cases
        if (x == 0) {
            return y;
        }
        if (y == 0) {
            return x;
        }
        // Recursive case
        if (x > y) {
            return gcd(x % y, y);
        } else {
            return gcd(x, y % x);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(827904, 209676));
    }
}
