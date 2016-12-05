package sets;

import java.util.ArrayList;

public class SetProblems {

	public ArrayList<LovelySet> givePowerSet(int[] array){
		ArrayList<LovelySet> powerSet = new ArrayList<>();
		powerSet.add(new LovelySet());
		for(int i = 0; i< array.length;i++){
			int currentpowerSetSize = powerSet.size();
			for(int j = 0; j < currentpowerSetSize; j++){
				LovelySet current = powerSet.get(j);
				powerSet.add(current.lovelySetPLusElement(array[i]));
			}
		}
		return powerSet;
	}
	
	public static void main(String[] args) {
		int[] N = {1,2,3,4,5,6,7};
		SetProblems sp = new SetProblems();
		ArrayList<LovelySet> powerSetofN = sp.givePowerSet(N);
		System.out.println("size of power set is: " + powerSetofN.size());
		for (int i = 0; i < powerSetofN.size(); i++) {
			LovelySet current = powerSetofN.get(i);
			System.out.println(current.set);
		}
		
	}

}
