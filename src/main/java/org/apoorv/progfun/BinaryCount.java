package org.apoorv.progfun;

/**
 * This program determines the amount of times a number appears in a sorted array.
 */
public class BinaryCount {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int x = 1;
        System.out.println(binaryCount(a, x));
    }

    /**
     * Binary search implementation to find out how many times a number appears in a sorted array.
     * @param a A sorted array (monotonically increasing)
     * @param x The number to be found
     * @return The number of times x appears in a
     */
    public static int binaryCount(int[] a, int x) {
        int high = a.length;
        int low = 0;
        int mid = (low + high) / 2;
        while (a[mid] != x) {
            if (low == high - 1) {
                return 0;
            }
            if (a[mid] > x) {
                high = mid;
            } else if (a[mid] < x) {
                low = mid;
            }
            mid = (high + low) / 2;
        }
        int p = findFirst(a, low, mid, x);
        int q = findLast(a, mid, high, x);
        return q - p + 1;
    }

    private static int findFirst(int[] a, int low, int high, int x) {
        int mid = (low + high) / 2;
        while (true) {
            if (a[mid] == x) {
                if (mid == 0) {
                    return mid;
                } else if (a[mid - 1] < x) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < x) {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
    }

    private static int findLast(int[] a, int low, int high, int x) {
        int mid = (low + high) / 2;
        int len = a.length - 1;
        while (true) {
            if (a[mid] == x) {
                if (mid == len) {
                    return mid;
                } else if (a[mid + 1] > x) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] > x) {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
    }
}
