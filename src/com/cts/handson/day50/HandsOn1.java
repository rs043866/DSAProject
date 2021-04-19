package com.cts.handson.day50;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HandsOn1 {

	// Complete the reverseArray function below.
	static int[] reverseArray(int[] a) {
		int n = a.length;
		int i = 0;
		int j = n - 1;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return a;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int a[] = new int[20];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int ans[] = reverseArray(a);
	}
}
