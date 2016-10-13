public class Heap {

	public final static int defaultSize = 10;
	
	private int[] heap;
	private int size;

	/* General Constructor. Recieves regular */
	public Heap(){
		heap =  new int[defaultSize];
		size = defaultSize;
	}

	/* Specific constructor: Receives size as a parameter*/
	public Heap(int size){

		if(size > 0){
			heap = new int[size];
			this.size = size;
		}
		else {
			throw new IllegalArgumentException("You must provide a size bigger than 0");
		}
		
	}

	public int size(){
		return size;
	}



}