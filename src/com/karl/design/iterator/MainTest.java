package com.karl.design.iterator;

import org.testng.annotations.Test;

public class MainTest {

	@Test
	public void main() {
		BookShelf bookshelf = new BookShelf();
		bookshelf.appendBook(new Book("Around the world in 80 days"));
		bookshelf.appendBook(new Book("Bible"));
		bookshelf.appendBook(new Book("����"));
		bookshelf.appendBook(new Book("����"));
		bookshelf.appendBook(new Book("��ͭ��ʿ"));
		Iterator iterator = bookshelf.iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			System.out.println(book.toString());
		}
	}
}
