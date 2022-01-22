package org.apoorv.recur;

import java.util.ArrayList;
import java.util.List;

// ADD-DOC: recur
public class Combinations {
    public static int c(int n, int k) {
        // Base case 1
        if (k == 0) {
            return 1;
        }
        // Base case 2
        if (k == 1) {
            return n;
        }
        // Base case 3
        if (n < k) {
            return 0;
        }
        // Recursive case
        return c(n - 1, k) + c(n - 1, k - 1);
    }

    public static void main(String[] args) {
        System.out.println(listCombinations("ABCDE", 3));
    }

    public static List<String> listCombinations(String s, int r) {
        // Base Case
        if (s.length() < r) {
            return new ArrayList<>();
        }
        if (r <= 0) {
            List<String> e = new ArrayList<>();
            e.add("");
            return e;
        }
        // Recursive Case
        List<String> notpicked = listCombinations(s.substring(1), r);
        List<String> picked = listCombinations(s.substring(1), r - 1);
        String p = "" + s.charAt(0);
        ArrayList<String> modified = new ArrayList<>(notpicked);
        for (String str : picked) {
            modified.add(p + str);
        }
        return modified;
    }
}
