/** Node of an DoubleChain (Doubly linked list - circular )
 * @author David M. Delgado, version from lab3 - UCBerkeley
 */
public class DNode {

	// attributes
	double val;
	DNode prev;
	DNode next;

	/** constructor */
	public DNode (double i, DNode pPrev, DNode pNext){
		val = i;
		prev = pPrev;
		next = pNext;
	}
}