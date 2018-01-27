package com.karl.design.factory;

import org.testng.annotations.Test;

import com.karl.design.factory.framework.Factory;
import com.karl.design.factory.framework.Product;

public class MainTest {

	@Test
	public void main() {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("Karl");
		Product card2 = factory.create("Helen");
		Product card3 = factory.create("Vicent");
		card1.use();
		card2.use();
		card3.use();
	}

}
