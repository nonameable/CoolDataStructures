public class Array {

	/** methos that replaces the ith number with i copies of itself*/
	public static int[] xify (int[] array){
		// first i find the new size of the array
		int length =  array.length;
		int newLength = 0;
		for (int i = 0; i < length ;i++ ) {
			newLength += array[i];
		}
		// create the new array and create a counter to travel through it.	
		int[] newArray = new int[newLength];
		int counter = 0;
		// now I have to fill the new array
		for (int i = 0; i < length ; i++ ) {
			int numberOfRepetitions = array[i];
			int repetitionCounter = 0;
			while (repetitionCounter < numberOfRepetitions)
			{
				newArray [counter] = numberOfRepetitions;
				counter = counter + 1;
				repetitionCounter = repetitionCounter + 1;
			}
		}
		return newArray;
	} 
	/** method that inserts val into the given position and returns a new array */
	public static int[] insert (int[] array, int position, int value)
	{
		int newLength = array.length + 1;
		int [] newArray = new int[newLength];
		for (int  i = 0; i <  newLength; i++ ) {
			if(i < position){
				newArray[i] = array [i];
			}
			else if( i == position)	{
				newArray[i] = value;
			}
			else if (i > position) {
				newArray[i] = array[i - 1];
			}

		}
		return newArray;
	}


	/** main method, also a small tester*/
	public static void main (String[] args ){

		int[] array  = {1, 2, 4, 5};
		System.out.print("The current array is: ");
		for (int i = 0; i < array.length ;i++ ) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("Now we insert 3 in position 2.");
		int[] newArray = Array.insert(array, 2, 3);
		System.out.println("Inserted!");
		System.out.print("The new array is: ");
		for (int i = 0; i < newArray.length ;i++ ) {
			System.out.print(newArray[i] + ", ");
		}
		System.out.println("Now we test the xify super method");
		int [] array2 = {3, 2, 1};
		System.out.print("The current array is: ");
		for (int i = 0; i < array2.length ;i++ ) {
			System.out.print(array2[i] + ", ");
		}
		System.out.println("Applying the function!");
		int [] newArray2 = Array.xify(array2);
		System.out.print("The new array is: ");
		for (int i = 0; i < newArray2.length ;i++ ) {
			System.out.print(newArray2[i] + ", ");
		}
		System.out.println("");



	}
}