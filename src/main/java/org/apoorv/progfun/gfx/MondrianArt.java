package org.apoorv.progfun.gfx;

import acm.graphics.GPen;
import acm.program.GraphicsProgram;

import java.util.Random;

public class MondrianArt extends GraphicsProgram {
    private GPen pen;

    public void run() {
        pen = new GPen();
        double width = getWidth();
        double height = getHeight();
        add(pen, 50, 50);
        pen.drawPolarLine(width - 100, 0);
        pen.drawPolarLine(height - 100, 270);
        pen.drawPolarLine(width - 100, 180);
        pen.drawPolarLine(height - 100, 90);
        split(pen, 10, (int)width - 100, (int)height - 100, 50, 50, 50);
    }

    public static void split(GPen gpen, double smallest, int width, int height, int x, int y, int minDist) {
        // Base Case
        if (width * height <= smallest || width <= 2 * minDist || height <= 2* minDist) {
            return;
        }
        // Recursive Case
        Random rand = new Random();
        if (width >= height) {
            int dist = rand.nextInt(width - (2 * minDist));
            gpen.setLocation(x + dist + minDist, y);
            gpen.drawPolarLine(height, 270);
            split(gpen, smallest, minDist + dist, height, x, y, minDist);
            split(gpen, smallest, width - (minDist + dist), height, x + minDist + dist, y, minDist);
        } else {
            int dist = rand.nextInt(height - (2 * minDist));
            gpen.setLocation(x, y + dist + minDist);
            gpen.drawPolarLine(width, 0);
            split(gpen, smallest, width, minDist + dist, x, y, minDist);
            split(gpen, smallest, width, height - (minDist + dist), x, y + minDist + dist, minDist);
        }
    }
}
