package org.apoorv.progfun;

import java.util.Arrays;

public class MultidimensionalArrays {

    /**
     * Demonstrates creation of an array of characters from the given array of Strings. Returns the array.
     *
     * @param
     */
    public static char[][] getCharArray(String[] strings) {
        char[][] chars = new char[strings.length][];  // first, allocate the space for the entire 2-d array
        int i = 0;
        for (String s : strings) {
            chars[i] = s.toCharArray();
            i += 1;
        }
        return chars;
    }

    public static void main(String[] args) {
        char[][] charArray = getCharArray(args);
        System.out.println(Arrays.deepToString(charArray));
        printCharArrayLengths(charArray);
    }

    private static void printCharArrayLengths(char[][] charArrays) {
        for (char[] ca :
                charArrays) {
            System.out.println(ca.length);
        }
    }
}
