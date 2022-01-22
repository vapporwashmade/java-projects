package org.apoorv.progfun;

// ADD-DOC: word worth
// finds the worth of a word which is equal to the sum of the values of its letters (a = 1, b = 2, etc.)
public class WordWorth {
    public static void main(String[] args) {
        System.out.println(findWorth("one"));
    }

    public static int findWorth(String name) {
        name = name.toLowerCase();
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                sum += (name.charAt(i) - 'a' + 1);
            }
        }
        return sum;
    }
}
