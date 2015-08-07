/** Array based list.
 *  @author David Mauricio Delgado Ruiz based on Josh Hug Hard mode
 */

public class AList {
    /** Invariants:
    * 1. The next item to be inserted goes into position size.
    * 2. The last item in the list is in position size -1;
    * 3. There are size items in the list.
    * 4. The ith element is in position ith.
    */


    private int[] items;
    private int size;

    /** resize imtes to be capacity C and does the copying for you. */
    private void resize(int x) {
        int[] newItems = new int[c];
        for (int i = 0;i < items.length ; i+= 1) {
            newItems[i] = items[i];
        }
        items = newItems;
    } 



    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void insertBack(int x) {
        items[size] = x;
        size += 1; 
    }

    /** Returns the item from the back of the list. */
    public int getBack() {
        return items[size -1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        
        return items[i];        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int deleteBack() {
        int previoudBack = getBack();
        size = size - 1;
        return previoudBack;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }
} 