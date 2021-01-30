package org.apoorv.progfun.gfx;

import acm.graphics.GPen;
import acm.program.GraphicsProgram;

/**
 * Simply displays an inverted triangle; demonstrates the use of the <code>>GPen</code> class.
 * See <a href="https://cs.stanford.edu/people/eroberts/jtf/tutorial/UsingTheGraphicsPackage.html">Using Graphics Package</a>
 * for details.
 */
public class Triangle extends GraphicsProgram {

    /* Private instance variables */
    private GPen pen;

    public void run() {
        double width = getWidth();
        double height = getHeight();
        pen = new GPen();
        add(pen, width / 2, height / 2);
        draw0(pen, 200);
    }

    private void draw0(GPen pen, int pixels) {
        pen.setLocation(0, 0);
        int s = pixels / 2; //assume pixels >=2
        pen.drawLine(pixels, 0);
        pen.drawLine(-s, s);
        pen.drawLine(-s, -s);
    }
}