package org.apoorv.progfun;

import java.util.HashMap;
import java.util.Objects;

public class SpaceTimeTradeoff {
    private static HashMap<Integer, Integer> cacheMap = new HashMap<>();
    private static int[] cacheArray = new int[26];

    public static void main(String[] args) {
        long naiveStart = System.nanoTime();
        int x = fibArray(25);
        System.out.println(x);
        long naiveEnd = System.nanoTime();
        int naiveNs = (int) ((naiveEnd - naiveStart));
        System.out.println(naiveNs + " ns");
    }

    public static int fibNaive(int n) {
        // Base Case
        if (n <= 2) {
            return 1;
        }
        // Recursive Case
        return fibNaive(n - 1) + fibNaive(n - 2);
    }

    public static int fibHashMap(int n) {
        // Base Case
        if (n <= 2) {
            return 1;
        }
        // Recursive Case
        Integer a = cacheMap.get(n - 1);
        if (Objects.isNull(a)) {
            a = fibHashMap(n - 1);
            cacheMap.put(n - 1, a);
        }

        Integer b = cacheMap.get(n - 2);
        if (Objects.isNull(b)) {
            b = fibHashMap(n - 2);
            cacheMap.put(n - 2, b);
        }
        return a + b;
    }

    public static int fibArray(int n) {
        // Base Case
        if (n <= 2) {
            return 1;
        }
        // Recursive Case
        int a = cacheArray[n - 1];
        if (a == 0) {
            a = fibArray(n - 1);
            cacheArray[n - 1] = a;
        }
        int b = cacheArray[n - 2];
        if (b == 0) {
            b = fibArray(n - 2);
            cacheArray[n - 2] = b;
        }
        return a + b;
    }
}
