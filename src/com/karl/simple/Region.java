package com.karl.simple;

class Region extends Place {
	private String x;

	Region() { /* null constructor */
	}

	public void printMe() {
		System.out.println("Box it.");
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}
}