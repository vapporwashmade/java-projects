package org.apoorv.progfun;

/**
 * Models a set of binary strings of length n.
 *
 * @author apoorv
 */
public class BinaryString {
    static String[] getStrings(int n) {
        // Base Case 1
        if (n <= 0) {
            return new String[]{};
        }
        // Base Case 2
        if (n == 1) {
            return new String[]{"0", "1"};
        }
        // Recursive Case
        String[] prev = getStrings(n - 1);
        String[] next = new String[prev.length * 2];
        int i = 0; // index of the string in the next array
        for (String s : prev) {
            next[i] = s + "0";
            next[i + 1] = s + "1";
            i += 2;
        }
        return next;
    }

    public static void main(String[] args) {
        String[] binStrings = getStrings(5);
        for (String s : binStrings) {
            System.out.println(s);
        }
        System.out.println(binStrings.length);
    }
}
