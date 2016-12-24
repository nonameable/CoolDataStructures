import java.util.Hashtable;

/* Class that represents a Singly LinkedList*/
public class LinkedList {

	/* head Node of the linkedList */
	Node head;

	int size;

	public LinkedList() {
		this.size = 0;
	}

	public LinkedList(Node head) {
		this.head = head;
		this.size = 0;
	}

	public void addToTail(int value) {

		if (size == 0) {
			head = new Node(value);
		} else {
			Node toAdd = new Node(value);
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = toAdd;
		}
		size = size + 1;

	}

	public void addToTail(int[] values){
		

		Node n = head;

		for(int i = 0; i < values.length; i++){
			if(n == null){
				head = new Node(values[i]);
				n = head;
			} 
			else {
				Node toAdd = new Node(values[i]);
				n.next = toAdd;
				n = toAdd;
			}
			size  = size + 1;

		}
	}

	public void addToHead(int value) {
		if (size == 0) {
			head = new Node(value);
		} else {
			Node toAdd = new Node(value);
			toAdd.next = head;
			head = toAdd;
		}
		size = size + 1;

	}

	public void deleteTail() {
		if (size == 0) {

		} else if (size <= 1) {
			head = null;
			size = size - 1;
		} else {
			Node n = head;
			Node n2 = n.next;
			while (n2.next != null) {
				n = n2;
				n2 = n2.next;
			}
			n.next = null;
			size = size - 1;
		}

	}

	/*
	 * Only deletes when the value is found in the list. Otherwise it does nothing
	 */
	public void delete(int value) {
		if (value == head.value) {
			head = head.next;
			size = size - 1;
		} else {
			Node n = head;
			Node n2 = n.next;
			while (n2 != null && n2.value != value) {
				n = n2;
				n2 = n2.next;
			}
			if (n2 != null) {
				n.next = n2.next;
				size = size - 1;
			}
		}
	}

	public String toString() {
		String representation = "";
		Node n = head;
		while (n != null) {
			representation += " " + n.value;
			n = n.next;
		}
		return representation;

	}

	public void removeDuplicates() {
		if (size != 2) {
			// I will make use of the java collections framework here: Hash Table,
			// here we go bitches
			Hashtable<Integer, Integer> table = new Hashtable<>();
			Node n = head;
			table.put(n.value, n.value);
			Node n2 = n.next;
			while (n2 != null) {

				Integer test = table.get(n2.value);
				if (test != null) {
					n.next = n2.next; // deletes n2
					n2 = n.next;
					size = size - 1;
				} else {
					table.put(n2.value, n2.value);
					n = n2;
					n2 = n2.next;
				}

			}
		}
	}
	
	public Node kthToLastElementWithSize(int k){
		int desiredPosition = size - 1 - k;
		Node n = head;
		int i = 0;
		while(i < desiredPosition && n!= null){
			n = n.next;
			i = i + 1;
		}
		
		return n;
	}
	
	public Node kthToLastElement(int k){
		
		
		Node n = head;
		Node n2 = n.next;
		
		int i = 0;
		while(i < k -1 && n2!= null){ // off by one error
			n2 = n2.next;
			i = i+1;
		}
		
		if(n2!= null){
			while(n2.next != null){
				n = n.next;
				n2 = n2.next;
			}
			return n;
			
		}else {
			return null;
		}
	}
	
	// 2 4 5 7 3 1
	// 4
	// 2 1 3 4 7 5
	// 1 2 3 4 5 7

	// 2 5 4 7 3 1
  	// 2 5 4 7 3 1
  	// 2 

  	public NodeIndex findNodeByValue(int value){
  		Node current = head;
  		Node previous = null;
  		int index = 0;
  		while(current != null){
  			if(current.value == value){
  				return new NodeIndex(index, current, previous);
  			}
  			index = index + 1;
  			previous = current;
  			current = current.next;
  		}
  		return null;
  	}

	public void partitionAroundValue(int value){

		NodeIndex ni = findNodeByValue(value);
		Node previousToPivot = ni.previous;
		Node pivot = ni.node;
		int pivotIndex = ni.index;
		if(ni == null || size <= 1){
			// do nothing
		}
		else{
			//put the pivot at the beginning of the linked list
			previousToPivot.next = pivot.next;
			Node oldHead = head;
			head = pivot;
			pivot.next = oldHead;
			System.out.println(this.toString() + "  555555%%%%");
			previousToPivot = null; // equal to null again, pivot is now the ehad of the list. Maybe this does nothing
			Node current = head.next;

			while(current != null){ // this means, while I am still traversing the list
				if(current.value < value){
					// move pivot up until this position
					if (head == pivot){
						head = pivot.next;
					} else{
						previousToPivot.next = pivot.next;
					}
					Node currentNext = current.next;
					current.next = pivot;
					pivot.next = currentNext;
					previousToPivot = current;
					current = currentNext;

				}else{
					current = current.next;
				}
			System.out.println(this.toString() + " -------");
			}
		}

	}
	

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addToTail(0);
		System.out.println(list.toString());
		list.addToTail(1);
		list.addToTail(2);
		list.addToTail(3);
		System.out.println("adds nodes");
		System.out.println("size now is: " + list.size);
		System.out.println(list.toString());
		list.addToHead(-1);
		System.out.println("adds to head");
		System.out.println("size now is: " + list.size);
		System.out.println(list.toString());
		list.delete(-1);
		System.out.println("deletes first");
		System.out.println("size now is: " + list.size);
		System.out.println(list.toString());
		list.delete(3);
		System.out.println("deletes last");
		System.out.println("size now is: " + list.size);
		System.out.println(list.toString());
		list.addToTail(3);
		System.out.println("adds item just deleted");
		System.out.println(list.toString());
		list.delete(4);
		System.out.println("tries to delete item not found in the list");
		System.out.println(list.toString());
		
		System.out.println("size now is: " + list.size);

		System.out.println("------ Removing duplicates testing -------------");
		list.addToTail(2);
		list.addToTail(0);
		System.out.println("adds repeated items");
		System.out.println(list.toString());
		list.addToTail(4);
		list.addToTail(1);
		System.out.println("adds duplicate and new item");
		System.out.println(list.toString());
		list.removeDuplicates();
		System.out.println("removes duplicates");
		System.out.println(list.toString());

		System.out.println("------ kth to last element testing -------------");
		
		Node withSize = list.kthToLastElementWithSize(2);
		System.out.println("Test with size: " + withSize.value);
		
		Node pointers = list.kthToLastElement(2);
		System.out.println("Test with 2 pointers: " + pointers.value);


		
	}

}
