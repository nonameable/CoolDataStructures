public class Node {
	
	Node next;
	
	int value;
	
	public Node(int value, Node next){
		this.value = value;
		this.next = next;
	}
	
	public Node(int value){
		this.value = value;
		this.next = null;
	}
	
	public void appendToTail(Node node){
		if(node != null){
			next = node;
		}
	}

}
