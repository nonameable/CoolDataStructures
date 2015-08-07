/** Node of an SList, generics version.
 * @author David M. Delgado
 */
public class Node <T>{
	
	// -----------------------------------------------------------------
	// Atributes
	// -----------------------------------------------------------------
	public T element;
	public Node next;

	

	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	public IntNode (T pElement, Node pNext) {
		element  = pElement;
		next = pNext;
	}
	
	


}