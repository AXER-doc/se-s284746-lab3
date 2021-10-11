package com.s284746.web.faces.test;

import com.s284746.web.faces.util.Calculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculationTests {
	@Test
	public void triangleBorderOnRadius1() {
		// exactly on hypotenuse
		Assertions.assertTrue(Calculation.belongsToArea(-1, 0, 1));
		Assertions.assertTrue(Calculation.belongsToArea(-0.5, 0.5, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1, 1));
		// inside the triangle near hypotenuse
		Assertions.assertTrue(Calculation.belongsToArea(-0.3, 0.6, 1));
		Assertions.assertTrue(Calculation.belongsToArea(-0.6, 0.3, 1));
		// exactly on down side
		Assertions.assertTrue(Calculation.belongsToArea(-0.3, 0, 1));
		Assertions.assertTrue(Calculation.belongsToArea(-0.6, 0, 1));
		// exactly on right side
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.5, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.7, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.9, 1));
		// outside the triangle near hypotenuse
		Assertions.assertFalse(Calculation.belongsToArea(0, 1.1, 1));
		Assertions.assertFalse(Calculation.belongsToArea(-0.7, 0.4, 1));
		Assertions.assertFalse(Calculation.belongsToArea(-0.4, 0.7, 1));
		Assertions.assertFalse(Calculation.belongsToArea(-1.1, 0, 1));
		// on the right from right side
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 1.1, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 0.8, 1));
		// below down side
		Assertions.assertFalse(Calculation.belongsToArea(-0.5, -0.1, 1));
		Assertions.assertFalse(Calculation.belongsToArea(-1.1, -0.1, 1));
	}
	
	@Test
	public void sectorBorderOnRadius1() {
		// inside the sector near the curve
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.49, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0.35, 0.35, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0.49, 0, 1));
		// inside the sector
		Assertions.assertTrue(Calculation.belongsToArea(0.1, 0.3, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0.3, 0.3, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0.3, 0.1, 1));
		// exactly on left side
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.2, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.4, 1));
		// exactly on the curve
		Assertions.assertFalse(Calculation.belongsToArea(0.3, 0.4, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.4, 0.3, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.5, 0, 1));
		// outside the sector near the curve
		Assertions.assertFalse(Calculation.belongsToArea(0.3, 0.45, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.36, 0.36, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.45, 0.3, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.55, 0, 1));
	}

	@Test
	public void rectangleBorderOnRadius1() {
		// exactly on left side
		Assertions.assertTrue(Calculation.belongsToArea(0, 0, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0, -0.4, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0, -0.9, 1));
		// exactly on up side
		Assertions.assertTrue(Calculation.belongsToArea(0.2, 0, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0.4, 0, 1));
		// inside the rectangle near right side
		Assertions.assertTrue(Calculation.belongsToArea(0.4, -0.3, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0.4, -0.6, 1));
		// inside the rectangle near down side
		Assertions.assertTrue(Calculation.belongsToArea(0.4, -0.9, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0.2, -0.9, 1));
		// exactly on right side
		Assertions.assertFalse(Calculation.belongsToArea(0.5, -0.3, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.5, -0.6, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.5, -1, 1));
		// exactly on down side
		Assertions.assertFalse(Calculation.belongsToArea(0.3, -1, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0, -1, 1));
		// on the right from right side
		Assertions.assertFalse(Calculation.belongsToArea(0.6, -0.6, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0.6, -1.1, 1));
		// on the left from left side
		Assertions.assertFalse(Calculation.belongsToArea(-0.1, -0.6, 1));
		Assertions.assertFalse(Calculation.belongsToArea(-0.1, -1.1, 1));
		// below down side
		Assertions.assertFalse(Calculation.belongsToArea(0.3, -1.1, 1));
		Assertions.assertFalse(Calculation.belongsToArea(0, -1.1, 1));
	}
	
	@Test
	public void triangleBorderOnRadius2() {
		// exactly on hypotenuse
		Assertions.assertTrue(Calculation.belongsToArea(-2, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(-1, 1, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 2, 2));
		// inside the triangle near hypotenuse
		Assertions.assertTrue(Calculation.belongsToArea(-0.6, 1.2, 2));
		Assertions.assertTrue(Calculation.belongsToArea(-1.2, 0.6, 2));
		// exactly on down side
		Assertions.assertTrue(Calculation.belongsToArea(-0.6, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(-1.2, 0, 2));
		// exactly on right side
		Assertions.assertTrue(Calculation.belongsToArea(0, 1, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1.4, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1.8, 2));
		// outside the triangle near hypotenuse
		Assertions.assertFalse(Calculation.belongsToArea(0, 2.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-0.7, 1.4, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-1.4, 0.7, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-2.1, 0, 2));
		// on the right from right side
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 2.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 1.4, 2));
		// below down side
		Assertions.assertFalse(Calculation.belongsToArea(-0.9, -0.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-2.1, -0.1, 2));
	}

	@Test
	public void sectorBorderOnRadius2() {
		// inside the sector near the curve
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.9, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.7, 0.7, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, 0, 2));
		// inside the sector
		Assertions.assertTrue(Calculation.belongsToArea(0.1, 0.8, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.5, 0.5, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.8, 0.1, 2));
		// exactly on left side
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.3, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.7, 2));
		// outside the sector near or exactly on the curve
		Assertions.assertFalse(Calculation.belongsToArea(0.71, 0.71, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1, 0, 2));
		// outside the sector
		Assertions.assertFalse(Calculation.belongsToArea(0.5, 0.9, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.9, 0.5, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1.1, 0, 2));
	}

	@Test
	public void rectangleBorderOnRadius2() {
		// exactly on left side
		Assertions.assertTrue(Calculation.belongsToArea(0, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, -0.9, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, -1.8, 2));
		// exactly on up side
		Assertions.assertTrue(Calculation.belongsToArea(0.4, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, 0, 2));
		// inside the rectangle near right side
		Assertions.assertTrue(Calculation.belongsToArea(0.9, -0.7, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, -1.3, 2));
		// inside the rectangle near down side
		Assertions.assertTrue(Calculation.belongsToArea(0.9, -1.9, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.4, -1.9, 2));
		// exactly on right side
		Assertions.assertFalse(Calculation.belongsToArea(1, -0.4, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1, -1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1, -2, 2));
		// exactly on down side
		Assertions.assertFalse(Calculation.belongsToArea(0.5, -2, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0, -2, 2));
		// on the right from right side
		Assertions.assertFalse(Calculation.belongsToArea(1.1, -1.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1.1, -2.1, 2));
		// on the left from right side
		Assertions.assertFalse(Calculation.belongsToArea(-0.1, -1.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-0.1, -2.1, 2));
		// below down side
		Assertions.assertFalse(Calculation.belongsToArea(0.5, -2.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0, -2.1, 2));
	}

	@Test
	public void triangleBorderOnRadius3() {
		// exactly on hypotenuse
		Assertions.assertTrue(Calculation.belongsToArea(-3, 0, 3));
		Assertions.assertTrue(Calculation.belongsToArea(-2, 1, 3));
		Assertions.assertTrue(Calculation.belongsToArea(-1, 2, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0, 3, 3));
		// inside the triangle near hypotenuse
		Assertions.assertTrue(Calculation.belongsToArea(-0.7, 2.1, 3));
		Assertions.assertTrue(Calculation.belongsToArea(-1.4, 1.4, 3));
		Assertions.assertTrue(Calculation.belongsToArea(-2.1, 0.7, 3));
		// exactly on down side
		Assertions.assertTrue(Calculation.belongsToArea(-1, 0, 3));
		Assertions.assertTrue(Calculation.belongsToArea(-2, 0, 3));
		// exactly on right side
		Assertions.assertTrue(Calculation.belongsToArea(0, 1.5, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0, 2, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0, 2.5, 3));
		// outside the triangle near hypotenuse
		Assertions.assertFalse(Calculation.belongsToArea(0, 3.1, 3));
		Assertions.assertFalse(Calculation.belongsToArea(-1.1, 2, 3));
		Assertions.assertFalse(Calculation.belongsToArea(-1.6, 1.6, 3));
		Assertions.assertFalse(Calculation.belongsToArea(-2, 1.1, 3));
		Assertions.assertFalse(Calculation.belongsToArea(-3.1, 0, 3));
		// on the right from right side
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 2.2, 3));
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 3.1, 3));
		// below down side
		Assertions.assertFalse(Calculation.belongsToArea(-1.6, -0.1, 3));
		Assertions.assertFalse(Calculation.belongsToArea(-3.1, -0.1, 3));
	}

	@Test
	public void sectorBorderOnRadius3() {
		// inside the sector near the curve
		Assertions.assertTrue(Calculation.belongsToArea(0, 1.49, 3));
		Assertions.assertTrue(Calculation.belongsToArea(1.06, 1.06, 3));
		Assertions.assertTrue(Calculation.belongsToArea(1.49, 0, 3));
		// inside the sector
		Assertions.assertTrue(Calculation.belongsToArea(0.1, 1.2, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0.8, 0.8, 3));
		Assertions.assertTrue(Calculation.belongsToArea(1.2, 0.1, 3));
		// exactly on left side
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.6, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1.2, 3));
		// outside the sector near or exactly on the curve
		Assertions.assertFalse(Calculation.belongsToArea(1.07, 1.07, 3));
		Assertions.assertFalse(Calculation.belongsToArea(1.5, 0, 3));
		// outside the sector
		Assertions.assertFalse(Calculation.belongsToArea(0.8, 1.3, 3));
		Assertions.assertFalse(Calculation.belongsToArea(1.3, 0.8, 3));
		Assertions.assertFalse(Calculation.belongsToArea(1.6, 0, 3));
	}

	@Test
	public void rectangleBorderOnRadius3() {
		// exactly on left side
		Assertions.assertTrue(Calculation.belongsToArea(0, 0, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0, -1.4, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0, -2.8, 3));
		// exactly on up side
		Assertions.assertTrue(Calculation.belongsToArea(0.7, 0, 3));
		Assertions.assertTrue(Calculation.belongsToArea(1.4, 0, 3));
		// inside the rectangle near right side
		Assertions.assertTrue(Calculation.belongsToArea(1.4, -1, 3));
		Assertions.assertTrue(Calculation.belongsToArea(1.4, -2, 3));
		// inside the rectangle near down side
		Assertions.assertTrue(Calculation.belongsToArea(1.4, -2.9, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0.7, -2.9, 3));
		// exactly on right side
		Assertions.assertFalse(Calculation.belongsToArea(1.5, -1, 3));
		Assertions.assertFalse(Calculation.belongsToArea(1.5, -2, 3));
		Assertions.assertFalse(Calculation.belongsToArea(1.5, -3, 3));
		// exactly on down side
		Assertions.assertFalse(Calculation.belongsToArea(0.8, -3, 3));
		Assertions.assertFalse(Calculation.belongsToArea(0, -3, 3));
		// on the right from right side
		Assertions.assertFalse(Calculation.belongsToArea(1.6, -1.6, 3));
		Assertions.assertFalse(Calculation.belongsToArea(1.6, -3.1, 3));
		// on the left from right side
		Assertions.assertFalse(Calculation.belongsToArea(-0.1, -1.6, 3));
		Assertions.assertFalse(Calculation.belongsToArea(-0.1, -3.1, 3));
		// below down side
		Assertions.assertFalse(Calculation.belongsToArea(0.8, -3.1, 3));
		Assertions.assertFalse(Calculation.belongsToArea(0, -3.1, 3));
	}
	
	@Test
	public void testFunctionOnNegativeRadius() {
		Assertions.assertFalse(Calculation.belongsToArea(0, 0, -1));
		Assertions.assertFalse(Calculation.belongsToArea(1, 0, -1));
		Assertions.assertFalse(Calculation.belongsToArea(0, 1, -1));
		Assertions.assertFalse(Calculation.belongsToArea(1, 1, -1));
		Assertions.assertFalse(Calculation.belongsToArea(-1, 0, -1));
		Assertions.assertFalse(Calculation.belongsToArea(0, -1, -1));
		Assertions.assertFalse(Calculation.belongsToArea(-1, -1, -1));
	}

	@Test
	public void testFunctionOnZeroRadius() {
		Assertions.assertFalse(Calculation.belongsToArea(0, 0, 0));
		Assertions.assertFalse(Calculation.belongsToArea(1, 0, 0));
		Assertions.assertFalse(Calculation.belongsToArea(0, 1, 0));
		Assertions.assertFalse(Calculation.belongsToArea(1, 1, 0));
		Assertions.assertFalse(Calculation.belongsToArea(-1, 0, 0));
		Assertions.assertFalse(Calculation.belongsToArea(0, -1, 0));
		Assertions.assertFalse(Calculation.belongsToArea(-1, -1, 0));
	}
}
