package sort;

import java.util.ArrayList;

public class Mergesort {

	public ArrayList<Integer> merge(int[] a, int[] b) {
		ArrayList<Integer> result = new ArrayList<>();
		int indexA = 0, indexB = 0;
		while (indexA < a.length || indexB < b.length) {
			if (indexA >= a.length) {
				result.add(b[indexB]);
				indexB++;
			} else if (indexB >= b.length) {
				result.add(a[indexA]);
				indexA++;
			} else {
				if (a[indexA] < b[indexB]) {
					result.add(a[indexA]);
					indexA++;
				} else if (b[indexB] < a[indexA]) {
					result.add(b[indexB]);
					indexB++;
				} else {
					result.add(a[indexA]);
					indexA++;
					indexB++;
				}
			}
		}
		return result;
	}

	public ArrayList<Integer> mergeSort(int[] a, int[] b) {
		return mergeSortHelper(a, 0, a.length - 1);
	}

	public ArrayList<Integer> mergeSortHelper(int[] a, int first, int last) {
		ArrayList<Integer> mergedList = null;
		if (first == last) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(a[first]);
			return l;
		} else {
			int middle = (last + first) / 2;
			ArrayList<Integer> right = mergeSortHelper(a, middle + 1, last);
			Integer[] rightSorted = right.toArray(new Integer[right.size()]);
			ArrayList<Integer> left = mergeSortHelper(a, first, middle);
			Integer[] leftSorted = left.toArray(new Integer[left.size()]);

			return mergedList;
		}
	}

	public static void main(String[] args) {
		Mergesort sorter = new Mergesort();
		int[] a = { -2, 0, 1, 4, 9 };
		int[] b = { -1, 0, 2, 5, 8, 10, 55 };
		ArrayList<Integer> mergedList = sorter.merge(a, b);
		System.out.println(mergedList);

	}

}
