package org.apoorv.progfun;

/**
 * This program determines the amount of times a number appears in a sorted array.
 */
public class LinearCount {
    public static void main(String[] args) {
        int x = 1;
        int[] a = {1, 1, 2, 2, 2, 2, 3, 5, 7, 7};
        System.out.println(linearCount(a, x));
    }

    /**
     * Linear search implementation to find out how many times a number appears in a sorted array.
     * @param a A sorted array (monotonically increasing)
     * @param x The number to be found
     * @return The number of times x appears in a
     */
    public static int linearCount(int[] a, int x) {
        int count = 0;
        for (int value : a) {
            if (value == x) {
                count++;
            } else if (value > x) {
                return count;
            }
        }
        return count;
    }
}
