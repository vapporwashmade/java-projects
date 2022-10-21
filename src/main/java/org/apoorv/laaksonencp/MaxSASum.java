package org.apoorv.laaksonencp;

public class MaxSASum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 4, -3, 5, 2, -5, 2};
        System.out.println(findMaxSum(arr));
        System.out.println(findMaxSumV2(arr));
    }

    public static int findMaxSum(int[] a) {
        int max = a[0];
        int sum;
        for (int i = 0; i < a.length; i++) {
            sum = a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum += a[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int findMaxSumV2(int[] a) {
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
            if (a[i] > sum) {
                sum = a[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
