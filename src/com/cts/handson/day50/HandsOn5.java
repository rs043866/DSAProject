package com.cts.handson.day50;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HandsOn5 {

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long outputArray[] = new long[n + 2];
		for (int i = 0; i < queries.length; i++) {
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];
			outputArray[a] += k;
			outputArray[b + 1] -= k;
		}
		long max = getMax(outputArray);
		return max;

	}

	private static long getMax(long[] inputArray) {
		long max = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < inputArray.length; i++) {
			sum += inputArray[i];
			max = Math.max(max, sum);
		}
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		int[][] queries = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				queries[i][j] = scanner.nextInt();
			}
		}
		long ans = arrayManipulation(n, queries);
	}
}
