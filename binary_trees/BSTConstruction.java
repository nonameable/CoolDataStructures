public class BSTConstruction {

	public BinaryTree constructBinarySearchTree (int[] array){
		// binary traversal
		// add a node to the tree every time we found a new one

		// test cases
		// empty array
		// odd number of elements
		// even number of elements -> tree not completely balanced 
		// 1 element

		//
		// 1 2 3 4 5 6 7
		// 2 4 6 8 10 12
		// 7
		
		// 1 2 3 4 5 6 7
		
               

		BinaryTree bst;
		if(array.length == 0){
			bst = new BinaryTree();
		}
		else if (array.length == 1){
			BinaryNode root = new BinaryNode(array[0]);
			bst = new BinaryTree(root);
		}
		else{
			int start = 0;
			int end = array.length - 1;
			int mid = (start + end)/ 2;
			boolean left = true;
			BinaryNode root = new BinaryNode(array[mid]);
			binaryTraversal(array, start , mid - 1, root, left);
			binaryTraversal(array, mid + 1, end, root, !left);
			bst = new BinaryTree(root);
			
		}

		return bst;
	}

	public void binaryTraversal(int[] array, int start, int end, BinaryNode parent, boolean leftChild){
		
		if(start <= end){
			int mid = (start + end) / 2;
			BinaryNode node = new BinaryNode(array[mid]);
			if(leftChild){
				parent.left = node;
			}
			else {
				parent.right = node;
			}
			binaryTraversal(array, start , mid - 1, node, left);
			binaryTraversal(array, mid + 1, end, node, !left);
		}

		
	}

	public static void main(String[] args) {
		
		BSTConstruction c = new BSTConstruction();
		
		c.constructBinarySearchTree(array);

	}
}