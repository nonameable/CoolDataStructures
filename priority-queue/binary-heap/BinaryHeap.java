/*Class thar represents a binary heap of ints. 
*It can hold any value but zero
* The heap begins at index 1 for easy development
*/
public class BinaryHeap{

	int[] binaryHeap;
	int last;

	public BinaryHeap(int size){
		binaryHeap = new int[size];
		last = 0;
	}

	public BinaryHeap(){
		binaryHeap = new int[101];
		last = 0;
	}

	public void insert(int element){
		if(last + 1 < binaryHeap.length){
			binaryHeap[last + 1] = element;
			last = last + 1;
			upHeap(last);
		}
	}

	private void upHeap(int index){ // this can be done recursive and would be more elegant
		int parentIndex = index/2;
		while(binaryHeap[index] > binaryHeap[parentIndex]){
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = index/2;
		}
	}

	public int extractMin(int element){
		int min = binaryHeap[1];
		binaryHeap[1] = binaryHeap[last];
		binaryHeap[last] = 0;
		downHeap(1);
	}

	private void downHeap(int index){

		while(binaryHeap[index] > binaryHeap[index * 2] || binaryHeap[index] > binaryHeap[index * 2 + 1]){
			int indexMin = getIndexOfMin(index * 2, index * 2 + 1);
			swap(index, indexMin);
			index = indexMin;
		}
		
	}

	private int getIndexOfMin(int index1, int index2){
		if(binaryHeap[index1] > binaryHeap[index2]){
			return index1;
		}
		return index2;
	}

	private void swap(int index1, int index2){
		int aux = binaryHeap[index2];
		binaryHeap[index2] = binaryHeap[index1];
		binaryHeap[index1] = aux;
	}

	public static void main(String[] args) {
		
	}
}