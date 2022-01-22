package org.apoorv.progfun;

// ADD-DOC: prime time
// finds the nth prime number
public class PrimeTime {
    public static boolean isPrime(int n) {
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        // maximum is 6k+1 = sqrt n, hence maximum k = ((sqrt n) - 1)/6
        int max = (int) (Math.sqrt(n) + 1) / 6;
        for (int i = 1; i <= max; i++) {
            if (n % (6 * i - 1) == 0 || n % (6 * i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        int i = 1;
//        long start = System.nanoTime();
        // you want to find the nth prime (e.g. if n = 10, the program will find the 10th prime)
        int n = 25;
        while (count < n) {
            i++;
            if (isPrime(i)) {
                count++;
            }
        }
//        long end = System.nanoTime();
        System.out.println(count + "th prime: " + i);
//        System.out.println((end - start)/1_000_000/1000.0 + " s");
    }
}
