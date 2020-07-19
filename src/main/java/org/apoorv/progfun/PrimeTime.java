package org.apoorv.progfun;

public class PrimeTime {
    public static boolean isPrime(int n) {
        if (n < 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        // maximum is 6k+1 = sqrt n, hence maximum k = ((sqrt n) - 1)/6
        int max = (int) (Math.sqrt(n) + 1)/6;
        for (int i = 1; i <= max; i++) {
            if (n % (6 * i - 1) == 0 || n % (6 * i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        long start = System.nanoTime();
        while (count < 1_000_000) {
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        long end = System.nanoTime();
        System.out.println(count + "th prime: " + i);
        System.out.println((end - start)/1_000_000/1000.0 + " s");
    }
}
