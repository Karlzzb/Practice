package com.karl.design.adapterextend;

public class PrintBanner extends Banner implements Print {

	public PrintBanner(String name) {
		super(name);
	}

	@Override
	public void printStrong() {
		this.printWithAster();
	}

	@Override
	public void printWeak() {
		this.printWithParen();
	}

}
