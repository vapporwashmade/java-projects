package org.apoorv.progfun;

import java.util.ArrayList;

public class BlueShoe {
    public static void main(String[] args) {
        System.out.println(findIt(5).toString());
    }

    public static ArrayList<Integer> findIt(int numOfPlayers) {
        ArrayList<Integer> players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            players.add(i+1);
        }
        int startFrom = 0;
        for (; numOfPlayers > 2; numOfPlayers--) {
            players.remove((startFrom + (8%numOfPlayers) - 1)%numOfPlayers);
            startFrom += 8%numOfPlayers;
        }
        return players;
    }
}
