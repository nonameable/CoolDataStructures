public class LinkedListTesting {

	public static void main(String[] args){
		
		LinkedList listToAdd  = new LinkedList();
		int[] values = {1,2,3,4,5,6};
		

		System.out.println("----------------Testing addToTail array----------");
		listToAdd.addToTail(values);
		System.out.println("List Now is: " + listToAdd.toString());
		System.out.println("---------------- END Testing addToTail array  ----------");




		LinkedList number1 = new LinkedList();
		LinkedList number2 = new LinkedList();

		int[] num1 = {7,1,6};
		int[] num2 = {5,9,2};
		number1.addToTail(num1);
		number2.addToTail(num2);


		System.out.println("-------------- Testing addition using linked list representation of numbers");

		LinkedList sum = addNumbersAsLists(number1, number2);
		System.out.println("Result of addition is: " + sum.toString());

		System.out.println("--- Testing non trivial case -----");

		int[] num3 = {1,2,6,9};
		number2 = new LinkedList();
		number2.addToTail(num3);

		LinkedList sum2 = addNumbersAsLists(number1, number2);
		System.out.println("Result of addition is: " + sum2.toString());



		System.out.println("--------------  END Testing addition using linked list representation of numbers");





		LinkedList list = new LinkedList();

		list.addToTail(1);
		list.addToTail(5);
		list.addToTail(3);
		list.addToTail(0);
		list.addToTail(2);
		list.addToTail(4);
		list.addToTail(7);
		list.addToTail(6);

		//System.out.println(list.toString());

		//System.out.println("----------------Testing find by Value----------");
		//NodeIndex n = list.findNodeByValue(4);
		//System.out.println("Index of node is: " + n.index);
		//System.out.println("----------------Testing find by Value end----------");


		//System.out.println("----------------Testing partition---------------");
		//list.partitionAroundValue(4);
		//System.out.println(list.toString());
		//System.out.println("----------------Testing partition end---------------");




	}


	public static LinkedList addNumbersAsLists(LinkedList num1, LinkedList num2){
		LinkedList ans  = new LinkedList();
		Node i = num1.head;
		Node j = num2.head;
		int carry = 0;
		while(i != null || j != null || carry != 0){
			System.out.println("[[[[[[[[[[[[[[");
			int currentSum = 0;
			if(i != null){
				currentSum += i.value;
				i  = i.next;
			}
			if(j!= null){
				currentSum += j.value;
				j = j.next;
			}
			System.out.println("currentSum: " + currentSum);
			System.out.println("carry: " + carry);
			ans.addToTail((currentSum + carry) % 10);
			carry = (currentSum + carry) / 10;
			System.out.println("For now, sum is: " + ans.toString());
			System.out.println("]]]]]]]]]]]]]]");
		}	
		return ans;		
	}

	
}