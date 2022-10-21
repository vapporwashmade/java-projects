package org.apoorv.laaksonencp;

public class KnightsTour {
    public static void main(String[] args) {
        int n = 8;
        startX = 2;
        startY = 0;
        cb = new int[n][n];
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                startX = i;
//                startY = j;
//                res += takeTour(0, i, j, n);
//                cb = new int[n][n];
//            }
//        }
//        System.out.println(res);
        System.out.println(takeTour(0, startX, startY, n));
    }

    private static int[][] cb;
    private static int startX;
    private static int startY;

    /**
     * Finds the number of ways a knight's tour can be completed starting at startX, startY
     * @param step total number of steps the knight has currently taken
     * @param col the <u>column</u> of the knight
     * @param row the <u>row</u> of the knight
     * @return int representing the number of ways a knight's tour can be completed
     */
    public static int takeTour(int step, int col, int row, int n) {
        // BASE CASE
        if (step >= (n * n) - 1) {
            System.out.println(row + ", " + col);
            if (col == startX && row == startY) {
                return 1;
            }
            return 0;
        }
        // if out of chessboard
        if (row >= n || col >= n || row < 0 || col < 0) {
            return 0;
        }
        // if square already traversed
        if (cb[row][col] == 1) {
            return 0;
        }
        // recursive case
        cb[row][col] = 1;
        int total = 0;
        // up 2, right 1
        total += takeTour(step + 1, col + 1, row - 2, n);
        // up 1, right 2
        total += takeTour(step + 1, col + 2, row - 1, n);
        // down 1, right 2
        total += takeTour(step + 1, col + 2, row + 1, n);
        // down 2, right 1
        total += takeTour(step + 1, col + 1, row + 2, n);
        // down 2, left 1
        total += takeTour(step + 1, col - 1, row + 2, n);
        // down 1, left 2
        total += takeTour(step + 1, col - 2, row + 1, n);
        // up 1, left 2
        total += takeTour(step + 1, col - 2, row - 1, n);
        // up 2, left 1
        total += takeTour(step + 1, col + 2, row + 1, n);
        cb[row][col] = 0;
        return total;
    }
}