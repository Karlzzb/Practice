package com.karl.simple.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CommonUtils {

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> t = new ArrayList<T>();

		for (int i = 0; i < list.size(); i++) {
			if (p.test(list.get(i))) {
				t.add(list.get(i));
			}
		}
		return t;
	}

	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<Apple>();

		List<Apple> redApples = CommonUtils.filter(inventory,
				(Apple apple) -> "red".equals(apple.getColor()));

		List<Apple> heavyApples = CommonUtils.filter(inventory,
				(Apple apple) -> apple.getWeight() > 100);

		inventory.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight(),
				a2.getWeight()));

	}

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
