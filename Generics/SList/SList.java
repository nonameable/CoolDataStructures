/** Generics SList (circular), controller of the head and structure of the list.
 * This SList uses a sentinel node to have easier algorithms and more efficent operations.
 * @author David M. Delgado
 */


public class SList <T> {

	// -----------------------------------------------------------------
	// Atributes
	// -----------------------------------------------------------------
	public Node <T> front;
	public int size;

	

	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	public SList(T pElement){
		front = new Node <T>(null, null); // there is a problem with the sentinel, which is not defined until the list is declared.
		front.next  = new Node <T>(pElement, front);
		size = 1;
	}

	public SList(){
		front = new Node <T> (null, null);
		size = 0;
	}

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------


	/** INSERTION METHODS */

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
		p.next  = new Node <T>(pElement, front); // <- new Node at the back.

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
		pNode.next = front;
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
	public void insertElement (T pElement, int position) throws Exception{
		if (! ((position > size) || position < 0) )
		{
			Node <T> p = front;
			// step p along the list until p.next == null, therefore, p is the last item on the list. 
			while (p.next != null) {
					p = p.next;
			}
			p.next = new Node <T>(pElement, null);
		}
		else {
			throw new InvalidPositionException ("The position  to insert is invalid.");
		}
	}


	/** GET METHODS */

	/** get an element item given a position. If position is not valid throws InvalidPositionException */
	public T get (int position)  throws Exception{
		if ((position > size) || (position < 0) ){
			throw new InvalidPositionException ("The position is invalid");
		}
			
		int currentPosition = 0;
		Node <T> p = front;
		while (currentPosition < position){
			p = p.next;
			currentPosition = currentPosition + 1;
		}
		return p.next.element;
	}





	/** gets a node  given a position. If position is not valid throws InvalidPositionException */
	public Node<T> getNode (int position) throws Exception {
		if ((! (position > size)) && (position < 0) ){
			throw new InvalidPositionException ("The position is invalid.");
		}
			
		int currentPosition = 0;
		Node <T> p = front;
		while (currentPosition < position){
			p = p.next;
			currentPosition = currentPosition + 1;
		}
		return p.next;
	}


	

	/** gets the element at the front of the list If position is not valid ? */
	public T getFront() throws Exception{
		if(size > 0)
			return front.next.element; 
		else
			throw new SListEmptyException ("The list is empty, cannot get front element.");
	}

	/** gets the node at the front of the list If position is not valid ? */
	public Node<T> getFrontNode() throws Exception{
		if(size > 0)
			return front.next; 
		else
			throw new SListEmptyException ("The list is empty, cannot get front node.");
	}

	/** gets the element at the back of the list If position is not valid ? */
	public T getBack() throws Exception{  // the problem is, this is doesn't consider an empty list
			
		if (size > 0){
			Node <T> p = front;
			// step p along the list until p.next == null, thereofre, p is the last 
			// item on the list. 

			while (p.next != null) {
					p = p.next;
			}
			return p.element;
		}
		else {
			throw new SListEmptyException ("The list is empty, cannot get back element.");
		}
		
	}

	/** gets the node at the back of the list If position is not valid ? */
	public Node<T> getBackNode() throws Exception{  // the problem is, this is doesn't consider an empty list
		if (size > 0){
			Node <T> p = front;
			// step p along the list until p.next == null, thereofre, p is the last 
			// item on the list. 

			while (p.next != null) {
					p = p.next;
			}
			return p;
		}
		else {
			throw new SListEmptyException ("The list is empty, cannot get back node.");
		}
	}


	/** DELETION METHODS*/
	
	/** This method deletes a Node given a position*/
	public void delete (int position) throws Exception {
		if ((! (position < size)) && (position < 0) ){
			throw new InvalidPositionException ("The position is invalid.");
		}
			
		int currentPosition = 0;
		Node <T> p = front;
		while (currentPosition <= position){
			if(currentPosition == position){
				p.next= p.next.next;
			}else
			{
				p = p.next;
				currentPosition = currentPosition + 1;
			}
			
		}
	}



	



	public int size(){
		return size;
	}








}