package com.karl.algorithm.dataOp;

public class StringOption {

	public static String repeat1(char c, int n) {
		String answer = "";
		for (int i = 0; i < n; i++) {
			answer += c;
		}
		return answer;
	}

	public static String repeat2(char c, int n) {
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			answer.append(c);
		}
		return answer.toString();
	}

}
