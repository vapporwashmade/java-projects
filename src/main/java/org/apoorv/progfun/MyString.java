package org.apoorv.progfun;

/*
AP CS Assignment: 09 November 2019
 */
public class MyString {
    /**
     * Returns a string containing all the strings in the given array in order, joined by the given delimiter.
     *
     * @param strings   String[] consisting of the strings to join.
     * @param delimiter String separating the elements in the strings array.
     * @return String containing all the strings. No delimiter is placed after the <i> last </i> string.
     */
    public static String join(String[] strings, String delimiter) {
        String res = "";
        if (strings.length > 0) {
            res = strings[0];
        }
        for (int i = 1; i < strings.length; i++) {
            res += delimiter + strings[i];
        }
        return res;
    }
}