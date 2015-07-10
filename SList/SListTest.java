import org.junit.Test;
import static org.junit.Assert.*;


public class SListTest {

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

	public static void main (String[]  args){
			jh61b.junit.textui.runClasses(SListTest.class);
		}

}