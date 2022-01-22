package org.apoorv.recur;

import static org.apoorv.recur.Power.power;

// ADD-DOC: recur
public class Cannonball {
    public static int numOfCannonballs(int layers) {
        // Base Case
        if (layers == 0) {
            return 0;
        }
        return numOfCannonballs(layers - 1) * 2 + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (numOfCannonballs(i) == (int) (power(2, i)) - 1) {
                System.out.printf("i = %d, numOfCannonballs(%d) = (2^%d)-1, true\n", i, i, i);
            } else {
                System.out.printf("i = %d, numOfCannonballs(%d) = (2^%d)-1, false\n", i, i, i);
            }
        }
    }
}
