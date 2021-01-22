package org.apoorv.recur;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents the state of a game of Nim
 * In Nim, there are multiple rows, and coins in each row.
 * On each player's turn, they can take as many coins as wanted from only one row.
 * The player who takes the last coin wins the game.
 */
public class NimState {
    public static void main(String[] args) {
        NimState state = new NimState(new int[]{3, 4, 5});
        System.out.println(state.toString());
        NimMove firstMove = new NimMove(3, 1);
        System.out.println(firstMove);
        state.makeMove(firstMove);
        System.out.println(state.toString());
        while (!state.isGameOver()) {
            NimMove goodMove = findGoodMove(state);
            if (goodMove == null) {
                Iterator<NimMove> moves = state.getMoves();
                goodMove = moves.next();
            }
            System.out.println(goodMove);
            state.makeMove(goodMove);
            System.out.println(state);
        }
    }

    private int[] nimTable;

    /**
     * Initializes the game of Nim
     * @param startState int[] an array of the number of coins in each row at the start of the game
     */
    public NimState(int[] startState) {
        nimTable = new int[startState.length + 1];
        for (int i = 0; i < startState.length; i++) {
            nimTable[i + 1] = startState[i];
        }
    }

    /**
     * Checks whether the game is over or not
     * @return boolean true if the game is over, false if it is not
     */
    public boolean isGameOver() {
        for (int i = 1; i < nimTable.length; i++) {
            if (nimTable[i] > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds all the possible moves a player can take
     * @return Iterator which contains all the possible NimMove moves
     */
    public Iterator<NimMove> getMoves() {
        ArrayList<NimMove> moves = new ArrayList<>();
        for (int i = 1; i < nimTable.length; i++) {
            for (int j = 1; j < nimTable[i]; j++) {
                moves.add(new NimMove(j, i));
            }
        }
        return moves.iterator();
    }

    /**
     * Returns an easily readable representation of the state of the game
     * @return String representing the game state
     */
    @Override
    public String toString() {
        StringBuilder state = new StringBuilder();
        for (int i = 1; i < nimTable.length; i++) {
            state.append("Row ").append(i).append(": ");
            for (int j = 0; j < nimTable[i]; j++) {
                state.append(" + ");
            }
            state.append("\n");
        }
        return state.toString();
    }

    /**
     * Makes a move (changes the game state)
     * @param move NimMove to be executed
     */
    public void makeMove(NimMove move) {
        nimTable[move.getRow()] -= move.getCoins();
    }

    /**
     * Retracts a move (changes the game state)
     * @param move NimMove to be retracted
     */
    public void retractMove(NimMove move) {
        nimTable[move.getRow()] += move.getCoins();
    }

    /**
     * Checks whether the player whose turn it is to move is in a bad position
     * Specifically, it checks whether or not the game is able to be won by the player whose turn it is
     * @param state NimState the state of the game
     * @return boolean true if bad position, false if winnable
     */
    private static boolean isBadPosition(NimState state) {
        return findGoodMove(state) == null;
    }

    /**
     * Finds the first good move for the player, one which will put the opponent in a bad position
     * @param state NimState the state of the game
     * @return NimMove a good move for the player
     */
    private static NimMove findGoodMove(NimState state) {
        for (Iterator<NimMove> i = state.getMoves(); i.hasNext(); ) {
            NimMove move = (NimMove) i.next();
            state.makeMove(move);
            // checks if it is a bad position for the opponent, which means a good move for us
            boolean isGoodMove = isBadPosition(state);
            state.retractMove(move);
            if (isGoodMove) {
                return move;
            }
        }
        return null;
    }
}
