package com.cts.handson.day52;

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

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		// Write your code here
		/* Find LCM for the arrayList a */
		int lcm_arr = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			lcm_arr = lcm(lcm_arr, a.get(i));
		}

		/* Find GCD for the arrayList b */
		int gcd_arr = b.get(0);
		for (int i = 1; i < b.size(); i++) {
			gcd_arr = gcd(gcd_arr, b.get(i));
		}

		/* Count the number of multiples of the LCM, which are factors of the GCD. */
		int count = 0;
		for (int i = lcm_arr, j = 1; i <= gcd_arr; i = j * lcm_arr) {
			if (gcd_arr % i == 0)
				count++;
			j++;
		}
		return count;

	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int total = getTotalX(arr, brr);

		bufferedWriter.write(String.valueOf(total));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
