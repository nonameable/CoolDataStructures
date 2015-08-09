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
		front = new DNode <T> (null, null, null);
		DNode <T> newNode  = new DNode <T> (pElement, front, front);
		front.next = newNode;
		front.prev = newNode;
		size = 1;
	}
	public DoubleChain (){
		front = new DNode <T> ("Sentinel", null, null); // everything applies, this will not work
		size = 0; 
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** INSERTION METHODS*/
	
	/** Inserts element at the back of the list */
	public void insertBack(T element){
		front.prev = new DNode <T>(element, front.prev, front);
	}

	/** Inserts element at the front of the list  */
	public void insertFront (T element){
		front.next = new DNode <T> (element, front, front.next);
	}

	/** Inserts a node at the back of the list.*/
	public void insertNodeBack(DNode <T> pNode){
		DNode <T> previousTail = front.prev;
		front.prev = pNode;
		pNode.next = front;
		pNode.prev = previousTail;
		previousTail.next = pNode;
	}

	/** Inserts a node at the back of the list */
	public void insertNodeFront (Node <T> pNode){
		DNode <T> previousHead = front.next;
		front.next = pNode;
		pNode.prev = front;
		pNode.next = previousHead;
		previousHead.prev = pNode;
	}


	/** GET METHODS*/


	/** Returns the element at the back of the list*/
	public T getBack(){
		return front.prev.element;	
	}
	/** Returns the element at the back of the list*/
	public T getFront(){
		return front.next.element;
	}
	/**  */

	/** Returns the back node of the list*/
	public DNode <T> getBack(){
		return front.prev;	
	}
	/** Returns the front node of the list */
	public DNode <T> getFront(){
		return front.next;
	}

	
	/** DELETION METHODS*/

	/** method that removes and returns the back node of a Double Chain*/
	public DNode <T> deleteBack(){
		DNode <T> back = getBack();
		DNode <T> nextBack = back.prev;
		nextBack.next = front;
		front.prev = nextBack;
		return back;
	}

	/** Method that removes and returns the back node of a DList*/
	public DNode <T> deleteFront(){
		DNode <T> front = getFront();
		DNode <T> nextFront = front.next;
		nextFront.prev = front;
		front.next = nextFront;
		return front;
	}


	
}