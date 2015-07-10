

/** Demonstrates the power and elegance of this implementation of an SList
 * @author David M. Delgado, version of the SList by John Hug, UCBerkeley
 */

public class SListNoSentinelLauncher {

	public static void main (String[] args)
	{
		SListNoSentinel x = new SListNoSentinel(100);
		 
		// take into consideration that for them front is pointing to the head of the SList
		System.out.println(x.front.item);
		

		x.insertBack(5);
		// x: 100 -> 5
		System.out.println(x.front.next.item);

		SListNoSentinel y  = x;
		// y: 100 -> 5

		System.out.println(y.front.next.item);

		x.insertFront(99);
		//x: 99 -> 100 -> 5
		//y: 99 -> 100 -> 5

		System.out.println(y.front.item); // this should be 99

		//x = new SListNoSentinel();
		//System.out.println(x.size());


	}
}