package com.cts.handson.day52;

import java.util.*;

public class HandsOn1 {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    Arrays.sort(arr);
    long min = 0, max = 0;
    for(int i = 0, j = arr.length - 1; i < arr.length - 1; i++, j--){
            max = max + arr[j];
            min = min + arr[i];
        }
        System.out.println(min + " " + max);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
