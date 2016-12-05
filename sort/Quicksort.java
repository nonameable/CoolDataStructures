package sort;

import java.util.Arrays;

public class Quicksort {

	public void quicksort(int[] array) {
		quicksortHelper(array, 0, array.length - 1);
	}

	private void quicksortHelper(int[] array, int p, int r) {
		// there must me a base case to stop the recursion

		if (r - p == 0) {
			return;
		} else {

			int pivotIndex = partition(array, p, r);

			// call quicksort on each side only if we are not interfering with other
			// ranges
			if (p < pivotIndex) {
				quicksortHelper(array, p, pivotIndex - 1);
			}
			if (r > pivotIndex) {
				quicksortHelper(array, pivotIndex + 1, r);
			}

			// done :)
		}

	}

	public int partition(int[] array, int p, int r) {
		// pick a pivot. Let it be the right-most value
		int pivot = array[r];
		int pivotIndex = r;
		int i = pivotIndex - 1;

		while (i >= 0) {

			if (array[i] > pivot) {
				// move it to the right until it reaches the position pivotIndex -1 and
				// then swap
				int j = i;
				while (j != pivotIndex - 1) {
					swap(array, j, j + 1);
					j++;
				}
				swap(array, j, pivotIndex);
				pivotIndex = pivotIndex - 1;
			}
			i--;
		}
		return pivotIndex;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] unsortedNumbers = { -1, 2, 10, 2, 15, 3, 7, 9, 12, 3, 6, 1 };
		int[] un2 = { 0, 6, -1, 4, 3, 1, 67, 54, 12, 21, 3, -10, 7, 6, 0, 1, 2, 23,
				43, 61, 54, 15, 17, 41, 2, 12, 33, 2, 1, 8, 7, 16 };
		int[] arr = { 2, 3, 13, 0, 10, 1, 4 };
		Quicksort sorter = new Quicksort();

		sorter.quicksort(unsortedNumbers);
		System.out.println(Arrays.toString(unsortedNumbers));
		sorter.quicksort(un2);
		System.out.println(Arrays.toString(un2));

	}
}
