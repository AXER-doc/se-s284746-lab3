package com.s284746.web.faces.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class for plotting area shape.
 */
public class GraphicConstructor {
	/**
	 * Different modes of specifying object location: by left side, center or right side.
	 */
	private enum XMode {
		LEFT, CENTER, RIGHT
	}

	/**
	 * Different modes of specifying object location: by top, middle or bottom.
	 */
	private enum YMode {
		TOP, MIDDLE, BOTTOM
	}

	/**
	 * Filling an image with a color.
	 * @param image image to fill
	 * @param color filling color
	 */
	private static void background(BufferedImage image, Color color) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				image.setRGB(i, j, color.getRGB());
			}
		}
	}

	/**
	 * Puts a right arrow into an image.
	 * @param image image
	 * @param lx left coordinate X
	 * @param rx right coordinate Y
	 * @param y coordinate Y
	 * @param color arrow color
	 */
	private static void rightArrow(BufferedImage image, int lx, int rx, int y, Color color) {
		for (int i = lx; i <= rx; ++i) {
			image.setRGB(i, y, color.getRGB());
		}
		for (int i = 1; i <= 3; ++i) {
			image.setRGB(rx - i, y - i, color.getRGB());
			image.setRGB(rx - i, y + i, color.getRGB());
		}
	}

	/**
	 * Puts an up arrow into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param hy upper coordinate Y
	 * @param ly lower coordinate Y
	 * @param color arrow color
	 */
	private static void upArrow(BufferedImage image, int x, int hy, int ly, Color color) {
		for (int i = hy; i <= ly; ++i) {
			image.setRGB(x, i, color.getRGB());
		}
		for (int i = 1; i <= 3; ++i) {
			image.setRGB(x - i, hy + i, color.getRGB());
			image.setRGB(x + i, hy + i, color.getRGB());
		}
	}

	/**
	 * Draws one pixel at (X,Y), one on left of it and one on right of it.
	 * Used as stroke on vertical line.
	 * @param image image
	 * @param cx central coordinate X
	 * @param y coordinate Y
	 * @param color stroke color
	 */
	private static void horizontalStroke(BufferedImage image, int cx, int y, Color color) {
		image.setRGB(cx - 1, y, color.getRGB());
		image.setRGB(cx, y, color.getRGB());
		image.setRGB(cx + 1, y, color.getRGB());
	}

	/**
	 * Draws on pixel at (X,Y), one above it and one below it.
	 * Used as stroke on horizontal line.
	 * @param image image
	 * @param x coordinate X
	 * @param cy coordinate Y
	 * @param color stroke color
	 */
	private static void verticalStroke(BufferedImage image, int x, int cy, Color color) {
		image.setRGB(x, cy - 1, color.getRGB());
		image.setRGB(x, cy, color.getRGB());
		image.setRGB(x, cy + 1, color.getRGB());
	}

	/**
	 * Puts an X stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void xStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 2;
		newY = y - yMode.ordinal() * 4;
		for (int i = 0; i < 9; ++i) {
			image.setRGB(newX + 2 - (Math.abs(i - 4) + 1) / 2, newY + i, color.getRGB());
			image.setRGB(newX + 2 + (Math.abs(i - 4) + 1) / 2, newY + i, color.getRGB());
		}
	}

	/**
	 * Puts an Y stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void yStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 2;
		newY = y - yMode.ordinal() * 4;
		for (int i = 0; i < 4; ++i) {
			image.setRGB(newX + 2 - ((5 - i) / 2), newY + i, color.getRGB());
			image.setRGB(newX + 2 + ((5 - i) / 2), newY + i, color.getRGB());
		}
		for (int i = 0; i < 5; ++i) {
			image.setRGB(newX + 2, newY + i + 4, color.getRGB());
		}
	}

	/**
	 * Puts an R stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void rStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 2;
		newY = y - yMode.ordinal() * 4;
		for (int i = 0; i < 4; ++i) {
			image.setRGB(newX + i, newY, color.getRGB());
			image.setRGB(newX + i, newY + 4, color.getRGB());
		}
		for (int i = 0; i < 3; ++i) {
			image.setRGB(newX, newY + i + 1, color.getRGB());
			image.setRGB(newX + 4, newY + i + 1, color.getRGB());
			image.setRGB(newX, newY + i + 5, color.getRGB());
			image.setRGB(newX + i + 2, newY + i + 5, color.getRGB());
		}
		image.setRGB(newX, newY + 8, color.getRGB());
		image.setRGB(newX + 4, newY + 8, color.getRGB());
	}

	/**
	 * Puts a - stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param color stamp color
	 */
	private static void minusStamp(BufferedImage image, int x, XMode xMode, int y, Color color) {
		int newX;
		newX = x - xMode.ordinal() * 2;
		for (int i = 0; i < 5; ++i) {
			image.setRGB(newX + i, y, color.getRGB());
		}
	}

	/**
	 * Puts a -R stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void minusRStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 5;
		newY = y - yMode.ordinal() * 4;
		minusStamp(image, newX, XMode.LEFT, newY + 4, color);
		rStamp(image, newX + 6, XMode.LEFT, newY, YMode.TOP, color);
	}

	/**
	 * Puts a 2 stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void twoStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 2;
		newY = y - yMode.ordinal() * 4;
		image.setRGB(newX, newY + 1, color.getRGB());
		for (int i = 0; i < 3; ++i) {
			image.setRGB(newX + i + 1, newY, color.getRGB());
			image.setRGB(newX + 4, newY + i + 1, color.getRGB());
		}
		for (int i = 0; i < 4; ++i) {
			image.setRGB(newX + i, newY + 7 - i, color.getRGB());
		}
		for (int i = 0; i < 5; ++i) {
			image.setRGB(newX + i, newY + 8, color.getRGB());
		}
	}

	/**
	 * Puts an R/2 stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void halfRStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 3;
		newY = y - yMode.ordinal() * 10;
		rStamp(image, newX + 1, XMode.LEFT, newY, YMode.TOP, color);
		for (int i = 0; i < 7; ++i) {
			image.setRGB(newX + i, newY + 10, color.getRGB());
		}
		twoStamp(image, newX + 1, XMode.LEFT, newY + 12, YMode.TOP, color);
	}

	/**
	 * Puts a -R/2 stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void minusHalfRStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 6;
		newY = y - yMode.ordinal() * 10;
		minusStamp(image, newX, XMode.LEFT, newY + 10, color);
		halfRStamp(image, newX + 6, XMode.LEFT, newY, YMode.TOP, color);
	}

	/**
	 * Puts a 0 stamp into an image.
	 * @param image image
	 * @param x coordinate X
	 * @param xMode X locating method
	 * @param y coordinate Y
	 * @param yMode Y locating method
	 * @param color stamp color
	 */
	private static void zeroStamp(BufferedImage image, int x, XMode xMode, int y, YMode yMode, Color color) {
		int newX, newY;
		newX = x - xMode.ordinal() * 2;
		newY = y - yMode.ordinal() * 4;
		for (int i = 0; i < 3; ++i) {
			image.setRGB(newX + i + 1, newY, color.getRGB());
			image.setRGB(newX + i + 1, newY + 8, color.getRGB());
		}
		for (int i = 0; i < 7; ++i) {
			image.setRGB(newX, newY + i + 1, color.getRGB());
			image.setRGB(newX + 4, newY + i + 1, color.getRGB());
		}
	}

	/**
	 * Puts strokes and stamps into an image.
	 * @param image image to fill
	 * @param min pixel coordinate of minimum
	 * @param center pixel coordinate of center
	 * @param max pixel coordinate of maximum
	 * @param color stroke color
	 */
	private static void graduate(BufferedImage image, int min, int center, int max, Color color) {
		horizontalStroke(image, center, min, color);
		rStamp(image, center + 8, XMode.LEFT, min, YMode.MIDDLE, color);
		horizontalStroke(image, center, (center + min) / 2, color);
		halfRStamp(image, center + 8, XMode.LEFT, (center + min) / 2, YMode.MIDDLE, color);
		horizontalStroke(image, center, (center + max) / 2, color);
		minusHalfRStamp(image, center + 8, XMode.LEFT, (center + max) / 2, YMode.MIDDLE, color);
		horizontalStroke(image, center, max, color);
		minusRStamp(image, center + 8, XMode.LEFT, max, YMode.MIDDLE, color);
		verticalStroke(image, min, center, color);
		minusRStamp(image, min, XMode.CENTER, center + 8, YMode.TOP, color);
		verticalStroke(image, (center + min) / 2, center, color);
		minusHalfRStamp(image, (center + min) / 2, XMode.CENTER, center + 8, YMode.TOP, color);
		verticalStroke(image, (center + max) / 2, center, color);
		halfRStamp(image, (center + max) / 2, XMode.CENTER, center + 8, YMode.TOP, color);
		verticalStroke(image, max, center, color);
		rStamp(image, max, XMode.CENTER, center + 8, YMode.TOP, color);
	}

	/**
	 * Plots an area shape.
	 * @param size pixel size (width and height) of the picture
	 * @param margin number of pixels beyond arrows ends on each side
	 * @param padding number of pixels inside arrow borders but outside the graph on each side
	 * @param color area filling color
	 * @param r parameter R
	 * @return resulting image
	 */
	private static BufferedImage plot(int size, int margin, int padding, Color color, double r) {
		BufferedImage picture = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		background(picture, Color.WHITE);
		int outerMin = margin;
		int innerMin = margin + padding;
		int center = size / 2;
		int innerMax = size - margin - padding;
		int outerMax = size - margin;
		double maxAbs = r;
		double scale = (innerMax - innerMin) / (2f * maxAbs);
		for (int i = innerMin; i < innerMax; ++i) {
			for (int j = innerMin; j < innerMax; ++j) {
				if (Calculation.belongsToArea(Calculation.getCoordinateX(i, center, scale),
						Calculation.getCoordinateY(j, center, scale), r)) {
					picture.setRGB(i, j, color.getRGB());
				}
			}
		}
		rightArrow(picture, outerMin, outerMax, center, Color.BLACK);
		upArrow(picture, center, outerMin, outerMax, Color.BLACK);
		xStamp(picture, outerMax, XMode.RIGHT, center + 8, YMode.TOP, Color.BLACK);
		yStamp(picture, center + 8, XMode.LEFT, outerMin, YMode.TOP, Color.BLACK);
		zeroStamp(picture, center + 8, XMode.LEFT, center + 8, YMode.TOP, Color.BLACK);
		graduate(picture, innerMin, center, innerMax, Color.BLACK);
		return picture;
	}

	/**
	 * Saving the image as PNG file.
	 * @param filename name of the file without <code>.png</code> extension
	 * @return success flag (saved or not)
	 * @throws IOException if creating the file fails
	 */
	public static boolean save(String filename) throws IOException {
		BufferedImage picture = plot(400, 8, 24, new Color(204, 153, 51), 10);
		return ImageIO.write(picture, "PNG", new File("webapp/" + filename));
	}
}
