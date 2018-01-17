package com.karl.simple;

import java.util.Observable;

public class Task extends Observable {
	private Boolean isComplete = false;

	public void complete() {
		isComplete = true;
		setChanged();
		notifyObservers();

	}

	public boolean getStatus() {
		return isComplete;
	}

}
