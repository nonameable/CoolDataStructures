public class Heap {

	public final static int defaultSize = 10;
	
	private Integer[] heap;
	private int size;
	private int numberOfElements;

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


	/* Adds an integer to the heap and places it in its correct position */
	public void add(Integer i){
		// dont forget to increase numberOfElements
	}

	/* Removes an integer from the heap. If Integer i is not found throws and Exception*/
	public void remove(Integer i){


	}

	/* Returns the root of the heap*/
	public Integer getRoot(){
		return heap[0];
	}

	public void upHeap(Integer i){

	}
	public void downHeap(Integer i){

	}


}