/*
* This class serves as a wrapper object for Node Index when searching or doing other operationsß
*/
public class NodeIndex{
	int index;
	Node node;
	Node previous;

	public NodeIndex(int index, Node node, Node previous){
		this.index = index;
		this.node = node;
		this.previous = previous;
	}
	
}