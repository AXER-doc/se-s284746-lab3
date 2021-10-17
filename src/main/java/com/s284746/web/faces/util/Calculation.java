package com.s284746.web.faces.util;

/**
 * Class with utilities for functional and graphic calculations
 */
public class Calculation {
	/**
	 * Checks if the point (x,y) belongs to the rectangle with parameter R
	 * @param x coordinate X
	 * @param y coordinate Y
	 * @param r parameter R
	 * @return result (belongs or not)
	 */
	private static boolean belongsToRectangle(double x, double y, double r) {
		return x >= 0 && x < r / 2 && y > -r && y <= 0;
	}

	/**
	 * Checks if the point (x,y) belongs to the sector with parameter R
	 * @param x coordinate X
	 * @param y coordinate Y
	 * @param r parameter R
	 * @return result (belongs or not)
	 */
	private static boolean belongsToSector(double x, double y, double r) {
		return x >= 0 && y >= 0 && x * x + y * y < r * r / 4;
	}

	/**
	 * Checks if the point (x,y) belongs to the triangle with parameter R
	 * @param x coordinate X
	 * @param y coordinate Y
	 * @param r parameter R
	 * @return result (belongs or not)
	 */
	private static boolean belongsToTriangle(double x, double y, double r) {
		return x <= 0 && y >= 0 && y - x <= r;
	}

	/**
	 * Checks if the point (x,y) belongs to the area (sector, triangle or rectangle) with parameter R
	 * @param x coordinate X
	 * @param y coordinate Y
	 * @param r parameter R
	 * @return result (belongs or not)
	 */
	public static boolean belongsToArea(double x, double y, double r) {
		if (r > 0)
			return belongsToRectangle(x, y, r) || belongsToSector(x, y, r) || belongsToTriangle(x, y, r);
		else
			return false;
	}

	/**
	 * Transforms pixel coordinate X into mathematical coordinate X
	 * @param x pixel coordinate X
	 * @param cx pixel coordinate X for mathematical X = 0
	 * @param scale number of pixels in mathematical distance = 1
	 * @return mathematical coordinate X
	 */
	public static double getCoordinateX(int x, int cx, double scale) {
		return (x - cx) / scale;
	}

	/**
	 * Transforms pixel coordinate X into mathematical coordinate X
	 * @param y pixel coordinate Y
	 * @param cy pixel coordinate Y for mathematical Y = 0
	 * @param scale number of pixels in mathematical distance = 1
	 * @return mathematical coordinate Y
	 */
	public static double getCoordinateY(int y, int cy, double scale) {
		return (cy - y) / scale;
	}

	/**
	 * Transforms mathematical coordinate X into pixel coordinate X
	 * @param x mathematical coordinate X
	 * @param cx pixel coordinate X for mathematical X = 0
	 * @param scale number of pixels in mathematical distance = 1
	 * @return pixel coordinate X
	 */
	public static int getGraphicX(double x, int cx, double scale) {
		return (int) Math.round(x * scale + cx);
	}

	/**
	 * Transforms mathematical coordinate X into pixel coordinate X
	 * @param y mathematical coordinate Y
	 * @param cy pixel coordinate Y for mathematical Y = 0
	 * @param scale number of pixels in mathematical distance = 1
	 * @return pixel coordinate Y
	 */
	public static int getGraphicY(double y, int cy, double scale) {
		return (int) Math.round(cy - y * scale);
	}
}
