package com.karl.simple;

public abstract class SupportClass {

	protected abstract boolean support(int modecode);

	public void handler(int messagecode) {
		if (support(messagecode)) {

		}

	}

	public static void main(String[] args) {

	}
}
