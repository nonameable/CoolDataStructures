import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the MaxSList class.
 *  @author David Mauricio Delgado Ruiz -  based on Josh Hug implementation -UC Berkeley
 */

public class TestMaxSList {
  
	@Test
	public void testConstructorNoArguments (){
		MaxSList msl  = new MaxSList();
    	msl.insertFront(100);
    	msl.insertBack(99);
    	assertEquals (100, msl.getFront());
    	assertEquals (99, msl.getBack());
	}

	@Test 
	public void testConstructorArguments (){
		MaxSList mslWithArguments  = new MaxSList(45);
    	mslWithArguments.insertBack(99);
    	assertEquals (45, mslWithArguments.getFront());
    	assertEquals (99, mslWithArguments.getBack());

	}


	@Test
    public void testInserts() {
        MaxSList L = new MaxSList(10);
        L.insertFront(50);
        assertEquals(50, L.getFront());

        L.insertBack(99);
        assertEquals(50, L.getFront());
        assertEquals(99, L.getBack());
    }

    @Test
    public void testSize() {
        MaxSList L = new MaxSList(10);
        L.insertFront(50);
        L.insertBack(99);
        assertEquals(3, L.size());
    }

    @Test
    public void testEmptySize() {
        MaxSList L = new MaxSList();
        L.insertBack(99);
        L.insertFront(50);
        assertEquals(2, L.size());
        assertEquals(50, L.getFront());
    }

	@Test
	public void testMax(){
		MaxSList L = new MaxSList(23);
		assertEquals(23, L.max());


		
        L.insertBack(99);
        L.insertFront(50);
        assertEquals(99, L.max());
	}





	public static void main (String[] args) {
  		jh61b.junit.textui.runClasses(TestMaxSList.class); 
  	}	  
} 