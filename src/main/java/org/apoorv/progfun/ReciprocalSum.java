package org.apoorv.progfun;

// ADD-DOC:
// finds the sum of the reciprocals of the numbers up to n
// in the main method, tries to determine whether the increase in the sums converges
public class ReciprocalSum {
    public static void main(String[] args) {
        double x = getSum(50);
        double y = getSum(500);
        double z = getSum(5000);
        double a = getSum(50000);
        double b = getSum(500000);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a);
        System.out.println(b);
        System.out.println(y - x);
        System.out.println(z - y);
        System.out.println(a - z);
        System.out.println(b - a);
    }

    public static double getSum(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (1.0 / i);
        }
        return sum;
    }
}
