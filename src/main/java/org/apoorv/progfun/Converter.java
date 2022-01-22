package org.apoorv.progfun;

import java.util.Random;

/**
 * This class converts a given decimal int value into a binary/hex/32-bit representation.
 */
public class Converter {
    public static void main(String[] args) {
        int num = processArgs(args);
        System.out.println("Converting " + num + ".");
        System.out.println("Binary: " + encodeBinary(num));
        System.out.println("Hex: " + encodeHex(num));
        System.out.println("32-bit: " + encode32Bit(num));
    }

    /**
     * Takes the given command line arguments and converts the first to an integer value.
     * If there are none, returns a random integer.
     * @param args command line arguments, of which the first will be converted to an integer
     * @return Integer to return
     */
    private static int processArgs(String[] args) {
        if (args.length < 1) {
            return new Random().nextInt();
        }
        return Integer.parseInt(args[0]);
    }

    /**
     * Converts an inputted integer to binary.
     * @param n Integer to be converted to binary
     * @return binary representation of the decimal integer inputted as a string
     */
    private static String encodeBinary(int n) {
        char[] c = new char[32];
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 0) {
                c[31 - i] = '0';
            } else {
                c[31 - i] = '1';
            }
//            c[31 - i] = (char) (n % 2);
            n >>= 1;
        }
        return new String(c);
    }

    /**
     * Converts an inputted integer to hex.
     * @param n Integer to be converted to hex
     * @return hex representation of the decimal integer inputted as a string
     */
    private static String encodeHex(int n) {
        char[] c = new char[32];
        for (int i = 0; i < 32; i++) {
            c[31 - i] = vals[n & 15];
            n >>= 4;
        }
        return new String(c);
    }

    private static char[] vals = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v'};

    /**
     * Converts an inputted integer to a 32-bit encoding.
     * @param n Integer to be converted to the 32-bit encoding
     * @return 32-bit representation of the decimal integer inputted as a string
     */
    private static String encode32Bit(int n) {
        char[] c = new char[32];
        for (int i = 0; i < 32; i++) {
            c[31 - i] = vals[n & 31];
            n >>= 5;
        }
        return new String(c);
    }
}
