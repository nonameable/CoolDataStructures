package traverse;

import java.util.ArrayList;

public class BinaryTree {
	
	private BinaryNode root;
	
	public BinaryTree(BinaryNode root){
		this.root = root;
	}
	
	public ArrayList<Integer> preOrderTraversal(){
		ArrayList<Integer> list = new ArrayList<>();
		preOrderTraversalHelper(root, list);
		return list;
		
	}
	
	private void preOrderTraversalHelper(BinaryNode node, ArrayList<Integer> list) {
		list.add(node.value);
		if(!node.isLeaf()){
			if(node.leftChild != null){
				preOrderTraversalHelper(node.leftChild, list);
			}
			if(node.rightChild != null){
				preOrderTraversalHelper(node.rightChild, list);
			}
		}
	}

	public ArrayList<Integer> inOrderTraversal(){
		ArrayList<Integer> list = new ArrayList<>();
		inOrderTraversalHelper(root, list);
		return list;
	};

	private void inOrderTraversalHelper(BinaryNode node,
			ArrayList<Integer> list) {
		if(node.leftChild != null){
			inOrderTraversalHelper(node.leftChild, list);
		}
		list.add(node.value);
	
		if(node.rightChild != null){
			inOrderTraversalHelper(node.rightChild, list);
		}
		
	}

	public ArrayList<Integer> postOrderTraversal(){
		ArrayList<Integer> list = new ArrayList<>();
		postOrderTraversalHelper(root, list);
		return list;
	};
	
	private void postOrderTraversalHelper(BinaryNode node,
			ArrayList<Integer> list) {
		
		if(node.leftChild != null){
			postOrderTraversalHelper(node.leftChild, list);
		}
		if(node.rightChild != null){
			postOrderTraversalHelper(node.rightChild, list);
		}
		list.add(node.value);
		
	}

	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1);
		root.leftChild = new BinaryNode(2);
		root.rightChild = new BinaryNode(5);
		root.leftChild.leftChild = new BinaryNode(3);
		root.leftChild.rightChild = new BinaryNode(4);
		root.rightChild.leftChild = new BinaryNode(6);
		root.rightChild.rightChild = new BinaryNode(7);
		BinaryTree b= new BinaryTree(root);
		
		// testing
		ArrayList<Integer> preOrder = b.preOrderTraversal();
		System.out.println("Preorder is: " + preOrder.toString());
		
		ArrayList<Integer> inOrder = b.inOrderTraversal();
		System.out.println("Inorder is: " + inOrder.toString());
		
		ArrayList<Integer> postOrder = b.postOrderTraversal();
		System.out.println("Postorder is: " + postOrder.toString());
		
	}

}
