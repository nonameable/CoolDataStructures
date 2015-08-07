/** 
 *  @author David Mauricio Delgado Ruiz -  based on Josh Hug implementation -UC Berkeley
 */

/* extends means 'is-a' */
/*   -- MaxSList automatically has ALL methods and fields of SList. 
 *      does not include constructors. */
public class MaxSList extends SList {

    private int max = -Integer.MIN_VALUE;
    
    /* EVERY CONSTRUCTOR IN A SUBCLASS MUST BEIGIN WITH A CALL TO A SUPERCLASS CONSTRUCTOR*/
    public MaxSList (){
        super();
    }

    
    public MaxSList (int x){
        super(x);
        max = x;
    }

    @Override
    public void insertBack(int x){
        super.insertBack(x);
        if (x > max)
            max = x;
    }

    @Override
    public void insertFront(int x){
        super.insertFront(x);
        if (x > max)
            max = x;

    }

    public int max (){
        return max;
    }

}