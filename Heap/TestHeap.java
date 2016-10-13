import junit.framework.TestCase;
//import static org.junit.Assert.*;

//import org.junit.Test;

/** Perform tests of the Heap class
 */

public class TestHeap extends TestCase{

    Heap heap;

    /**
     * Prepares an escenario with the default constructor case
     */
    private void setupDefaultConstructor( )
    {
        try
        {
            heap = new Heap( );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

    public void testDefaultConstructor(){
      setupDefaultConstructor();
      assertEquals(10, heap.size());
    }

}
