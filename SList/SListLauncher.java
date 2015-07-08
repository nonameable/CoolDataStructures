public class SListLauncher {

/** Demonstrates the power and elegance of this implementation of an SList
 * @author David M. Delgado, version of the SList by John Hug, UCBerkeley
 */
	public static void main (String[] args)
	{
		SList x = new SList(100);
		 
		// take into consideration that for them front is pointing to the head of the SList

		x.insertBack(5);
		// x: 100 -> 5

		Slist y  = x;
		// y: 100 -> 5

		x.insertFront(99);
		//x: 99 -> 100 -> 5
		//y: 99 -> 100 -> 5

		x = new SList();
		System.out.println(x.size());


	}
}