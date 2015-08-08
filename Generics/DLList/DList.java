/** Generics DLList (circular), controller of the head and structure of the list.
 * This DLList uses a sentinel node to have easier algorithms and more efficent operations.
 * @author David M. Delgado
 */


public class DLList <T> {

	// -----------------------------------------------------------------
	// Atributes
	// -----------------------------------------------------------------
	public int size;
	public DNode <T> front;


	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	public DoubleChain(T pElement){
		front = new DNode("Sentinel", null, null);
		DNode <T> newNode  = new DNode <T> (pElement, front, front);
		front.next = newNode;
		front.prev = newNode;
		size = 1;
	}
	public DoubleChain (){
		front = new DNode("Sentinel", null, null);
		size = 0; 
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	/** Returns the element at the back of the list*/
	public T getBack(){
		return front.prev.element;	
	}
	/** Returns the element at the back of the list*/
	public T getFront(){
		return front.next.element;
	}
	/** */

	/** Returns the back node of the list*/
	public DNode <T> getBack(){
		return front.prev;	
	}
	/** Returns the front node of the list */
	public DNode <T> getFront(){
		return front.next;
	}
	/** Inserts element at the back of the list */
	public void insertBack(T element){
		front.prev = new DNode <T>(element, front.prev, front);
	}

	/** */
	public void insertFront (T element){
		front.next = new DNode <T> (element, front, front.next);
	}

	/** */
	public void insertNodeBack(DNode <T> pNode){
		previousTail = front.prev;
		front.prev = pNode;
		pNode.next = front;
	}

	/** */
	public void insertNodeFront (Node <T> element){
		front.next = new DNode(element, front, front.next);
	}
	
	/** method that removes and returns the back node of a Double Chain*/
	public DNode deleteBack(){
		DNode back = getBack();
		DNode prevBack = back.prev;
		prevBack.next = front;
		front.prev = prevBack;
		return back;
	}

	
}