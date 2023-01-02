package org.apoorv.progfun.gfx;

import acm.graphics.GPen;
import acm.program.GraphicsProgram;

public class KochFractal extends GraphicsProgram {
    private GPen pen;

    public void run() {
        pen = new GPen();
        double width = getWidth();
        double height = getHeight();
        add(pen, width/2, height/2);
        drawKochFractal(pen, 10, 150, 0);
    }

    private static void drawKochFractal(GPen gPen, int order, double length, double angle) {
        drawFractal(gPen, order, length, angle);
        drawFractal(gPen, order, length, angle-120);
        drawFractal(gPen, order, length, angle+120);
    }

    private static void drawFractal(GPen gPen, int order, double length, double angle) {
        // Base case
        if (order == 0) {
            gPen.drawPolarLine(length, angle);
            return;
        }
        // Recursive case
        drawFractal(gPen, order-1, length/3, angle);
        drawFractal(gPen, order-1, length/3, angle + 60);
        drawFractal(gPen, order-1, length/3, angle - 60);
        drawFractal(gPen, order-1, length/3, angle);
    }
}
