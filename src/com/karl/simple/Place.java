package com.karl.simple;

public class Place extends Object {
	private String x;

	Place() { /* null constructor */
	}

	public void printMe() {
		System.out.println("Buy it.");
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}
}
