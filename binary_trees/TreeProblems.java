public class TreeProblems {
	

	/* solves 4.9 when paths start anywhere and end anywhere*/
	public static ArrayList< Path > pathsThatSum(BinaryTree tree, int value){


	}
	/* Solves 4.9 when paths start at the root and end anywhere*/
	public static ArrayList< Path > pathsThatSumFromRoot(BinaryTree tree,  int value){ 
		ArrayList<Path > pathsThatSum = new ArrayList< Path >();
		Path path = new Path();
		pathsThatSumHelper(tree.getRoot(), value, pathsThatSum, path);
		return pathsThatSum;
	}

	private static void pathsThatSumHelper(BinaryNode node, int value, ArrayList< Path > pathsThatSum , Path path){
		if(node != null){
			path.add(node);
			if(path.partialSum == value){
				pathsThatSum.add(new Path(path));
			}
			pathsThatSumHelper(node.leftChild, value, pathsThatSum, path);
			pathsThatSumHelper(node.rightChild, value, pathsThatSum, path);

			path.remove();
		}
	}

	public static BinaryNode findSuccesorInBST(BinaryTree tree, int value){

		BinaryNode succesor = null;
		BinaryNode node = findNode(value);
		if(node != null){

			succesor = findLeftMostNode(node.rightChild);
			if(succesor == null){
				succesor = findSuccesorInParents(node.parent);
			}

		}
		
		return succesor;



	}

	public static findLeftMostNode(BinaryNode node){
		BinaryNode n = node;
		while(n != null && n.left != null){
			n = n.left;
			}
		}
		return n;
	}

	public static BinaryNode findNode(BinaryTree tree, int value){
		BinaryNode node = null;

		BinaryNode n = tree.getRoot();
		boolean done = false;
		while(!done && n != null){
			if(n.value == value){
				node = n;
				done = true;
			}
			else if(n.value > value){
				n = n.leftChild;
			}
			else{
				n = n.rightChild;
			}
		}

		return node;

	}
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(16);
		root.leftChild = new BinaryNode(7);
		root.rightChild = new BinaryNode(26);
		root.leftChild.leftChild = new BinaryNode(4);
		root.leftChild.rightChild = new BinaryNode(13);
		root.rightChild.leftChild = new BinaryNode(20);
		root.rightChild.rightChild = new BinaryNode(30);
		BinaryTree b = new BinaryTree(root);

		System.out.println("-------------- testing find node ---------------");

		BinaryNode node  = findNode(b, 4);
		System.out.println("Value of node found is: " + node.value);

		node = findNode(b,18);
		System.out.println("Value of node found is: " + node);

		System.out.println("-------------- END testing find node -----------");



	}
}