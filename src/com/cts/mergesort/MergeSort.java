package com.cts.mergesort;

/*
 * T(N) = 2T(N/2) + O(N)
 * 
 * Best -> NlogN
 * Average -> NlogN
 * Worst -> NlogN
 * 
 * User_Name : gyanendras
 * 
 */

class MergeSort {

	void merge(int arr[], int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[low + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];

		int i = 0, j = 0;

		int k = low;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2; // (l+r)/2

			sort(arr, low, mid);
			sort(arr, mid + 1, high);

			merge(arr, low, mid, high);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
