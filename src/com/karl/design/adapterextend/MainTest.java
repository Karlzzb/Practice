package com.karl.design.adapterextend;

import java.io.IOException;

import org.testng.annotations.Test;

public class MainTest {

	@Test
	public void mainPrint() {
		Print p = new PrintBanner("Hello");
		p.printStrong();
		p.printWeak();
	}

	@Test
	public void mainFileProperties() {
		FileIO f = new FileProperties();
		try {
			f.readFromFile("file.text");
			f.setValue("month", "12");
			f.setValue("day", "22");
			f.setValue("time", "11点46分");
			f.writeToFile("newfile.text");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
