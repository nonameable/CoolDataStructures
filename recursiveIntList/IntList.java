package recursiveIntList;

public class IntList {

	// instance variables
	int head;
	IntList tail;
	
	public IntList (int pHead, IntList pTail)
	{
		head = pHead;
		tail = pTail;
	}
	
	public int size (){ // finding the size recursively
		if (tail == null)
			return 1;
		else
		{
			return tail.size() + 1;
		}
	}
	
	public int iterativeSize (){
		IntList current = this; // I must begin somewhere
		int size = 0;
		while (current != null){
			size = size + 1;
			current = current.tail;
		}
		return size;
	}
	
	public IntList getIterative(int position)
	{
		int index  = 0;
		IntList current = this;
		IntList item = null;
		while (item == null && current != null)
		{
			System.out.println("index here is" + index);
			if (index  == position)
				item = current; 
			else
			{
				index  = index + 1;
				System.out.println("the tail is " + current.tail.head);
				current  = current.tail;
			}
		}
		return item;
	}
	
	public IntList get (int position) // getting an item recursively
	{
		if (position  == 0)
			return this;
		else
			return this.tail.get(position - 1);
	}
	
	/*
	 * or now, I can use the auxiliary Intlist in order to pass something different in the
	 * recursive call.
	 */
	public IntList incrList (IntList L, int x)  
	{
		L.head  = head  + x;
		IntList aux = new IntList( 0 , null);
		if (tail != null)
			L.tail = tail.incrList(aux, x);
		else
			L.tail = null;
		return L;
	}
	
	public String toString ()
	{
		return "" + head; 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntList list1 = new IntList(12, null);
		IntList list2 = new IntList(4, list1);
		IntList list3 = new IntList(3, list2);
		// Print tests of the first methods
		System.out.println( "iterative size is:  " + list3.size());
		System.out.println("recursive size is: " + list3.size());
		System.out.println("the last element has head: " + list3.get(2).head);
		System.out.println("the second element has head: " + list3.get(1).head);
		System.out.println("the first element has head: " + list3.get(0).head);
		
		//System.out.println("the second element has head (using get iterative): " + list3.getIterative(1).head);
		System.out.println("------------------------------------------");
		// print tests of the incrList
		IntList testList = new IntList(0, null);
		IntList testIncrementedList =   list3.incrList (testList, 1); 
		
		System.out.println("testIncrementedList is: " + testIncrementedList);
		
		System.out.println("the last element has head:  (should be 13) " + testIncrementedList.get(2).head); // 13
		System.out.println("the second element has head: (should be 5) " + testIncrementedList.get(1).head); //5
		System.out.println("the first element has head: (should be 4) " + testIncrementedList.get(0).head); //4
		//System.out.println("this should be null pointer element (get(3)) " + testIncrementedList.get(3).head); //null pointer

		/*
		 * Note to self: the incrList method does not work properly. It does increments the head, but just of the last element. Also, 
		 * its size appears to be infinite. I'll find the problem during the night. let's now read and rest a little bit. 
		 */
		
		//System.out.println("testing the size of the incremented list (iterative)" + testIncrementedList.getIterative(2).head); // this should be 13
		//System.out.println("testing the size of the incremented list (iterative) should be null pinter" + testIncrementedList.getIterative(5).head); // this should be null pointer exception

		//System.out.println( "iterative size of testIncrementedList is:  " + testIncrementedList.size());
		


		
		
	}

}
