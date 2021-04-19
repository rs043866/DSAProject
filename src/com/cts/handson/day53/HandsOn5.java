package com.cts.handson.day53;

import java.io.*;
import java.util.*;


public class HandsOn5 {

	/*
	 * Complete the runningMedian function below.
	 */
	static double[] runningMedian(int[] a) {
		/*
		 * Write your code here.
		 */
		PriorityQueue<Integer> maxq = new PriorityQueue(Collections.reverseOrder());
		PriorityQueue<Integer> minq = new PriorityQueue();

		double[] ans = new double[a.length];
		int k = 0;
		for (int i = 0; i < a.length; i++) {

			if (maxq.size() == 0 || maxq.peek() > a[i]) {
				maxq.add(a[i]);
			} else {
				minq.add(a[i]);
			}

			if (maxq.size() > minq.size() + 1) {
				minq.add(maxq.poll());
			}
			if (minq.size() > maxq.size() + 1) {
				maxq.add(minq.poll());
			}

			if (maxq.size() == minq.size()) {
				ans[k++] = (maxq.peek() + minq.peek()) / 2.0;
			} else {
				ans[k++] = maxq.size() > minq.size() ? maxq.peek() : minq.peek();
			}
		}

		return ans;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int aCount = Integer.parseInt(scanner.nextLine().trim());

		int[] a = new int[aCount];

		for (int aItr = 0; aItr < aCount; aItr++) {
			int aItem = Integer.parseInt(scanner.nextLine().trim());
			a[aItr] = aItem;
		}

		double[] result = runningMedian(a);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
