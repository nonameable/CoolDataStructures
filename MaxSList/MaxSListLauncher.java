/** 
 *  @author David Mauricio Delgado Ruiz -  based on Josh Hug implementation -UC Berkeley
 */

/* MaxSList launcher that you can experiment with. */
public class MaxSListLauncher { 
    
	public static void main (String[] args){
		MaxSList msl = new MaxSList(100);
		msl.insertBack(10);
		SList sl = msl;
		msl.insertFront(1000);
		System.out.println(msl.max());

		MaxSList msl10 = (MaxSList) sl;
		System.out.println(msl10.max());

	}
    

} 