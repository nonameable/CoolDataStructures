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
	public Node (T pElement, Node <T> pNext) {
		element  = pElement;
		next = pNext;
	}
	
	


}