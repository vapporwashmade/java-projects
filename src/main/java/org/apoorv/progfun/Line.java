package org.apoorv.progfun;

public class Line {
    private Point point1;
    private Point point2;
    private double slope;

    public Line(Point a, Point b) {
        this.point1 = a;
        this.point2 = b;
        this.slope = (b.getY() - a.getY()) / (b.getX() - a.getX());
//        this(a, (a.getY()-b.getY())/(a.getX()-b.getX()));
    }

    public Line(Point a, double slope) {
        this.point1 = a;
        this.slope = slope;
        // sets point2 as the y-intercept of the line
        this.point2 = new Point(0, slope * (0 - a.getX()) + a.getY());
//        this(a, new Point(0, slope*(0-a.getX())+a.getY()));

    }

    public static void main(String[] args) {

    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public double getSlope() {
        return slope;
    }

    @Override
    public String toString() {
        return point1.toString() + ", " + point2.toString();
    }
}
