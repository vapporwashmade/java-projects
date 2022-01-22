package org.apoorv.recur;

// ADD-DOC: recur
public class Maze {
    public static void main(String[] args) {
        for (char[] ca : maze) {
            System.out.println(ca);
        }
        // change row and col to x-coordinate and y-coordinate of starting square, respectively
        int row = 6;
        int col = 1;
        System.out.println(findPath(maze, row, col));
        maze[row][col] = 'S';
        for (char[] ca : maze) {
            System.out.println(ca);
        }
    }

    private static char[][] maze = new char[][]{
            {' ', '#', '#', '#', '#', '#', '#', '#'},
            {' ', ' ', ' ', '#', ' ', ' ', 'F', '#'},
            {'#', '#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', 'S', ' ', ' ', '#', ' ', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#'},
    };

    // directly mutates the given maze
    /**
     * Takes a maze of chars and draws a path from the start to the finish if it is possible.
     * In the maze of chars, # is a wall, S is the start square, ' ' (a space) is a free square, F is the finish square,
     * and + is the path to take
     * @param maze char[][] the maze to draw a path through
     * @param x int the x-coordinate of the starting square
     * @param y int the y-coordinate of the starting square
     * @return boolean true if the maze is solvable, false if the maze is unsolvable
     */
    public static boolean findPath(char[][] maze, int x, int y) {
        // check bounds before anything else!
        if (oob(maze, x, y)) {
            return false;
        }
        // base cases
        if (maze[x][y] == 'F') {
            return true;
        }
        if (maze[x][y] == '+') {
            return false;
        }
        if (maze[x][y] == '#') {
            return false;
        }
        // recursive case
        maze[x][y] = '+';
        // check north
        if (findPath(maze, x, y - 1)) {
            return true;
        }
        // check south
        if (findPath(maze, x, y + 1)) {
            return true;
        }
        // check east
        if (findPath(maze, x - 1, y)) {
            return true;
        }
        // check west
        if (findPath(maze, x + 1, y)) {
            return true;
        }
        // backtrack
        maze[x][y] = ' ';
        return false;
    }

    /**
     * checks whether a position in the maze is out of bounds or not
     * @param maze char[][] the maze to check
     * @param x int the x-coordinate of the position
     * @param y int the y-coordinate of the position
     * @return boolean true if out-of-bounds, false if in-bounds
     */
    private static boolean oob(char[][] maze, int x, int y) {
        return x < 0 || x >= maze.length || y < 0 || y >= maze[x].length;
    }
}
