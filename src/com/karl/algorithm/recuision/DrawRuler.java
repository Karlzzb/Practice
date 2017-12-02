package com.karl.algorithm.recuision;

public class DrawRuler {
	public static void drawRuler(int nlnches, int majorLength) {
		drawLine(majorLength, 0);
		for (int j = 1; j <= nlnches; j++) {
			drawInterval(majorLength - 1);
			drawLine(majorLength, j);
		}
	}

	private static void drawInterval(int centralLength) {
		if (centralLength >= 1) {
			drawInterval(centralLength - 1);
			drawLine(centralLength);
			drawInterval(centralLength - 1);
		}

	}

	private static void drawLine(int tickLength, int tickLable) {
		for (int i = 0; i < tickLength; i++)
			System.out.print("-");
		if (tickLable >= 0) {
			System.out.print(" " + tickLable);
		}
		System.out.println();
	}

	private static void drawLine(int tickLength) {
		drawLine(tickLength, -1);
	}

	public static void main(String[] args) {
		drawRuler(10, 4);
	}
}
