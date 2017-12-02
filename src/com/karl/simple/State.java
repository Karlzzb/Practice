package com.karl.simple;

class State extends Region {
	private String x;

	State() { /* null constructor */
	}

	public void printMe() {
		System.out.println("Ship it.");
	}

	protected void changeSuperX() {
	}
}