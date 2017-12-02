package com.karl.simple;

public class Puzzle {
	public static void main(String[] args) {
		// Test data for your algorithm

		// int[] board = {3,6,4,1,3,4,2,5,3,0};
		// int marker = 0;
		// show(board);
		// System.out.println(solvable3(marker, board)); // Returns true
		// show(board);

		// int[] board = {3,1,2,3,0};
		// int marker = 0;
		// show(board);
		// System.out.println(solvable3(marker, board)); // Returns false
		// show(board);

		// int[] board = {1,2,3,2,5,4,0};
		// int marker = 2;
		// show(board);
		// System.out.println(solvable3(marker, board)); // Returns false
		// show(board);

		int[] board = { 5, 1, 2, 3, 6, 2, 3, 2, 4, 2, 0 };
		int marker;
		boolean[] results = { false, true, true, false, true, false, false,
				false, true, false };
		boolean itWorks = true;
		for (int k = 0; k < 10; k++) {
			System.out.print("marker = " + k + " -> ");
			show(board);
			boolean algorithm = solvable(k, board);
			System.out.println("Computed to " + algorithm + " and should be "
					+ results[k]);
			itWorks = itWorks && (results[k] == algorithm);
			show(board);
		}
		if (itWorks)
			System.out.println("It probably works!");
		else
			System.out.println("Sorry, something is wrong.");
	}

	/**
	 * Returns true if you can move the marker to the end of the array
	 * 
	 * @param start
	 *            starting place for the marker
	 * @param squares
	 *            the array filled numbers indicating how far you can jump to
	 *            another location
	 */
	public static boolean solvable(int start, int[] squares) {
		return true;
	}

	public static void show(int[] board) {
		System.out.print("| ");
		for (int k = 0; k < board.length; k++)
			System.out.print(board[k] + " | ");
		System.out.println();
	}
}