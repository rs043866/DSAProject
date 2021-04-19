package com.cts.handson.day52;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HandsOn4 {

	// Complete the divisibleSumPairs function below.
	static int divisibleSumPairs(int n, int k, int[] arr) {
		int count = 0;
		int complement; // stores the complement value according to the current value with respect to k
		int[] buckets = new int[k];
		/*
		 * buckets: stores the number of elements for each bucket buckets[i] = n means
		 * ith bucket has n elements inside
		 */

		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			current %= k; // find the corresponding bucket
			/* Find it's coresponding complement bucket */
			if (current == 0) {
				complement = 0;
			} else {
				complement = k - current;
			}

			count += buckets[complement]; // add all possible pairs between the current and every elements inside the
											// complement bucket
			buckets[current]++; // add the current into its bucket
		}

		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] arr = new int[10];
		for(int i=0;i<n;i++) {
			arr[i] = scanner.nextInt();
		}
		divisibleSumPairs(n, k, arr);
		scanner.close();
	}
}
