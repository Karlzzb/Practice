package com.karl.algorithm.recuision;

import java.io.File;

public class DiskUsage {
	public static long diskUsage(File root) {
		long total = root.length();
		if (root.isDirectory()) {
			for (String childName : root.list()) {
				total += diskUsage(new File(root, childName));
			}
		}
		System.out.println(total + "\t" + root);
		return total;
	}

	public static void main(String[] args) {
		diskUsage(new File("C:\\myfiles"));
	}
}
