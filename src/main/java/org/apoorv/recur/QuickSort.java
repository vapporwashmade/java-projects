package org.apoorv.recur;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = getSameElementArray(500_000);
//        System.out.println(Arrays.toString(a));
        sortRecursive(a, 0, a.length);
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);
    }

    static int[] getRandArray(int len) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        return a;
    }

    static int[] getSameElementArray(int len, int... defval) {
        int v = defval.length > 0 ? defval[0] : 0;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = v;
        }
        return a;
    }

    private static int partition(int[] a, int pi, int low, int high) {
        int pivot = a[pi];
        for (int i = low; i < high; i++) {
            if (a[i] < pivot) {
                a[pi] = a[i];
                a[i] = a[pi + 1];
                pi++;
            }
        }
        a[pi] = pivot;
        return pi;
    }

    public static void sortRecursive(int[] a, int low, int high) {
        // base case
        if (high - low <= 1) {
            return;
        }
        // recursive case
        int pi = partition(a, low, low, high);
        sortRecursive(a, low, pi);
        sortRecursive(a, pi + 1, high);
    }
}
