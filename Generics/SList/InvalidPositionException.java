/** Generics SList Exception for an action in an invalid position.
 * This SList uses a sentinel node to have easier algorithms and more efficent operations.
 * @author David M. Delgado
 */

public class InvalidPositionException extends Exception {
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------

	public InvalidPositionException(){
		super();
	}

	public InvalidPositionException (String message){
		super(message);
	}
}
