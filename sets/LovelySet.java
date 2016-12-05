package sets;

import java.util.ArrayList;

public class LovelySet {
	
	public ArrayList<Integer>  set;
	
	public LovelySet(){
		set = new ArrayList<Integer>();
	}
	
	public LovelySet(ArrayList<Integer> set){
		this.set = set;
	}
	
	public void add(Integer i){
		set.add(i);
	}
	
	public LovelySet lovelySetPLusElement (Integer element){
		ArrayList newSet = new ArrayList<>(set);
		newSet.add(element);
		return new LovelySet(newSet);
		
	}
	
} 
