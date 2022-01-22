package org.apoorv.progfun;

import java.util.Arrays;
import java.util.Comparator;

// ADD-DOC:
// using comparators and Arrays.sort to sort an array different ways
public class Sorter {
    private static Comparator<Integer> c1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };

    private static Comparator<Integer> r1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    private static Comparator<Integer> a1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            Integer i1 = Math.abs(o1);
            Integer i2 = Math.abs(o2);
            return i1.compareTo(i2);
        }
    };

    public static void sort(Integer[] a) {
        Arrays.sort(a, c1);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, r1);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, a1);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        sort(new Integer[]{3, 4, 1, -6, -2, 2, 8});
    }
}
