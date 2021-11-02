package org.apoorv.progfun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parenthesize {
    public static List<String> parenthesize(List<String> operands) {
        // BASE CASE
        if (operands.size() <= 1) {
            return operands;
        }
        // RECURSIVE CASE
        List<String> arrangements = new ArrayList<>();
        for (int i = 1; i < operands.size(); i++) {
            List<String> part1 = parenthesize(operands.subList(0, i));
            List<String> part2 = parenthesize(operands.subList(i, operands.size()));
            for (String s : part1) {
                for (String value : part2) {
                    arrangements.add("(" + s + " * " + value + ")");
                }
            }
        }
        return arrangements;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e", "f", "g"};
        List<String> a = Arrays.asList(arr);
        List<String> parenthesized = parenthesize(a);
        System.out.println(parenthesized.size() + ": " + parenthesized);
    }
}
