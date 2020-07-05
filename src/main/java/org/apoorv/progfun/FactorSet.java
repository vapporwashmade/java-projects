package org.apoorv.progfun;

import java.util.ArrayList;

/**
 * This is the solution to a problem Baba assigned me:
 * Find all the distinct sets with a given size such that the product of their elements is equal to a given number.
 */
public class FactorSet {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> factorSets = findFactorSets(8, 1_000_000_000);
        System.out.println(factorSets);
        System.out.println("Number of sets: " + factorSets.size());
    }

    public static ArrayList<ArrayList<Integer>> findFactorSets(int setSize, int num) {
        // Base case
        if (setSize == 0) {
            return new ArrayList<>();
        }
        // Sub-base case
        if (setSize == 1) {
            ArrayList<ArrayList<Integer>> set = findFactorSets(0, num);
            ArrayList<Integer> toAdd = new ArrayList<>();
            toAdd.add(num);
            set.add(toAdd);
            return set;
        }
        // Recursive case
        ArrayList<ArrayList<Integer>> finalSets = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            // find factors and make a recursive call
            if (num % i == 0) {
                ArrayList<ArrayList<Integer>> sets = findFactorSets(setSize - 1, num / i);
                for (ArrayList<Integer> a : sets) {
                    // if i > the last number of the set, do not add the set
                    if (i <= a.get(a.size() - 1)) {
                        a.add(i);
                        finalSets.add(a);
                    }
                }
            }
        }
        return finalSets;
    }
}
