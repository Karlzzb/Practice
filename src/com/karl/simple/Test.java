package com.karl.simple;

public class Test {

	public static void main(String[] args) {
		BatchObserver batch = new BatchObserver("Fist batch", 10);

		Task task;
		for (int i = 0; i < 10; i++) {
			task = new Task();
			task.addObserver(batch);

			//
			task.complete();
		}

	}

}
