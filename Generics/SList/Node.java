/** Node of an SList, generics version.
 * @author David M. Delgado
 */
public class Node <T>{
	
	// -----------------------------------------------------------------
	// Atributes
	// -----------------------------------------------------------------
	public T element;
	public Node <T> next;

	

	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	public IntNode (T pElement, Node <T> pNext) {
		element  = pElement;
		next = pNext;
	}
	
	


}