package org.apoorv.laaksonencp;

public class Queens {
    public static void main(String[] args) {
        int n = 16;
        // initialize board
        board = new int[n][n];
        cols = new int[n];
        diags = new int[(4*n)-2];
        System.out.println(queens(n));
//        System.out.println(Arrays.deepToString(board));
    }

    static int[][] board;
    static int[] cols;
    static int[] diags;
    public static int queens(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        // recursive case
        int total = 0;
        for (int i = 0; i < board.length; i++) {
            if (isSafe(n - 1, i)) {
                // safe square: place queen (set values)
                board[n - 1][i] = 1;
                cols[i] = 1;
                diags[f1(n - 1, i)] = 1;
                diags[f2(n - 1, i)] = 1;
                // recursive call
                total += queens(n - 1);
                // remove queen (reset values)
                board[n - 1][i] = 0;
                cols[i] = 0;
                diags[f1(n - 1, i)] = 0;
                diags[f2(n - 1, i)] = 0;
            }
        }
        return total;
    }

    // determines whether a queen at position row,col is safe (not attacked by any other queen)
    private static boolean isSafe(int row, int col) {
        return cols[col] == 0 && diags[f1(row, col)] == 0 && diags[f2(row, col)] == 0;
    }

    // given a row and a column, maps the position row,col to the diagonal (going from north-west to south-east) that runs through it
    // returns the id of the diagonal going from north-west to south-east that goes through the position row,col
    private static int f1(int row, int col) {
        return (board.length - (row - col)) - 1;
    }

    // given a row and a column, maps the position row,col to the diagonal (going from north-east to south-west) that runs through it
    // returns the id of the diagonal going from north-east to south-west that goes through the position row,col
    private static int f2(int row, int col) {
        return (((4 * board.length) - 2) - (row + col)) - 1;
    }
}
