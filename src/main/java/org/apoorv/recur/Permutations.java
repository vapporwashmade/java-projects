package org.apoorv.recur;

import java.util.ArrayList;
import java.util.List;

// ADD-DOC: recur
public class Permutations {
    public static int p(int n, int k) {
        // Base case 1
        if (k == 1) {
            return n;
        }
        // Base case 2
        if (k == 0) {
            return 1;
        }
        // Base case 3
        if (n < k) {
            return 0;
        }
        // Recursive case
        return p(n - 1, k) + p(n - 1, k - 1) * k;
    }

    public static void main(String[] args) {
        printPermutations("ABCC");
    }

    public static List<String> listPermutations(String s) {
        // Base Case
        if (s.length() == 0) {
            List<String> e = new ArrayList<>();
            e.add("");
            return e;
        }
        // Recursive Case
        List<String> prev = listPermutations(s.substring(1));
        String p = "" + s.charAt(0);
        List<String> next = new ArrayList<>();
        for (String str : prev) {
            for (int i = 0; i < str.length(); i++) {
                next.add(str.substring(0, i) + p + str.substring(i));
            }
            next.add(str + p);
        }
        return next;
    }

    public static void printPermutations(String prefix, String s) {
        // Base Case
        if (s.length() == 0) {
            System.out.println(prefix);
        }
        // Recursive Case
        for (int i = 0; i < s.length(); i++) {
            String p = "" + s.charAt(i);
            String beforep = s.substring(0, i);
            if (beforep.contains(p)) {
                continue;
            }
            String afterp = s.substring(i + 1);
            printPermutations(prefix + p, beforep + afterp);
        }
    }

    public static void printPermutations(String s) {
        printPermutations("", s);
    }
}
