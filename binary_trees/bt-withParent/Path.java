import java.util.ArrayList;

/*
* Wrapper class for an ordered collection of binary Nodes that represent a path
*/
public class Path {


	public ArrayList<BinaryNode> path;
	public int partialSum;

	public Path(){
		this.partialSum = 0;
		path = new ArrayList<BinaryNode>();
	}

	public Path(ArrayList<BinaryNode> path){
		this.path = path;
	}

	public void add(BinaryNode node){
		path.add(node);
		partialSum += node.value;
	}

	public void remove(){
		int currentSize = path.size();
		if(currentSize > 0){
			BinaryNode last = path.get(currentSize - 1);
			path.remove(currentSize - 1);
			partialSum -= last.value;
		}
		
	}


	public String toString(){
		String ans = "";
		for (int i = 0; i < path.size() ;i++ ) {
			ans +=  " " + path.get(i).value;
		}
		return ans;
	}

	public void addPathsThatSum(ArrayList<Path> paths, int value){
		int partialSumBackwards = 0;
		for (int i = path.size() - 1; i >= 0 ;i-- ) {
			partialSumBackwards += path.get(i).value;
			if(partialSumBackwards == value){
				Path currentPath = getCopyOfPath(i);
				paths.add(currentPath);
			}
		}
	}


	/*Returns a copy of the path from index to the last node i Path*/
	private Path getCopyOfPath(int index){
		ArrayList<BinaryNode> backwardsPath = new ArrayList<BinaryNode>();
		for (int i = index; i < path.size();i++ ) {
			backwardsPath.add(new BinaryNode(path.get(i)));
		}

		return new Path(backwardsPath);
	} 
}