package com.karl.design.adaptercontain;

import org.testng.annotations.Test;

public class MainTest {

	@Test
	public void main() {
		Print p = new PrintBanner("Hello");
		p.printStrong();
		p.printWeak();
	}

}
