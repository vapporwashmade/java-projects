package org.apoorv.progfun;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
AP CS Assignment: 09 November 2019
 */
public class Subsets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Which string do you want to find the subsets of? ");
        String input = in.nextLine();
        if (input == null) {
            input = "";
        }
        String[] output = subsets(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    private static String[] subsets(String str) {
        // Base Case
        if (str.length() == 0) {
            return new String[]{""};
        }
        // Recursive Case
        String[] prev = subsets(str.substring(0, str.length()-1));
        List<String> curr = new ArrayList<>(Arrays.asList(prev));
        for (int i = 0; i < prev.length; i++) {
            char c = str.charAt(str.length()-1);
            curr.add(prev[i]+ c);
        }
//        return curr.toArray(String[]::new);
        return null;
    }
}
