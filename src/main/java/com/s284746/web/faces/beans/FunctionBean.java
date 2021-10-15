package com.s284746.web.faces.beans;

import com.s284746.web.faces.event.DataDeleter;
import com.s284746.web.faces.util.Calculation;
import com.s284746.web.faces.util.SQLProcessor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.*;
import java.sql.SQLException;

/**
 * Class for evaluation result of the function
 */
@SuppressWarnings("deprecation") // deprecated classes are required for this task
@ManagedBean(name = "function")
@SessionScoped
public class FunctionBean implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private double x;
	private double y;
	private double r;

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
	 * The method which implements the target function and saves result of its evaluation
	 * @return result of the function (true or false)
	 * @throws SQLException if result saving fails
	 */
	public boolean getResult() throws SQLException {
		boolean result = Calculation.belongsToArea(x, y, r);
		SQLProcessor.saveResult(DataDeleter.userid, x, y, r, result);
		return result;
	}

	/**
	 * Setter for parameter X
	 * Assigns accepted value of <code>val</code> to <code>x</code> field
	 * @param val new X value
	 */
	public void setX(double val) {
		x = val;
	}

	/**
	 * Setter for parameter Y
	 * Assigns accepted value of <code>val</code> to <code>y</code> field
	 * @param val new Y value
	 */
	public void setY(double val) {
		y = val;
	}

	/**
	 * Setter for parameter R
	 * Assigns accepted value of <code>val</code> to <code>r</code> field
	 * @param val new R value
	 */
	public void setR(double val) {
		r = val;
	}
}