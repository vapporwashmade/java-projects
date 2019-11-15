package org.apoorv.progfun;

/*
AP CS Assignment: 09 November 2019
 */
public class MyString {
    public static String join(String[] strA, String delimiter) {
        String res = "";
        if (strA.length > 0) {
            res = strA[0];
        }
        for (int i = 1; i < strA.length; i++) {
            res += delimiter + strA[i];
        }
        return res;
    }
}