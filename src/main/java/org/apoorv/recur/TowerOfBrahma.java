package org.apoorv.recur;

public class TowerOfBrahma {
    public static void main(String[] args) {
        int n = 8;
//        tOfB(n, 'A', 'B', 'C');
        System.out.println(nBrahmaMoves(n));
    }

    public static void tOfB(int n, char from, char to, char aux) {
        // base case
        if (n == 0) {
            return;
        }
        // recursive case
        tOfB(n-1, from, aux, to);
        System.out.println("Disk " + n + " to tower " + to);
        tOfB(n-1, aux, to, from);
    }

    public static long nBrahmaMoves(int n) {
        if (n == 0) {
            return 0;
        }
        return nBrahmaMoves(n - 1) * 2 + 1;
    }
}
