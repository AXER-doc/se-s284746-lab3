package com.s284746.web.faces.struct;

import java.io.Serial;
import java.io.Serializable;

/**
 * Structured result of checking the point
 */
public class Result implements Serializable {
	@Serial
	private static final long serialVersionUID = -1640265211557550086L;
	private double x;
	private double y;
	private double r;
	private boolean included;

	/**
	 * Creates an instance of Result filled with accepted parameters
	 * @param x coordinate X
	 * @param y coordinate Y
	 * @param r parameter R
	 * @param in result (belongs or not)
	 */
	public Result(double x, double y, double r, boolean in) {
		this.x = x;
		this.y = y;
		this.r = r;
		included = in;
	}

	/**
	 * Getter for parameter X
	 * @return value of X
	 */
	public double getX() {
		return x;
	}

	/**
	 * Getter for parameter Y
	 * @return value of Y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Getter for parameter R
	 * @return value of R
	 */
	public double getR() {
		return r;
	}

	/**
	 * Getter for flag Included
	 * @return value of Included
	 */
	public boolean isIncluded() {
		return included;
	}

	/**
	 * Setter for parameter X
	 * Assigns accepted value <code>x</code> to <code>x</code> field
	 * @param x new value of X
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Setter for parameter Y
	 * Assigns accepted value <code>y</code> to <code>y</code> field
	 * @param y new value of Y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Setter for parameter R
	 * Assigns accepted value <code>r</code> to <code>r</code> field
	 * @param r new value of R
	 */
	public void setR(double r) {
		this.r = r;
	}

	/**
	 * Setter for flag Included
	 * Assigns accepted value of <code>included</code> to <code>included</code> field
	 * @param included new value of Included
	 */
	public void setIncluded(boolean included) {
		this.included = included;
	}
}
