package org.apoorv.progfun;

public class RootsOfAPoly {
    public static double getRoot(double[] poly, double x) {
        // Base case
        double val = Poly.polyIter(x, poly);
        if (val == 0) {
            return x;
        }
        // Recursive case
        double derivative = Poly.polyIter(x, getDeriv(poly));
        if (derivative == 0) {
            return getRoot(poly, x + 0.1);
        }
        double newx = ((0 - val)/derivative) + x;
//        if (newx == prevx) {
//            throw new InternalError("Cannot find roots from given x");
//        }
        return getRoot(poly, newx);
    }

    private static double[] getDeriv(double[] poly) {
        double[] deriv = new double[poly.length - 1];
        for (int i = 1; i < poly.length; i++) {
            deriv[i - 1] = i * poly[i];
        }
        return deriv;
    }

//    public static void main(String[] args) {
//        System.out.println(getRoot(new double[]{1, 0, 1}, -7, -7));
//    }
}
