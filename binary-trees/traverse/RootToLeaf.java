package traverse;

import java.util.ArrayList;


public class RootToLeaf {
	
	public static ArrayList<ArrayList<Integer>> getAllRootToLeafPaths (BinaryNode root){
		
		// it will begin at the root
		//from the beginning, it is going to have a reference to the list of all paths
		// Also, from the beginning, it is going to have a reference to a temp list for storing the path up until that node
		// it will traverse the tree, first trying to go left, then right
		// when it reaches any node, it will add its value to the temp list
		// when it reaches a leaf node, it adds a new path to the list of paths, which will be up to this point contained in the temp list
		// when it ends, either because is a leaf node or it has already checked all its children, it will delete itsel from the temp list and return
		
		ArrayList<ArrayList<Integer> > allPaths = new ArrayList<>();
		ArrayList<Integer> tempPath = new ArrayList<>();
		
		getPathsToLeaf(root, allPaths, tempPath);
		return allPaths;
	}
	
	
	private static void getPathsToLeaf (BinaryNode n, ArrayList<ArrayList<Integer>>  allPaths, ArrayList<Integer> tempPath){
		tempPath.add(n.value);
		if(n.isLeaf()){
			//makes a copy of temPath and adds it to allpaths
			ArrayList<Integer> newPath = new ArrayList<Integer>(tempPath);
			
			//adds it to the allPaths list
			allPaths.add(newPath);
		}
		else {
			
		}
		// we delete 
		tempPath.remove(tempPath.size() - 1);
		
		
		
		
		if(n.isMarked()){
		}
		if(n.isLeaf()){
			//path.add(n.value);
			n.mark();
		}
		// we go first for the left child path
		if(n.leftChild!= null && !n.leftChild.isMarked()){
			
		}
		
		
	}
	

	public static void main(String[] args) {

		// Build three to test code
		BinaryNode root = new BinaryNode(1);
		root.leftChild = new BinaryNode(2);
		root.rightChild = new BinaryNode(5);
		root.leftChild.leftChild = new BinaryNode(3);
		root.leftChild.rightChild = new BinaryNode(4);
		root.rightChild.leftChild = new BinaryNode(6);
		root.rightChild.rightChild = new BinaryNode(7);
		
		//test the method. Should print 1,2,3   1,2,4   1,5,6    1,5,7
		ArrayList<ArrayList<Integer>> allPaths = RootToLeaf.getAllRootToLeafPaths(root);
		
		
		
		
	}

}


