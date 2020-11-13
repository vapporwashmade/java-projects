package org.apoorv.progfun;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Railroad extends Frame {
    public static void main(String[] args) {
        new Railroad();
    }

    public Railroad() {
        super();
        setSize(1000, 600);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawRect(310, 0, 50, 200);
        graphics.fillRect(310, 0, 50, 200);
        graphics.setColor(Color.blue);
        graphics.drawRect(643, 400, 50, 200);
        graphics.fillRect(643, 400, 50, 200);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(333, 0, 5, 600);
        graphics.fillRect(333, 0, 5, 600);
        graphics.drawRect(667, 0, 5, 600);
        graphics.fillRect(667, 0, 5, 600);
    }
}
