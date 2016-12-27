import java.util.ArrayList;

public class BinaryTree {

	private BinaryNode root;

	public BinaryTree() {

	}

	public BinaryTree(BinaryNode root) {
		this.root = root;
	}

	public ArrayList<Path> pathsThatSum(int value){
		Path path = new Path();
		ArrayList<Path> paths = new ArrayList<Path>();
		pathsThatSumHelper(root, paths, path, value);
		return paths;
	}

	public void pathsThatSumHelper(BinaryNode node, ArrayList<Path> paths, Path path, int value){
		if(node != null){
			path.add(node);
			path.addPathsThatSum(paths, value);
			if(node.leftChild !=  null){
				pathsThatSumHelper(node.leftChild, paths, path, value);
			}

			if(node.rightChild != null){
				pathsThatSumHelper(node.rightChild, paths, path, value);
			}
			
			path.remove(); // this removes node from the path
		}

	}


	

	public static void main(String[] args) {
		
		// we create a tree with references to their parent nodes
		BinaryNode root = new BinaryNode(1);
		root.parent = null;

		root.leftChild = new BinaryNode(2);
		root.rightChild = new BinaryNode(5);
		root.leftChild.parent = root;
		root.rightChild.parent = root;

		root.leftChild.leftChild = new BinaryNode(3);
		root.leftChild.leftChild.parent = root.leftChild;


		root.leftChild.rightChild = new BinaryNode(4);
		root.leftChild.rightChild.parent = root.leftChild;


		root.rightChild.leftChild = new BinaryNode(6);
		root.rightChild.leftChild.parent = root.rightChild;

		root.rightChild.rightChild = new BinaryNode(7);
		root.rightChild.rightChild.parent = root.rightChild;

		BinaryTree b = new BinaryTree(root);

		ArrayList<Path> pathsThatSum = b.pathsThatSum(11);
		for(int i = 0; i < pathsThatSum.size(); i++){
			System.out.println(pathsThatSum.get(i).toString());
		}

		
		
	}

}
