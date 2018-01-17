package com.karl.design.iterator;

public class BookShelfIterator implements Iterator {
	private BookShelf bookShelf;
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}

	@Override
	public boolean hasNext() {
		if (index < bookShelf.getLength()) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookat(index);
		index++;
		return book;
	}

}
