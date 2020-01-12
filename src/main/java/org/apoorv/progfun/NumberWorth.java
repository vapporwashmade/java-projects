package org.apoorv.progfun;

public class NumberWorth {
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
