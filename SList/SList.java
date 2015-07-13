
/** SList , controller of the head and structure of the list.
 * @author David M. Delgado, version of the SList by Josh Hug, UCBerkeley
 */
public class SList {

	//atributes
	public IntNode front; //actually, the head
	public int size;

	// constructor
	public SList (int x) {
		front =  new IntNode(43534252, null); // sentiel node
		front.next = new IntNode(x, null);
		size = 1;
	}

	public SList (){
		front =  new IntNode(43534252, null); // sentiel node
		size = 0;
	}

	public void insertBack (int x){

		// the sentinel nodes guaratees that the fornt is enver going to be null.
		// lets use a pointer here
		IntNode p = front;
		// step p along the list until p.next == null, thereofre, p is the last 
		// item on the list. 

		while (p.next != null) {
			p = p.next;
		}
		// here we know p is the last one and the natural thing to do is simply add to next and replace null
		p.next = new IntNode(x, null); // <- new IntNode at the back.

		// add +1 to the size attribute
		size++;

	}

	public void insertFront(int x) {
		front.next = new IntNode(x, front.next);
		
		// add +1 to the size attribute
		size++;

	}

	/** inserts an intnode given a position. If position is not valid, it inserts it at the end of the list. 
	* exercise from discussion 3. 
	*/
	public void insert (int value, int position){
		if (! (position < size) || position < 0 )
		{
			IntNode p = front;
			// step p along the list until p.next == null, thereofre, p is the last 
			// item on the list. 

			while (p.next != null) {
					p = p.next;
			}
			p.next = new IntNode(value, null);
		}
		else {
			int currentPosition = 0;
			IntNode p = front;

			while (p.next != null && currentPosition < size && currentPosition < position) {
				p = p.next;
				currentPosition  = currentPosition + 1;
			}

			p.next = new IntNode (value, p.next);

		}


	}
	
	/** get an intnode item given a position. If position is not valid, returns -1. */
	public int get (int position) {
		if ((! (position < size)) && (position < 0) )
			return -1;
		int currentPosition = 0;
		IntNode p = front;
		while (currentPosition < position){
			p = p.next;
			currentPosition = currentPosition + 1;
		}
		return p.next.
		item;
	}

	public int size(){
		return size;
	}

	public int getFront(){
		return front.next.item; // the problem is, this is doesn't consider an empty list
	}
	public int getBack(){
		IntNode p = front;
		// step p along the list until p.next == null, thereofre, p is the last 
		// item on the list. 

		while (p.next != null) {
				p = p.next;
		}
		return p.item;

	}


}