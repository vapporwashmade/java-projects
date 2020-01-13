package org.apoorv.progfun;

import java.util.Arrays;
import java.util.Random;

/**
 * Problems on Number Arrays
 * Methods 1-5: Nov. 23 2019
 */
public class NumArrayProblems {
    public static void main(String[] args) {
        int[] arr = {6, 42, 34, 100, 2, 6};
        System.out.println(checkFrequency(arr));
    }

    /**
     * Reverses the given array <u>in place</u> (modifies the original array), returning nothing.
     * @param a int[] that is to be reversed.
     */
    public static void reverse(int[] a) {
        int temp;
        for (int i = 0; i < a.length / 2; i++) {
            int x = a.length-1-i;
            temp = a[i];
            a[i] = a[x];
            a[x] = temp;
        }
    }

    /**
     * Given an array of integers between 0 and 100, returns a boolean indicating whether all numbers in the array appear at most once.
     * @param a int[] from 0 to 100 that is to be checked whether all numbers in it appear at most once.
     * @return Boolean indicating whether all numbers appear at most once.
     */
    public static boolean checkFrequency(int[] a) {
        if (a.length > 101) {
            return false;
        }
        int[] frequency = new int[101];
        for (int i = 0; i < a.length; i++) {
            if (frequency[a[i]] == 1) {
                return false;
            }
            frequency[a[i]]++;
        }
        return true;
    }

    /**
     * Given an array of integers, rearranges the array so that all zeros are shifted to the end. The order of the nonzero integers is preserved.
     * Modifies the array in place.
     * @param a int[] of which the zeros will be shifted to the end.
     */
    public static void shiftZerosRight(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[j] = a[i];
                j++;
            }
        }
        if (j > 0) {
            for (; j < a.length; j++) {
                a[j] = 0;
            }
        }
    }

    /**
     * Given an array of integers, find the length of the longest consecutive sequence of the same integer.
     * @param a int[] that is given to find the length of the longest consecutive sequence.
     * @return Integer representing the length of the longest consecutive sequence of an integer.
     */
    public static int longestSequence(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        int max = 1; // which is the length of consecutive sequence of a[0]
        int streak = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i-1]) {
                streak++;
            } else {
                streak = 1;
            }
            if (streak > max) {
                max = streak;
            }
        }
        return max;
    }

    /**
     * Given an array of digits (0-9), returns the base 10 integer it corresponds to.
     * For example, toBase10Int({3, 8, 2, 4, 4} would return 38244
     * @param a int[] consisting only of digits 0-9.
     * @return Long that corresponds to the given array in base 10.
     */
    public static long toBase10Int(int[] a) {
        long s = 0;
        long p = 1;
        for (int i = 0; i < a.length; i++) {
            s += a[a.length-i-1] * p;
            p *= 10;
        }
        return s;
    }
}
