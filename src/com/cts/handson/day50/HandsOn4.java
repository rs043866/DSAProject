package com.cts.handson.day50;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HandsOn4 {

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {
		int sizeOfString = strings.length;
		int sizeOfQueries = queries.length;
		int[] result = new int[sizeOfQueries];

		for (int i = 0; i < sizeOfString; i++) {
			for (int j = 0; j < sizeOfQueries; j++) {
				if (strings[i].equals(queries[j])) {
					result[j]++;
				}

			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] strings = new String[10];
		String[] queries = new String[10];
		int n, m;
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			strings[i] = scanner.nextLine();
		}
		m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			queries[i] = scanner.nextLine();
		}
		matchingStrings(strings, queries);
	}
}
