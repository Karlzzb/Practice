package com.karl.design.adaptercontain;

public class PrintBanner extends Print {
	private Banner banner;

	public PrintBanner(String name) {
		this.banner = new Banner(name);
	}

	@Override
	public void printStrong() {
		banner.printWithAster();
	}

	@Override
	public void printWeak() {
		banner.printWithParen();
	}

}
