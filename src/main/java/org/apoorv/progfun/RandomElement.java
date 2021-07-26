package org.apoorv.progfun;

import java.util.Timer;
import java.util.TimerTask;

public class RandomElement {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask x = new TimerTask() {
            @Override
            public void run() {
                String[] choices = {"R", "U", "F", "R'", "U'", "F'"};
                System.out.println(choices[(int) (Math.floor(Math.random()) * 6)]);
            }
        };
        timer.schedule(x, 100);
    }
}
