package org.apoorv.laaksonencp;

/**
 * This class finds all the ways <u>two</u> queens can be placed on an nxn grid such they do not attack each other.
 * The basic brute-force method has a complexity of O(n^4). You place queen 1 in each of n^2 squares.
 * Then place queen 2 in each square after that of queen 1 (to remove the possibility of counting one configuration twice, since the queens are interchangeable)
 * and count each configuration where the queens do not attack each other.
 */
public class TwoQueens {
    public static void main(String[] args) {
        System.out.println(getNumWays(4));
    }

    /**
     * This solution to the Two Queens problem has a computational complexity of O(n^2).
     * This solution reduces the problem from O(n^4) to O(n^2) by calculating the number of possible squares for queen 2
     * based on the position (i,j) of queen 1 (in O(1) time). However, you still have to place queen 1 in nxn squares,
     * so it is doing n^2 O(1) operations, and the complexity is O(n^2).
     * @param n The number of squares in a side of the nxn grid
     * @return The number of ways two queens can be placed
     */
    public static int getNumWays(int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num += ((n - 1) * (n - i - 1) - Math.min(j, n - 1 - i) - Math.min(n - 1 - j, n - 1 - i));
            }
        }
        return num;
    }
}
