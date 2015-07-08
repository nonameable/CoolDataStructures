package classExercises;

/*
 * Provide the ability to print args in sorted order
 */


public class Sort {
	
	/** Puts A in sorted order. */
	
	public static void sort (String [] a){
		sort (a, 0);
	}
	
	/** Sort A starting from position START*/
	public static void sort (String [] a, int start) {
		// find the smallest element (its position)
		int positionSmallest = start;
		int index  = start;
		int size =a.length;
		while (index < size)
		{
			if (a [index].compareTo(a[positionSmallest]) < 0)
				positionSmallest  = index;
		}
		
		// swap it with the element to the front
		String aux  = a [start];
		a [start] = a[positionSmallest];
		a [positionSmallest] = aux;
		
		// recursively sort the rest, only if start is less than the length
		if (start < size)
			sort (a, start + 1);
	}
	
	
	/** prints A */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
