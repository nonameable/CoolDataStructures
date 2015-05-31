package recursiveIntList;

/*
 * Exercises in the Discussion 2
 */
public class IntListOps2 {
	
	/*
	 * Squares a list by changing its original values
	 */
	public static IntList squareDestructive (IntList L){
		if (L == null)
		{
			return null;
		}
		else
		{
			L.head = L.head * L.head;
			L.tail = squareDestructive(L.tail);
			return L;
		}
	}
	/*
	 * Squares a list by changing its original values, this time iterating through the list
	 */
	public static IntList squareDestructiveIterative(IntList L) {
		IntList current = L;
		while (current != null)
		{
			current.head = current.head  * current.head;
			current = current.tail;
		}
		return current;
	}
	/*
	 * Squares a list without changing the values of the original list
	 */
	public static IntList squareNonDestructive (IntList L) {
		if (L == null)
		{
		return null;
		}
		else
		{
			int newHead = L.head * L.head;
			IntList list = squareNonDestructive(L.tail);
			return new IntList(newHead, list);
		}
		
	}
	/*
	 * Squares a list without changing the values of the original list, this time iterating through the list
	 */
	public static IntList squareNonDestructiveIterative (IntList L)	{
		IntList currentOld = L;
		IntList currentNew = null;
		IntList answerList = currentNew; // this is to save the reference of the first IntList
		while  (currentOld != null)
		{
			int newNead  = currentOld.head * currentOld.head;
			if (currentNew == null){
				currentNew = new IntList(newNead, null);
				answerList = currentNew;
			}
			else
			{
				currentNew.tail = new IntList(newNead, null);
				currentNew  =  currentNew.tail;
			}
			currentOld  = currentOld.tail;
		}
		return answerList;
	}
	
	/*
	 * returns a reverse copy of the list, with out changing the values of the original List
	 */
	
	public static IntList reverseNonDistructiveIterative (IntList L){
		IntList currentOld = L;
		IntList currentNew = null;
		while  (currentOld != null)
		{
			int newNead  = currentOld.head;
			if (currentNew == null){
				currentNew = new IntList(newNead, null);
			}
			else
			{
				IntList auxList = new IntList(newNead, null);
				auxList.tail = currentNew;
				currentNew = auxList; 
				
			}
			currentOld  = currentOld.tail;
		}
		return currentNew;
	}

		/*
		 * main
		 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testing L
		System.out.println("Testing L IntList");
		IntList L = new IntList (4, null);
		System.out.println(L.toString());
		L = new IntList (3, L);
		System.out.println(L.toString());
		L = new IntList (2, L);
		System.out.println(L.toString());
		L  = new IntList(1, L);
		System.out.println(L.toString());
		
		IntList M = L.tail;
		
		System.out.println("-------------------------");
		System.out.println("Testing N IntList");
		
		IntList N  = new IntList(6, null);
		System.out.println(N.toString());
		N = new IntList (5, N);
		System.out.println(N.toString());
		
		System.out.println("  ;;;;; checking if the references work as expected");
		System.out.println("This should be 6 and is: " + N.tail.toString());

		System.out.println("-------------------------");
		System.out.println("Testing N, M and  L IntList");
		
		// first, I make N a cycle IntList and test if it works
		System.out.println("first, I make N a cycle IntList");
		N.tail.tail  = N;
		System.out.println("The tail of N is: " + N.tail.toString());
		System.out.println("The tail of the tail is :" + N.tail.tail.toString());
		System.out.println("-------------------------");
		// playing with M
		// This changes the tail of the very first IntList to the tail of N
		M.tail.tail.tail  = N.tail; 
		System.out.println("This should be 6 : " + M.tail.tail.tail.head);
		//this jumps the Intlist containing 3, so the list is L is now 1, 2, 4 - 6
		L.tail.tail = L.tail.tail.tail;
		System.out.println("Jump, this should be 4 " + L.tail.tail.head);
		// this puts the reference of L to the first list created, 4
		L = M.tail;
		System.out.println("this should be 4:  " + L.head);
		
		System.out.println("-------------------------");
		System.out.println("testing the method that squares the list!");
		// testing the method that squares the list!
		L = new IntList (4, null);
		System.out.println(L.toString());
		L = new IntList (3, L);
		System.out.println(L.toString());
		L = new IntList (2, L);
		System.out.println(L.toString());
		L  = new IntList(1, L);
		System.out.println(L.toString());
		
		IntList squaredList  = squareNonDestructiveIterative(L);
		int s  = L.size();
		System.out.println("The size of the 2rd list is: " + s);
		IntList current =  squaredList;
		for (int i = 0; i < s; i++) {
			System.out.println("The head of the " + i + "is : " + current.head );
			current  = current.tail;
		}
		
		System.out.println("-------------------------");
		System.out.println("testing the method that reverses the list!");
		// testing the method that reverses the list!
		L = new IntList (4, null);
		System.out.println(L.toString());
		L = new IntList (3, L);
		System.out.println(L.toString());
		L = new IntList (2, L);
		System.out.println(L.toString());
		L  = new IntList(1, L);
		System.out.println(L.toString());
		
		
		IntList reversedList  = reverseNonDistructiveIterative(L);
		s  = reversedList.size();
		System.out.println("The size of the reversed list is: " + s);
		current =  reversedList;
		for (int i = 0; i < s; i++) {
			System.out.println("The head of the " + i + "is : " + current.head );
			current  = current.tail;
		}
		
		
	}

}
