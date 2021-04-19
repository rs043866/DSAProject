package com.cts.handson.day50;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HandsOn2 {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] a) {
		int maxi = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = 0;
				sum += a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1] + a[i + 2][j] + a[i + 2][j + 1]
						+ a[i + 2][j + 2];

				if (sum > maxi) {
					maxi = sum;
				}
			}
		}
		return maxi;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[][] a = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		int ans = hourglassSum(a);
	}
}
