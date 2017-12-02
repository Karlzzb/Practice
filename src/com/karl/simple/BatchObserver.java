package com.karl.simple;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

public class BatchObserver implements Observer {
	public BatchObserver(String batchNo, int i) {
		super();
		size = new AtomicInteger();
		size.set(i);
		this.batchNo = batchNo;
	}

	private AtomicInteger size;

	private String batchNo;

	@Override
	public void update(Observable o, Object arg) {
		Task task = (Task) o;
		if (task.getStatus()) {
			System.out.println("Task is completed!");
		}

		if (size.decrementAndGet() == 0) {
			System.out.println("This batch[" + batchNo + "] is finished");
		}

	}
}
