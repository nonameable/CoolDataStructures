import java.util.ArrayList;

public class Vertex {
	
	/*String id for distinction when testing*/
	public String ID;
	
	/*Each vertex has a list of vertices it shares an edge with. */
	public ArrayList<Vertex> vertices;

	/*color*/
	public String color;
	
	/*time of discovery for DFS*/
	public int time;
	
	/*distance from source in BFS*/
	public int distance;
	
	/*Discovery time for DFS */
	public int d;
	
	/*finishing time for DFS*/
	public int f;

	/*shortest path weight*/
	public int spWeight;

	/*shortest path id for dijkstra arrays*/
	public int id;
	
	/*Parent for BFS. Needed to construct the breath first tree*/
	public Vertex parent;
	
	public Vertex(String ID){
		this.ID = ID;
		vertices = new ArrayList<>();
		this.color = Graph.WHITE;
		this.distance = 0;
		this.parent = null;
	}
	
	public void addConnection(Vertex v){
		if(v != null){
			vertices.add(v);
		}
		
	}
	
	public static void main(String[] args) {

	}

}
