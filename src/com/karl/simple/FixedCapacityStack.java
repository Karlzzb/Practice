package com.karl.simple;

import java.util.Iterator;

public class FixedCapacityStack<T> implements Iterable<T> {
	private T[] items;
	private int size;

	public FixedCapacityStack(int cap) {
		items = (T[]) new Object[cap];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push(T item) {
		items[size] = item;
		size++;
	}

	public T pop() {
		size--;
		return items[size];
	}

	public Iterator<T> iterator() {
		return new InnerIterator();
	}

	private class InnerIterator implements Iterator<T> {
		private int pos = size;

		@Override
		public boolean hasNext() {
			return pos > 0;
		}

		@Override
		public T next() {
			pos--;
			return items[pos];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {
		FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
		for (String item : args) {
			if (item.equals("-")) {
				stack.pop();
			} else {
				stack.push(item);
			}
		}
		for (String s : stack) {
			System.out.println(s);
		}

		for (Iterator<String> itr = stack.iterator(); itr.hasNext();) {
			String s = itr.next();
			System.out.println(s);
		}

		stack.forEach(s -> System.out.print(s));
	}

}
