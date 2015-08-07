/** Generics SList , controller of the head and structure of the list.
 * This SList uses a sentinel node to have easier algorithms and more efficent operations.
 * @author David M. Delgado
 */


public class Slist <T> {

	// -----------------------------------------------------------------
	// Atributes
	// -----------------------------------------------------------------
	public Node <T> front;
	public int size;

	

	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	public SList(T pElement){
		front = new Node <T>("Sentinel", null); // there is a problem with the sentinel, which is not defined until the list is declared.
		front.insertNext(new Node <T>(pElement, null));
		size = 1;
	}

	public SList(){
		front = new Node <T> ("Sentinel", null);
		size = 0;
	}

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Inserts a new node with Element in the back of the list */
	public void insertBack(T pElement) {
		// the sentinel nodes guaratees that the fornt is enver going to be null.
		// lets use a reference here
		Node <T>  p = front;
		// step p along the list until p.next == null, thereofre, p is the last item on the list. 
		while (p.next != null) {
			p = p.next;
		}
		// here we know p is the last one and the natural thing to do is simply add to next and replace null
		p.next  = new Node <T>(pElement, null); // <- new Node at the back.

		size++;
	}
	/** Inserts a previously defined Node in back of the list*/
	public void insertNodeBack(Node<T> pNode) {
		// the sentinel nodes guaratees that the fornt is enver going to be null.
		// lets use a reference here
		Node <T> p = front;
		// step p along the list until p.next == null, thereofre, p is the last item on the list. 
		while (p.next != null) {
			p = p.next;
		}
		// here we know p is the last one and the natural thing to do is simply add to next and replace null
		p.next  = pNode; // <- new Node at the back.
		pNode.next = null;
		size++;
	}


	/** Inserts a new node with Element in front of the list*/
	public void insertFront(T pElement) {
		front.next = new Node <T>(pElement, front.next);
		size++;
	}
	/** Inserts a previously defined Node in front of the list*/
	public void insertNodeFront(Node<T> pNode) {
		Node <T> previousHead = front.next;
		front.next = pNode;
		pNode.next = previousHead;
		size++;
	}

	/** inserts an element given a position. If position is not valid ? */
	public void insertElement (T pElement, int position){
		if (! (position < size) || position < 0 )
		{
			Node <T> p = front;
			// step p along the list until p.next == null, therefore, p is the last item on the list. 
			while (p.next != null) {
					p = p.next;
			}
			p.next = new Node <T>(pElement, null);
		}
		else {
			// it should throws and Exception and inform the user.
		}
	}

	/** get an element item given a position. If position is not valid ? */
	public T get (int position) {
		if ((! (position < size)) && (position < 0) ){
			//it should throws an Exception and inform the user.
			return;
		}
			
		int currentPosition = 0;
		Node <T> p = front;
		while (currentPosition < position){
			p = p.next;
			currentPosition = currentPosition + 1;
		}
		return p.next.element;
	}

	/** gets a node  given a position. If position is not valid ? */
	public Node<T> get (int position) {
		if ((! (position < size)) && (position < 0) ){
			//it should throws an Exception and inform the user.
			return;
		}
			
		int currentPosition = 0;
		Node <T> p = front;
		while (currentPosition < position){
			p = p.next;
			currentPosition = currentPosition + 1;
		}
		return p.next;
	}


	public int size(){
		return size;
	}

	/** gets the element at the front of the list If position is not valid ? */
	public T getFront(){
		return front.next.element; // the problem is, this is doesn't consider an empty list
	}

	/** gets the node at the front of the list If position is not valid ? */
	public Node<T> getFront(){
		return front.next; // the problem is, this is doesn't consider an empty list
	}

	/** gets the element at the back of the list If position is not valid ? */
	public T getBack(){  // the problem is, this is doesn't consider an empty list
		Node <T> p = front;
		// step p along the list until p.next == null, thereofre, p is the last 
		// item on the list. 

		while (p.next != null) {
				p = p.next;
		}
		return p.element;
	}

	/** gets the node at the back of the list If position is not valid ? */
	public T getBack(){  // the problem is, this is doesn't consider an empty list
		Node <T> p = front;
		// step p along the list until p.next == null, thereofre, p is the last 
		// item on the list. 

		while (p.next != null) {
				p = p.next;
		}
		return p;
	}




}