package com.karl.simple;

import java.util.Arrays;

public class Pseudorandom {

	private final int a = 12;

	private final int b = 5;

	private final int n = 100;

	private static volatile Pseudorandom instance;

	private int curr = 92;

	private Pseudorandom() {
	}

	public static Pseudorandom getInstance() {
		if (instance == null) {
			synchronized (Pseudorandom.class) {
				instance = new Pseudorandom();
			}
		}
		return instance;
	}

	public int getNext() {
		curr = (a * curr + b) % n;
		return curr;
	}

	public int getNext(Long seed) {
		curr = (a * curr + b) % n;
		return curr;
	}

	public static void main(String[] args) {
		int data[] = new int[10];
		Pseudorandom pseudorandom = Pseudorandom.getInstance();
		for (int i = 0; i < data.length; i++) {
			data[i] = pseudorandom.getNext();
		}
		int[] orig = Arrays.copyOf(data, data.length);
		Arrays.sort(data);

		for (int i = 0; i < orig.length; i++) {
			System.out.println("My data[" + i + "]:" + orig[i]);
		}

	}
}
