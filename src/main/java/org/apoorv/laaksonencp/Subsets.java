package org.apoorv.laaksonencp;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        a = new ArrayList<>();
        int n = 5;
        elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i + 1;
        }
        subsets(n, 0);
    }
    static ArrayList<Integer> a;
    static int[] elements;
    public static void subsets(int n, int k) {
        if (k + 1 == n) {
            System.out.println(a);
        }
        else {
            a.add(elements[k]);
            subsets(n, k+1);
            a.remove(a.size() - 1);
            subsets(n, k+1);
        }
    }
}