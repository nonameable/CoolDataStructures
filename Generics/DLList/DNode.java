/** Node of an DoubleChain (Doubly linked list - circular ) Java Generics Version
 * @author David M. Delgado 
 */
public class DNode <T>{

	// -----------------------------------------------------------------
	// Atributes
	// -----------------------------------------------------------------
	public T element;
	public DNode <T> prev;
	public DNode <T> next;

	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	public DNode (T pElement, DNode <T> pPrev, DNode <T> pNext){
		element = pElement;
		prev = pPrev;
		next = pNext;
	}
}