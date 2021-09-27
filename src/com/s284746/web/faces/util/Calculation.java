package com.s284746.web.faces.util;

public class Calculation {
    private static boolean belongsToRectangle(double x, double y, double r) {
        return x >= 0 && x < r/2 && y > -r && y <= 0;
    }
    private static boolean belongsToSector(double x, double y, double r) {
        return x >= 0 && y >= 0 && x*x + y*y < r*r/4;
    }
    private static boolean belongsToTriangle(double x, double y, double r) {
        return x <= 0 && y >= 0 && y - x <= r;
    }
    public static boolean belongsToArea(double x, double y, double r) {
        if (r > 0) return belongsToRectangle(x, y, r) || belongsToSector(x, y, r) || belongsToTriangle(x, y, r);
        else return false;
    }
    public static double getCoordinateX(int x, int cx, double scale) {
        return (x-cx)/scale;
    }
    public static double getCoordinateY(int y, int cy, double scale) {
        return (cy-y)/scale;
    }
    public static int getGraphicX(double x, int cx, double scale) {
        return (int) Math.round(x * scale + cx);
    }
    public static int getGraphicY(double y, int cy, double scale) {
        return (int) Math.round(cy - y * scale);
    }
}
