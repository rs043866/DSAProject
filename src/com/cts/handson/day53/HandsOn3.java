package com.cts.handson.day53;

import java.io.*;
import java.util.*;

public class HandsOn3 {

	static final List<Character> OPENING = Arrays.asList('{', '[', '('), CLOSING = Arrays.asList('}', ']', ')');

	static final String TRUE = "YES", FALSE = "NO";
	static final int NOT_FOUND = -1;

	// Complete the isBalanced function below.
	static String isBalanced(String s) {
		Deque<Character> brackets = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			int pos = CLOSING.indexOf(ch);
			if (pos != NOT_FOUND) {
				if (!OPENING.get(pos).equals(brackets.poll()))
					return FALSE;
			} else
				brackets.push(ch);
		}
		return brackets.isEmpty() ? TRUE : FALSE;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
