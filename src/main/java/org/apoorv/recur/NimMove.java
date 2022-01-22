package org.apoorv.recur;

// ADD-DOC: recur
public class NimMove {
    int coins;
    int row;

    public NimMove(int coins, int row) {
        this.coins = coins;
        this.row = row;
    }

    public int getCoins() {
        return coins;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Taking " + coins + " coins from row " + row;
    }
}
