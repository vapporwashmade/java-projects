package org.apoorv.recur;

import org.apoorv.progfun.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ADD-DOC: recur
public class TotalNumber {
    private static String[] values = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public static void main(String[] args) {
        String[] hand = new String[]{"10H", "5H", "5C", "5S", "5D"};
        System.out.println(Arrays.toString(countNumberV1(hand, 15)));
    }

    private static int countHand(String[] hand) {
        int sum = 0;
        for (String s : hand) {
            if (s.length() < 2) {
                continue;
            }
            String number = s.substring(0, s.length() - 1);
            for (int j = 0; j < values.length; j++) {
                if (values[j].equals(number)) {
                    sum += (j + 1);
                }
            }
        }
        return sum;
    }

    public static String[] countNumberV1(String[] hand, int n) {
        List<List<String>> subs = Subsets.subsets(hand);
        List<String> combos = new ArrayList<>();
        for (List<String> s : subs) {
            if (countHand(s.toArray(new String[]{})) == n) {
                StringBuilder combo = new StringBuilder();
                for (int i = 1; i < s.size(); i++) {
                    combo.append(s.get(i));
                    combo.append(" + ");
                }
                combo.delete(combo.length() - 3, combo.length());
                combos.add(combo.toString());
            }
        }
        return combos.toArray(new String[]{});
    }
}
