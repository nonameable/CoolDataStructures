package traverse;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class BinaryTree {

	private BinaryNode root;
	private boolean nodeFound = false;

	public BinaryTree(BinaryNode root) {
		this.root = root;
	}

	public ArrayList<Integer> preOrderTraversal() {
		ArrayList<Integer> list = new ArrayList<>();
		preOrderTraversalHelper(root, list);
		return list;

	}

	private void preOrderTraversalHelper(BinaryNode node,
			ArrayList<Integer> list) {
		list.add(node.value);
		if (!node.isLeaf()) {
			if (node.leftChild != null) {
				preOrderTraversalHelper(node.leftChild, list);
			}
			if (node.rightChild != null) {
				preOrderTraversalHelper(node.rightChild, list);
			}
		}
	}

	public ArrayList<Integer> inOrderTraversal() {
		ArrayList<Integer> list = new ArrayList<>();
		inOrderTraversalHelper(root, list);
		return list;
	};

	private void inOrderTraversalHelper(BinaryNode node,
			ArrayList<Integer> list) {
		if (node.leftChild != null) {
			inOrderTraversalHelper(node.leftChild, list);
		}
		list.add(node.value);

		if (node.rightChild != null) {
			inOrderTraversalHelper(node.rightChild, list);
		}

	}

	public ArrayList<Integer> postOrderTraversal() {
		ArrayList<Integer> list = new ArrayList<>();
		postOrderTraversalHelper(root, list);
		return list;
	};

	private void postOrderTraversalHelper(BinaryNode node,
			ArrayList<Integer> list) {

		if (node.leftChild != null) {
			postOrderTraversalHelper(node.leftChild, list);
		}
		if (node.rightChild != null) {
			postOrderTraversalHelper(node.rightChild, list);
		}
		list.add(node.value);

	}

	public ArrayList<Integer> pathToNode(Integer nodeValue) {
		ArrayList<Integer> path = new ArrayList<>();
		boolean found = false;
		pathToNodeHelper(root, path, nodeValue);
		nodeFound = false;
		return path;
	}

	private void pathToNodeHelper(BinaryNode node, ArrayList<Integer> path,
			Integer destinyNodeValue) {

		path.add(node.value);
		if (node.value.equals(destinyNodeValue)) {
			nodeFound = true;
			// exits method
		} else {
			if (node.leftChild != null) {
				pathToNodeHelper(node.leftChild, path, destinyNodeValue);
				if (nodeFound == false) {

					if (node.rightChild != null) {
						pathToNodeHelper(node.rightChild, path, destinyNodeValue);

					}

				}

			}
			if (nodeFound == false) {
				path.remove(path.size() - 1);

			}

		}

	}

	private Integer firstCommonAncestorBetween(Integer nodeA, Integer nodeB) {

		Integer commonAncestor = null;
		// find a path to nodeA
		ArrayList<Integer> pathToA = pathToNode(nodeA);
		// find a path to nodeB
		ArrayList<Integer> pathToB = pathToNode(nodeB);

		// Move through resulting arraylists looking for common ancestors
		boolean found = false;
		int i = pathToA.size() - 1;
		int j = pathToB.size() - 1;

		while (!found && i > 0 && j > 0) {
			if (pathToA.get(i).equals(pathToB.get(j))) {
				found = true;
				commonAncestor = pathToA.get(i);
			} else if (pathToA.get(i) < pathToB.get(j)) {
				j--;
			} else {
				i--;
			}

		}

		return commonAncestor;

	}

	public int height(BinaryNode root) {
		int height = -1;
		height = heightHelper(root);

		return height;

	}

	private int heightHelper(BinaryNode node) {
		int heightLeft = 0;
		int heightRight = 0;

		if (node.isLeaf()) {
			return 1;
		} else {
			if (node.leftChild != null) {
				heightLeft = heightHelper(node.leftChild);
			}

			if (node.rightChild != null) {
				heightRight = heightHelper(node.rightChild);
			}

			int maxHeight = Math.max(heightLeft, heightRight);

			return maxHeight + 1;
		}

	}

	public boolean isBalanced(BinaryNode root) {
		Balance balance = isBalancedHelper(root);
		return balance.isBalanced;
	}

	private Balance isBalancedHelper(BinaryNode node) {
		
		Balance myBalance;
		Balance leftBalance = null;
		Balance rightBalance = null;
		boolean balanced = true;
		
		int height;
		int leftHeight = 0;
		int rightHeight = 0;
		
		if(node.isLeaf()){
			myBalance =new Balance(1, true);
		}
		else {
			if (node.leftChild != null) {
				leftBalance = isBalancedHelper(node.leftChild);
				balanced = leftBalance.isBalanced;
				leftHeight = leftBalance.height;
			}
			if (node.rightChild != null) {
				rightBalance = isBalancedHelper(node.rightChild);
				balanced = rightBalance.isBalanced;
				rightHeight = rightBalance.height;
			}
			
			int difference = Math.abs(rightHeight - leftHeight);
			balanced = balanced && (difference <= 1);
			
			height = Math.max(rightHeight,leftHeight);
			myBalance = new Balance(height + 1, balanced);
			
		}
		return myBalance;
	}

	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1);
		root.leftChild = new BinaryNode(2);
		root.rightChild = new BinaryNode(5);
		root.leftChild.leftChild = new BinaryNode(3);
		root.leftChild.rightChild = new BinaryNode(4);
		root.rightChild.leftChild = new BinaryNode(6);
		root.rightChild.rightChild = new BinaryNode(7);
		BinaryTree b = new BinaryTree(root);

		// testing
		ArrayList<Integer> preOrder = b.preOrderTraversal();
		System.out.println("Preorder is: " + preOrder.toString());

		ArrayList<Integer> inOrder = b.inOrderTraversal();
		System.out.println("Inorder is: " + inOrder.toString());

		ArrayList<Integer> postOrder = b.postOrderTraversal();
		System.out.println("Postorder is: " + postOrder.toString());

		System.out.println("--------------------------------------");

		System.out.println("TESTS FOR HEIGHT");
		System.out.println(b.height(root));
		System.out.println("TESTS FOR HEIGHT");

		System.out.println("TESTS FOR Balanced");
		System.out.println(b.isBalanced(root));
		System.out.println("TESTS FOR Balanced");

		// extention for finding first common ancestor
		root.rightChild.rightChild.leftChild = new BinaryNode(8);
		root.rightChild.rightChild.rightChild = new BinaryNode(9);
		root.rightChild.rightChild.rightChild.leftChild = new BinaryNode(10);

		System.out.println("TESTS FOR HEIGHT extended");
		System.out.println(b.height(root));
		System.out.println("TESTS FOR HEIGHT extended ");

		System.out.println("TESTS FOR Balanced extended");
		System.out.println(b.isBalanced(root));
		System.out.println("TESTS FOR Balanced extended");

		// testing path to node
		ArrayList<Integer> pathTo8 = b.pathToNode(8);
		System.out.println("Path to node 8 is: " + pathTo8.toString());

		ArrayList<Integer> pathTo6 = b.pathToNode(6);
		System.out.println("Path to node 6 is: " + pathTo6.toString());

		Integer nodeA = 8;
		Integer nodeB = 6;
		Integer commonAncestor = b.firstCommonAncestorBetween(nodeA, nodeB);

		System.out.println("Common ancestor between " + nodeA + " and " + nodeB
				+ " is " + commonAncestor);

	}

}
