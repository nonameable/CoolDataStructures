
/** SList without sentinel, controller of the head and structure of the list.
 * @author David M. Delgado, version of the SList by Josh Hug, UCBerkeley
 */
public class SListNoSentinel {

	//atributes
	public IntNode front; //actually, the head
	public int size;

	// constructor
	public SListNoSentinel (int x) {
		front = new IntNode(x, null);
		size = 1;
	}

	public SListNoSentinel (){
		front =  null;
		size = 0;
	}

	public void insertBack (int x){

		if (front != null)
		{
			// lets use a pointer here
			IntNode p = front;
			// step p along the list until p.next == null, thereofre, p is the last 
			// item on the list. 

			while (p.next != null) {
				p = p.next;
			}
			// here we know p is the last one and the natural thing to do is simply add to next and replace null
			p.next = new IntNode(x, null); // <- new IntNode at the back.

		}
		else {
			front = new IntNode (x, null);
		}
		
		// add +1 to the size attribute
		size++;

	}

	public void insertFront(int x) {

		front = new IntNode(x, front);
		
		// add +1 to the size attribute
		size++;

	}

	public int size(){
		return size;
	}

	public int sizeRecursive(){ 
		return sizeRecursiveHelper(front); // we have to pass its own head as parameter
	}

	public int sizeRecursiveHelper (IntNode actual) { 
		if (actual == null)
			return 0;
		return 1 + sizeRecursiveHelper(actual.next);
	}

}