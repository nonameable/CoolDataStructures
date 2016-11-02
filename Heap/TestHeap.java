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

    private void setupCustomConstructor()
    {
      try
      {
        heap = new Heap(25);
      }
      catch (Exception e)
      {
        e.printStackTrace( );
      }
    }

    public void testDefaultConstructor(){
      setupDefaultConstructor();
      assertEquals(10, heap.size());
    }

    public void testCustomConstructor(){
      setupCustomConstructor();
      assertEquals(25, heap.size());
    }

    public void testInitialization(){
      setupCustomConstructor();
      heap.add(5);
      //ArrayList<Integer> heapAsList = heap.toList();
    }

    public v

}
