import java.util.ArrayDeque;
import java.util.Arrays;

public class LLProblems {

	/* Returns true if the linkedlist is a palindrome. Empty linkedlist are not considered palindromes*/
	public boolean isPalindrome(LinkedList list){
		boolean isPalindrome = false;
		// code
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		Integer previous1 = null;
		Integer previous2 = null;

		// 1  2  3  4  5  4  3  2  1
		           //p2 p1

		// 1 2 3 3 2 1
		Node current = list.head;
		while(current != null){
			
			Integer n = stack.peek();
			//System.out.println("n is: " + n + " and previous2 is: " + previous2);
			if(n != null){
				
				if(n == current.value){
					stack.pop();
				}
				else if(previous2 != null && current.value == previous2){
					stack.pop();
					stack.pop();
				}
				else{
					stack.push(current.value);
					previous2 = previous1;
					previous1 = current.value;
				}
			}
			else{
				stack.push(current.value);
				previous1 = current.value;
			}
			current = current.next;
			//System.out.println(Arrays.toString(stack.toArray()));
			Arrays.toString(stack.toArray());
				
		}

		isPalindrome = stack.isEmpty();
		return isPalindrome;
	}

	public static void main(String[] args) {
		LLProblems llp = new LLProblems();

		System.out.println("------------------- Testing palindrome --------------");
		LinkedList listEven  = new LinkedList();
		int[] values1 = {1,2,3,4,4,3,2,1};
		listEven.addToTail(values1);
		LinkedList listOdd  = new LinkedList();
		int[] values2 = {1,2,3,4,5,4,3,2,1};
		listOdd.addToTail(values2);

		LinkedList listNotPalindrome  = new LinkedList();
		int[] values3 = {1,2,3,4,5,6};
		listNotPalindrome.addToTail(values3);

		

		System.out.println("Is palindrome listEven: " + llp.isPalindrome(listEven));

		System.out.println("Is palindrome listOdd: " + llp.isPalindrome(listOdd));

		System.out.println("Is palindrome listNotPalindrome: " + llp.isPalindrome(listNotPalindrome));

		System.out.println("------------------- END Testing palindrome --------------");

	}
}