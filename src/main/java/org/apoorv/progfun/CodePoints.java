package org.apoorv.progfun;

import java.util.Scanner;

public class CodePoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String i = in.nextLine();
        System.out.println(getCodePoints(i));
    }

    static int getCodePoints(String chars) {
        int sum = 0;
        for (int i = 0; i < chars.length(); i++) {
            sum += chars.codePointAt(i);
        }
        return sum;
    }
}
