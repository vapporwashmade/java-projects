package org.apoorv.progfun;

import java.util.ArrayList;
import java.util.Arrays;

public class FibonacciFun {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(Arrays.deepToString(findSet(16)));
        long end = System.nanoTime();
        System.out.println((end-start)/1000000/1000.0 + " s");
    }

    public static int[][] findSet(int size) {
        int[] fibonacci = new int[size];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < size; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        // get subsets
        ArrayList<ArrayList<Integer>> subsets = getSubsetsRecursive(fibonacci);
        // check subsets
        for (int i = 0; i < subsets.size(); i++) {
            int[] table = new int[10];
            for (int j = 0; j < subsets.get(i).size(); j++) {
                int num = subsets.get(i).get(j);
                while (num > 9) {
                    table[num % 10]++;
                    num /= 10;
                }
                table[num % 10]++;
            }
            for (int value : table) {
                if (value != 1) {
                    subsets.remove(i);
                    i--;
                    break;
                }
            }
        }
        int[][] a = new int[subsets.size()][];
        for (int i = 0; i < subsets.size(); i++) {
            a[i] = new int[subsets.get(i).size()];
            for (int j = 0; j < subsets.get(i).size(); j++) {
                a[i][j] = subsets.get(i).get(j);
            }
        }
        return a;
    }

    private static ArrayList<ArrayList<Integer>> getSubsetsRecursive(int[] arr) {
        // Base case
        if (arr.length == 1) {
            ArrayList<ArrayList<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            base.add(new ArrayList<>());
            base.get(1).add(arr[0]);
            return base;
        }
        // Recursive case
        ArrayList<ArrayList<Integer>> subsets = getSubsetsRecursive(Arrays.copyOfRange(arr, 0, arr.length - 1));
        int removed = arr[arr.length - 1];
        int startLen = subsets.size();
        for (int i = 0; i < startLen; i++) {
            ArrayList<Integer> current = (ArrayList<Integer>) subsets.get(i).clone();
            current.add(removed);
            subsets.add(current);
        }
        return subsets;
    }

    private static ArrayList<ArrayList<Integer>> getSubsetsIterative(int[] arr) {
        int numSubsets = (int) Math.pow(2, arr.length);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        String[] strings = BinaryString.getStrings(arr.length);
        for (int i = 0; i < numSubsets; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (strings[i].charAt(j) == '1') {
                    subset.add(arr[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
