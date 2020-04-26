package org.apoorv.progfun;

public class LinearSearch {
    public static void main(String[] args) {

    }

    public static boolean existsV1(int[] a, int x) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static boolean existsV2(int[] a, int x) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                return true;
            }
            if (a[i] > x) {
                return false;
            }
        }
        return false;
    }

    public static boolean existsV3(int[] a, int x) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] >= x) {
                break;
            }
        }
        // Now, a[i] >= x
        return false;
    }
}
