package org.apoorv.progfun;

import java.util.Arrays;

// ADD-DOC: counting sort -- does not sort in-place
// takes two params, start -- the lowest number in the array -- and end -- the highest number in the array plus one.
// creates an array of the frequencies of each of the elements in the array to sort
// generates the sorted array from the frequency array by adding the elements as many times as they come in the original array into a new array
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {11, 24, 35, 8, 26, 23, 13, 18, 12, 19, 32, 14};
        System.out.println(Arrays.toString(sort(8, 36, arr)));
    }

    public static int[] sort(int start, int end, int[] a) {
        int[] frequency = new int[end - start];
        for (int i = 0; i < a.length; i++) {
            frequency[a[i] - start]++;
        }
        int pos = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                a[pos] = i + start;
                frequency[i]--;
                pos++;
                i--;
            }
        }
        return a;
    }
}
