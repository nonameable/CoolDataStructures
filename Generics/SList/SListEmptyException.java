/** Generics SList Exception for an empty list.
 * This SList uses a sentinel node to have easier algorithms and more efficent operations.
 * @author David M. Delgado
 */

public class SListEmptyException extends Exception {
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------

	public SListEmptyException(){
		super();
	}

	public SListEmptyException (String message){
		super(message);
	}
}
