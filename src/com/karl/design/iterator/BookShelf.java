package com.karl.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
	private List<Book> books;
	private int last = 0;

	public BookShelf() {
		this.books = new ArrayList<>();
	}

	public Book getBookat(int index) {
		return books.get(index);
	}

	public void appendBook(Book book) {
		books.add(book);
		last++;
	}

	public int getLength() {
		return this.last;
	}

	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}
