import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the AList class.
 *  @author David Mauricio Delgado Ruiz based on Josh Hug Hard mode
 */

public class AListTest {
    @Test
    public void testEmptySize() {
        AList L = new AList();
        assertEquals(0, L.size());
    }

    @Test
    public void testInsertAndSize() {
        AList L = new AList();
        L.insertBack(99);
        L.insertBack(99);
        assertEquals(2, L.size());
    }

    
    @Test
    public void testInsertAndGet() {
        AList L = new AList();
        L.insertBack(99);
        L.insertBack(99);
        assertEquals(99, L.getBack());
         L.insertBack(30);
        assertEquals(30, L.getBack());
        assertEquals(30, L.get(2));
        assertEquals(99, L.get(0));
    }

    @Test
    public void testDeleteBack() {
        AList L = new AList();
        L.insertBack(99);
        L.insertBack(100);
        L.insertBack(101);
        L.deleteBack();
        assertEquals(100, L.getBack());
        L.deleteBack();
        assertEquals(99, L.getBack());
        L.deleteBack();
        // apperantly, I cannot get the back in this case, array index out of bounds exception
        assertEquals(0 ,L.size() );


    }

    /** Tests insertion of a large number of items.*/
    /*@Test
    public void testMegaInsert() {
    }*/

    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(AListTest.class);
    }
} 