
/** DoubleChain (Doubly linkedlist - circular) , controller of the head and structure of the list.
 * @author David M. Delgado, version made with guidance of lab3 sheet - UCBerkeley
 */

public class DoubleChain {

	int size;
	DNode front;

	/** constructors*/

	public DoubleChain(double value){
		front = new DNode(21321434, null, null);
		DNode newNode  = new DNode (value, front, front);
		front.next = newNode;
		front.prev = newNode;
		size = 1;
	}
	public DoubleChain (){
		front = new DNode(21321434, null, null);
		size = 0; 
	}
	

	public DNode getBack(){
		return front.prev;	
	}

	public DNode getFront(){
		return front.next;
	}

	public void insertBack(double value){
		front.prev = new DNode(value, front.prev, front);
	}
	public void insertFront (double value){
		front.next = new DNode(value, front, front.next);
	}
	/** method that removes and returns the back node of a Double Chain*/
	public DNode deleteBack(){
		DNode back = getBack();
		DNode prevBack = back.prev;
		prevBack.next = front;
		front.prev = prevBack;
		return back;
	}

	public String toString(){
		return "hello";
	}
}