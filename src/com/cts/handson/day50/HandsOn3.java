package com.cts.handson.day50;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HandsOn3 {
	public static List<Integer> rotateLeft(int d, List<Integer> arr) {
		while (d != 0) {
			arr.add(arr.remove(0));
			--d;
		}
		return arr;

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		List<Integer> ans = rotateLeft(d, arr);
	}
}
