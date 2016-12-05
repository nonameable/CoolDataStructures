package binary_search;

public class RotatedBinarySearch {

	public int findIndexRotaded(int[] array, int x) throws Exception{
		int pivot = -1;
		for (int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i+1]) pivot = i;
		}
		if(x >= array[0] && x <= array[pivot]){
			return binarySearch(0, pivot, array, x);
		}
		else if(x >= array[pivot + 1] && x <= array[array.length -1]){
			return binarySearch(pivot + 1, array.length -1, array, x);
		}else {
			return -1;
		}
	}
	
	public int binarySearch(int first, int last, int[] array, int x){
		int middle = (last +first) /2;
		if(x == array[middle]) return middle;
		if(x < middle) return binarySearch(first, middle - 1, array, x);
		return binarySearch(middle + 1, last, array, x);
	}
	

	
	public static void main(String[] args) throws Exception {
		RotatedBinarySearch rbs = new RotatedBinarySearch();
		int[] array =  {4,5,0, 785, 1345, 0, 1,2};//{4,5,6,7,18, 72, 106, 0,1,2};
		int x = 1;
		System.out.println("index of " + x+ " is: " + rbs.findIndexRotaded(array, x));
	}

}
