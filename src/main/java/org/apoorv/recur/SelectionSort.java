package org.apoorv.recur;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{43, 3, 232, 3, 34, 19, 86, 19};
        sortIterative(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortIterative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
