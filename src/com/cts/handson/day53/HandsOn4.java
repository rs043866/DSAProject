package com.cts.handson.day53;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'componentsInGraph' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * 2D_INTEGER_ARRAY gb as parameter.
	 */
	static int[] root;
	static int[] cnt;
	static int minAnswer = 30000;
	static int maxAnswer = 0;

	static int find(int node) {
		if (root[node] == node)
			return node;
		else
			return root[node] = find(root[node]);
	}

	static void union(int node1, int node2) {
		int root1 = find(node1);
		int root2 = find(node2);

		int sumLen = cnt[root1] + cnt[root2];

		if (root1 == root2)
			return;

		root[root2] = root[root1];

		cnt[root1] = sumLen;
		cnt[root2] = sumLen;
	}

	public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
// Write your code here
		List<Integer> result = new ArrayList<>();

		int N = 15000;
		root = new int[2 * N + 1];
		cnt = new int[2 * N + 1];

		for (int i = 1; i <= 2 * N; i++) {
			root[i] = i;
			cnt[i] = 1;
		}

		for (int i = 0; i < gb.size(); i++) {
			int left = gb.get(i).get(0);
			int right = gb.get(i).get(1);

			union(left, right);
		}

		for (int i = 1; i <= N; i++) {
			int ret = cnt[find(i)];

			if (ret != 1) {
				minAnswer = Math.min(minAnswer, cnt[find(i)]);
				maxAnswer = Math.max(maxAnswer, cnt[find(i)]);
			}
		}

		result.add(minAnswer);
		result.add(maxAnswer);
		return result;
	}

}

public class HandsOn4 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> gb = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				gb.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = Result.componentsInGraph(gb);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
