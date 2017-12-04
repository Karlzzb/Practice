package com.karl.algorithm.recuision;

public class BinarySearch {
	public static boolean binarySearch(int[] data, int target, int low,
			int hight) {
		if (low > hight) {
			return false;
		}

		int mid = (low + hight) / 2;
		if (target == data[mid]) {
			return true;
		}

		return target > data[mid] ? binarySearch(data, target, mid + 1, hight)
				: binarySearch(data, target, low, mid - 1);
	}

	public static void main(String[] args) {
		int target = 7;
		int[] data = new int[20];
		for (int i = 0; i < 20; i++) {
			data[i] = i + i % 2;
		}
		System.out.println("Search result for match " + target + " is: "
				+ binarySearch(data, target, 0, 19));
	}
}
