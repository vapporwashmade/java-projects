package org.apoorv.progfun;

/*
AP CS Assignment: 09 November 2019
 */
public class Joiner {
    public static void main(String[] args) {
        String[] names = {"apoorv", "deepa", "kedar", "rujuta"};
        String delimiter = ",";
        System.out.println(MyString.join(names, delimiter));
    }
}
