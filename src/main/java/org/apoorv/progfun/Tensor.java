package org.apoorv.progfun;

public class Tensor {
    public static void main(String[] args) {
        
    }

    public static int rank(String tensor) {
        for (int i = 0; i < tensor.length(); i++) {
            if (tensor.charAt(i) != '[') {
                return i;
            }
        }
        return -1;
    }

    public static int[] shape(String tensor) {
        
    }
}