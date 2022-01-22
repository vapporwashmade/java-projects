package org.apoorv.progfun;

import java.util.Scanner;

/**
 * Determines the sum of code points of the characters in a string.
 */
public class CodePoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String i = in.nextLine();
        System.out.println(getCodePoints(i));
    }

    /**
     * Finds the sum of the code points of the characters in the inputted string.
     * @param chars the inputted string (finds the sum of code points of its characters)
     * @return the sum of the code points
     */
    static int getCodePoints(String chars) {
        int sum = 0;
        for (int i = 0; i < chars.length(); i++) {
            sum += chars.codePointAt(i);
        }
        return sum;
    }
}
