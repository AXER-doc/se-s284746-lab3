package com.s284746.web.faces.test;

import com.s284746.web.faces.util.Calculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculationTests {
	@Test
	public void testFunctionOnRadius1() {
		Assertions.assertTrue(Calculation.belongsToArea(-1, 0, 1));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1, 1));
	}

	@Test
	public void triangleBorderOnRadius2() {
		Assertions.assertTrue(Calculation.belongsToArea(-2, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(-1, 1, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 2, 2));
		Assertions.assertTrue(Calculation.belongsToArea(-0.6, 1.2, 2));
		Assertions.assertTrue(Calculation.belongsToArea(-1.2, 0.6, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1.1, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1.5, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0, 2.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-0.7, 1.4, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-1.4, 0.7, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-2.1, 0, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 2.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.1, 1.4, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-0.9, -0.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(-2.1, -0.1, 2));
	}

	@Test
	public void sectorBorderOnRadius2() {
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.9, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.7, 0.7, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.1, 0.8, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.5, 0.5, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.8, 0.1, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 0.5, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, 1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.71, 0.71, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1, 0, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.5, 0.9, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.9, 0.5, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1.1, 0, 2));
	}

	@Test
	public void rectangleBorderOnRadius2() {
		Assertions.assertTrue(Calculation.belongsToArea(0, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, -0.9, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0, -1.8, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, 0, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, -0.7, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, -1.3, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.9, -1.9, 2));
		Assertions.assertTrue(Calculation.belongsToArea(0.4, -1.9, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1, -0.4, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1, -1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1, -2, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.5, -2, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0, -2, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1.1, -1.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(1.1, -2.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0.5, -2.1, 2));
		Assertions.assertFalse(Calculation.belongsToArea(0, -2.1, 2));
	}

	@Test
	public void testFunctionOnRadius3() {
		Assertions.assertTrue(Calculation.belongsToArea(-3, 0, 3));
		Assertions.assertTrue(Calculation.belongsToArea(0, 3, 3));
	}

	@Test
	public void testFunctionOnNegativeRadius() {
		// create tests
	}

	@Test
	public void testFunctionOnZeroRadius() {
		// create tests
	}
}
