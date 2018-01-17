package com.karl.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>(Arrays.asList("c++", "Java", "121",
				"1212"));
		System.out.println(Arrays.toString(set.toArray(new String[0])));
	}

}
