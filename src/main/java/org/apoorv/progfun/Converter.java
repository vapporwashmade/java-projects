package org.apoorv.progfun;

import java.util.Random;

/**
 * This class converts a given decimal int value into a binary representation.
 */
public class Converter {
    public static void main(String[] args) {
        int num = processArgs(args);
        System.out.println("Converting " + num + ".");
        System.out.println("Binary: " + encodeBinary(num));
        System.out.println("Hex: " + encodeHex(num));
        System.out.println("32-bit: " + encode32Bit(num));
    }

    private static int processArgs(String[] args) {
        if (args.length < 1) {
            return new Random().nextInt();
        }
        return Integer.parseInt(args[0]);
    }

    private static String encodeBinary(int n) {
        char[] c = new char[32];
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 0) {
                c[31-i] = '0';
            }
            else {
                c[31-i] = '1';
            }
//            c[31 - i] = (char) (n % 2);
            n >>= 1;
        }
        return new String(c);
    }

    private static String encodeHex(int n) {
        char[] c = new char[32];
        for (int i = 0; i < 32; i++) {
            c[31-i] = vals[n & 15];
            n >>= 4;
        }
        return new String(c);
    }
    private static char[] vals = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v'};

    private static String encode32Bit(int n) {
        char[] c = new char[32];
        for (int i = 0; i < 32; i++) {
            c[31-i] = vals[n & 31];
            n >>= 5;
        }
        return new String(c);
    }
}
