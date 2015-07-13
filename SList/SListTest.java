import org.junit.Test;
import static org.junit.Assert.*;


public class SListTest {

	@Test
	public void testOperationsEmpty () {
		
		// tests insertBack
		SList L = new SList();
		L.insertBack(5);
		assertEquals(5, L.getBack());

		L = new SList();
		L.insertFront(99);
		assertEquals(99, L.getFront());
		assertEquals(99, L.getBack());

		assertEquals(1, L.size());
		// tests insertFront
		L.insertFront(6);
		assertEquals(2, L.size());

	}


	@Test
	public void testEmpty (){
		SList L = new SList();
		assertEquals(0, L.size()); 
	}




	@Test
	public void testSize (){
		SList L = new SList(5);
		L.insertFront(6);
		assertEquals(2, L.size());

	}

	@Test
	public void testSizeRecursive(){
		SList L = new SList(5);
		L.insertFront(6);
		L.insertFront(7);
		L.insertFront(8);
		L.insertFront(9);
		L.insertFront(10);
		assertEquals(6, L.size());

	}


	@Test
	public void testGetting (){
		SList L = new SList(5);
		L.insertFront(99);
		assertEquals(99, L.getFront());

		// getBack tests
		L.insertBack(4);
		assertEquals(4, L.getBack());
		L.insertFront(6);
		L.insertFront(7);
		L.insertFront(8);
		L.insertFront(9);
		L.insertFront(10);
		assertEquals(10, L.getFront());
		L.insertBack(1);
		assertEquals(1, L.getBack());	

		//testGetBack with empty list
			/*L = new SList();
			assertEquals(null, L.getBack());
			assertEquals(null, L.getFront());
		*/
	}
	@Test 
	public void testInsert(){
		
		// tests insert position zero
		SList L = new SList(10);
		L.insertBack(9);
		L.insertBack(8);
		L.insertBack(7);
		L.insertBack(6);

		L.insert(11,0);
		assertEquals (11, L.getFront());
		
		//tests insert at the back
		L.insertBack(5);
		assertEquals(5, L.getBack());

		//tests insert at the middle
		L.insert(57, 3 );
		assertEquals (57, L.get(3));

	}

	@Test 
	public void testGet(){
		SList L = new SList(10);
		L.insertBack(9);
		L.insertBack(8);
		L.insertBack(7);
		L.insertBack(6);

		assertEquals(10, L.get(0));
		assertEquals(8, L.get(2));
		assertEquals(6, L.get(4));
	}


	 
	public static void main (String[]  args){
			jh61b.junit.textui.runClasses(SListTest.class);
		}

}