package org.apoorv.progfun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
AP CS Assignment: 09 November 2019
 */
// ADD-DOC:
// finds the subsets of an array of strings
public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new String[]{"A", "B", "C", "D"}));
    }

    public static List<String> subsets(String str) {
        // Base Case
        if (str.length() == 0) {
            List<String> e = new ArrayList<>();
            e.add("");
            return e;
        }
        // Recursive Case
        List<String> prev = subsets(str.substring(0, str.length() - 1));
        List<String> curr = new ArrayList<>(prev);
        for (String s : prev) {
            char c = str.charAt(str.length() - 1);
            curr.add(s + c);
        }
        return curr;
    }

    public static List<List<String>> subsets(String[] s) {
        // Base Case
        if (s.length == 0) {
            List<List<String>> e = new ArrayList<>();
            List<String> f = new ArrayList<>();
            f.add("");
            e.add(f);
            return e;
        }
        // Recursive Case
        List<List<String>> prev = subsets(Arrays.copyOfRange(s, 0, s.length - 1));
        String p = s[s.length - 1];
        List<List<String>> subsets = new ArrayList<>(prev);
        for (int i = 0; i < prev.size(); i++) {
            List<String> temp = new ArrayList<>(prev.get(i));
            temp.add(p);
            subsets.add(temp);
        }
        return subsets;
    }
}
