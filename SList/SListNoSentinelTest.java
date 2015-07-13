import org.junit.Test;
import static org.junit.Assert.*;


public class SListNoSentinelTest {

	@Test
	public void testOperationsEmpty () {
		
		// tests insertBack
		SListNoSentinel L = new SListNoSentinel();
		L.insertBack(5);
		assertEquals(1, L.size());
		// tests insertFront
		L.insertFront(6);
		assertEquals(2, L.size());

	}


	@Test
	public void testEmpty (){
		SListNoSentinel L = new SListNoSentinel();
		assertEquals(0, L.size()); 
	}




	@Test
	public void testSize (){
		SListNoSentinel L = new SListNoSentinel(5);
		L.insertFront(6);
		assertEquals(2, L.size());

	}

	@Test
	public void testSizeRecursive(){
		SListNoSentinel L = new SListNoSentinel(5);
		L.insertFront(6);
		L.insertFront(7);
		L.insertFront(8);
		L.insertFront(9);
		L.insertFront(10);
		assertEquals(6, L.size());

	}

	public static void main (String[]  args){
			jh61b.junit.textui.runClasses(SListNoSentinelTest.class);
		}

}