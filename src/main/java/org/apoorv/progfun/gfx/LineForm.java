package org.apoorv.progfun.gfx;

import acm.graphics.GPen;
import acm.program.GraphicsProgram;

public class LineForm extends GraphicsProgram {
    private GPen pen;

    public void run() {
        pen = new GPen();
        double width = getWidth();
        double height = getHeight();
        add(pen);
        drawFormIterative(pen, 10, 15, 15, 30, 0, width/2, height/2);
    }

    public static void drawFormIterative(GPen gpen, int order, double lengthChange, double angleChange, double length, double angle, double x, double y) {
        for (int i = 0; i < order; i++) {
            gpen.setLocation(x, y);
            double currLen = length + lengthChange * i;
            double currAngle = angle + 90 + angleChange * i;
            double longLen = currLen * Math.sqrt(3);
            gpen.drawPolarLine(currLen, currAngle);
            gpen.drawPolarLine(longLen, currAngle - 150);
            gpen.drawPolarLine(longLen, currAngle + 90);
            gpen.drawPolarLine(longLen, currAngle - 30);
            gpen.setLocation(x, y);
            gpen.drawPolarLine(currLen, currAngle + 120);
            gpen.setLocation(x, y);
            gpen.drawPolarLine(currLen, currAngle - 120);
        }
    }
}
