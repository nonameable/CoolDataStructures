package recursiveIntList;


public class IntListOps {
	
	/*
	 * returns identical to L, but with every item incremented by x; L cannot change
	 */
	public static IntList incrList (IntList L, int x)
	{
		if (L == null) // base case
			return null; 
		else 
		{
			int newHead = L.head + x; // stablish the new head
			IntList newTail = incrList(L.tail, x); // stablish the new tail, with the recursive call of the same method
			return new IntList(newHead, newTail); // returns the list
		}
		
	
	}
	/*
	 * Returns a list identical to L. but with every item incremented by x; Not allowed to use the 'new' keyword
	 * I think I'm allowed to change the values of L, because if I'm not allowed to use 'new', I think this is the only way to do this
	 */
	public static  IntList dincrList (IntList L, int x) //Done!!
	{
		if (L == null)
			return null;
		else
		{
			L.head  = L.head + x;
			L.tail = dincrList(L.tail, x);
			return L;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntList list1 = new IntList(12, null);
		IntList list2 = new IntList(4, list1);
		IntList list3 = new IntList(3, list2);
		IntList list4 =  new IntList (2, list3);
		
		// testing incrList
		IntList testIncrementedList = incrList(list4, 1);
		System.out.println("the last element has head:  (should be 13) " + testIncrementedList.get(3).head); // 13
		System.out.println("the 3 element has head: (should be 5) " + testIncrementedList.get(2).head); //5
		System.out.println("the 2 element has head: (should be 4) " + testIncrementedList.get(1).head); //4
		System.out.println("the 1 element has head: (should be 3) " + testIncrementedList.get(0).head); //3

		System.out.println("------------------------------------------------------------------------------");
		// testing dinctList
		IntList testIncrementedList2 = dincrList(list4, 1);
		System.out.println("the last element has head:  (should be 13) " + testIncrementedList2.get(3).head); // 13
		System.out.println("the 3 element has head: (should be 5) " + testIncrementedList2.get(2).head); //5
		System.out.println("the 2 element has head: (should be 4) " + testIncrementedList2.get(1).head); //4
		System.out.println("the 1 element has head: (should be 3) " + testIncrementedList2.get(0).head); //3
		
	}

}
