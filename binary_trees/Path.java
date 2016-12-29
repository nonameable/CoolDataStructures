import java.util.ArrayList;

/*
* Wrapper class for an ordered collection of binary Nodes that represent a path
*/
public class Path {


	public ArrayList<BinaryNode> path;
	public partialSum;

	public Path(){
		this.partialSum = 0;
		path = new ArrayList<BinaryNode>();
	}

	public add(BinaryNode node){
		path.add(node);
		partialSum += node.value;
	}

	public remove(){
		int currentSize = path.size();
		if(currentSize > 0){
			BinaryNode last = path.get(currentSize - 1);
			path.remove(currentSize - 1);
			partialSum -= last.value;
		}
		
	}
}