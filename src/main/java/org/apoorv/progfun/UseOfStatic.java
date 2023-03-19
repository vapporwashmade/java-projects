package org.apoorv.progfun;

public class UseOfStatic {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            UseOfStatic ui = new UseOfStatic();
        }
        System.out.println(instances);
    }

    private static int instances = 0;

    public UseOfStatic() {
        instances++;
    }
}
