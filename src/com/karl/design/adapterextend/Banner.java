package com.karl.design.adapterextend;

public class Banner {
	private String name;

	public Banner(String name) {
		super();
		this.name = name;
	}

	public void printWithParen() {
		System.out.print("(" + name + ")");
	}

	public void printWithAster() {
		System.out.print("*" + name + "*");
	}

}
