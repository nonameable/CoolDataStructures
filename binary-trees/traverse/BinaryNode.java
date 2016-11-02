package traverse;

public class BinaryNode {
	
	public BinaryNode leftChild;
	public BinaryNode rightChild;
	public Integer value;
	private Boolean marked;
	
	public BinaryNode(int value){
		this.value = value;
		this.marked = false;
	}
	
	public void mark(){
		marked = true;
	}
	
	public boolean isLeaf(){
		return (leftChild == null) && (rightChild == null);
	}
	
	public boolean isMarked(){
		return marked;
	}
}
