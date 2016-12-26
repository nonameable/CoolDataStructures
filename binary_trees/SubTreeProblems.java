import java.util.ArrayList;

public class SubTreeProblems {


	public static void main(String[] args) {
		
		System.out.println("----------- Testing the new constructor that clones a tree");
		
		BinaryNode root = new BinaryNode(1);
		root.leftChild = new BinaryNode(2);
		root.rightChild = new BinaryNode(5);
		root.leftChild.leftChild = new BinaryNode(3);
		root.leftChild.rightChild = new BinaryNode(4);
		root.rightChild.leftChild = new BinaryNode(6);
		root.rightChild.rightChild = new BinaryNode(7);
		BinaryTree tree = new BinaryTree(root);

		ArrayList<Integer> preOrder = tree.preOrderTraversal();
		System.out.println("Preorder is: " + preOrder.toString());

		ArrayList<Integer> inOrder = tree.inOrderTraversal();
		System.out.println("Inorder is: " + inOrder.toString());

		System.out.println("Now we apply the cloning into a new Tree");

		BinaryTree newTree = new BinaryTree(root);

		preOrder = newTree.preOrderTraversal();
		System.out.println("Preorder is: " + preOrder.toString());

		inOrder = newTree.inOrderTraversal();
		System.out.println("Inorder is: " + inOrder.toString());



		System.out.println("----------- END    Testing the new constructor that clones a tree");

		BinaryNode rootForSubTree = new BinaryNode(2);
		rootForSubTree.leftChild = new BinaryNode(3);
		rootForSubTree.rightChild = new BinaryNode(4);
		BinaryTree smallTree = new BinaryTree(rootForSubTree);


	}


	public static boolean isSubTree(BinaryTree bigTree, BinaryTree smallTree){
		// do a bfs of the bigsubtree looking for the root
		// when found do a bfs of both but keeping a reference to the original one to go back if they are different
		// if they are the same, we are done.
		// if not, continue
		// stop when we are done either by founding that it is a subtree or traversing the bigtree without funding anything
		
		isSubTree = false;
		if(smallTree.root == null){
			isSubTree =  true;
		}
		else {
			boolean foundAnswer = false;
			int rootValue = smallTree.root.value;
			Queue q = new Queue();
			q.enqueue(bigtree.root);
			while(q.isEmpty() && !foundAnswer){
				BinaryNode n = q.deque();
				if(n.value == rootValue){
					isSubTree = areSameTree(smallTree.root, n);
					foundAnswer = isSubTree;

				}
				else{
					q.enqueue(n.leftChild);
					q.enqueue(n.rightChild);
				}
			}
		}

		return isSubTree;
		



	}

	public static boolean areSameTree(BinaryNode tree1, BinaryNode tree2){
		ArrayList<Integer> preOrderTree1 = tree1.preOrderTraversal();
		ArrayList<Integer> preOrderTree2 = tree2.preOrderTraversal();

	

		for (int i = 0; i < ; ) {
			
		}
		
	}
}