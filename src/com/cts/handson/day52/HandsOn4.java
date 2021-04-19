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
    /* buckets: stores the number of elements for each bucket
      buckets[i] = n means ith bucket has n elements inside */

    for (int i = 0; i < arr.length; i++) {
        int current = arr[i];
        current %= k; // find the corresponding bucket
        /* Find it's coresponding complement bucket */
        if (current == 0) {
            complement = 0;
        }
        else {
            complement = k - current;
        }

        count += buckets[complement]; // add all possible pairs between the current and every elements inside the complement bucket
        buckets[current]++; // add the current into its bucket
    }

    return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

