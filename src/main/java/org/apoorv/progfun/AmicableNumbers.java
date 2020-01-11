package org.apoorv.progfun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AmicableNumbers {
    public static void main(String[] args) {
        for (int i = 0; i < divisorSums.length; i++) {
            ArrayList<Integer> divisors = new ArrayList<>();
            divisors.add(1);
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    divisors.add(j);
                    if (j != i/j) {
                        divisors.add(i / j);
                    }
                }
            }
            int sum = 0;
            for (int k: divisors) {
                sum += k;
            }
            divisorSums[i] = sum;
        }
        System.out.println(findNumbers());
    }

    private static int[] divisorSums = new int[195000];

    public static HashMap<Integer, Integer> findNumbers() {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 2; i < divisorSums.length+1; i++) {
            try {
                if (divisorSums[divisorSums[i]] == i) {
                    numbers.put(i, divisorSums[i]);
                }
            } catch (Exception e) {

            }
         }
        return numbers;
    }
}
