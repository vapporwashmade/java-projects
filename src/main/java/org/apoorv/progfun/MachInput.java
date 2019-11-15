package org.apoorv.progfun;

import java.util.Scanner;

public class MachInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Red value (0-255): ");
        int red = in.nextInt();
        System.out.print("Green value (0-255): ");
        int green = in.nextInt();
        System.out.print("Blue value (0-255): ");
        int blue = in.nextInt();
    }
}
