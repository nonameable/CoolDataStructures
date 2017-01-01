import java.util.PriorityQueue;
import java.util.Arrays;

public class GraphAlgorithms {

	public int[] dijkstra(Graph g, Vertex source){
		int[] predecesor = new int[g.vertices.size()];
		VertexSPComparator comparator = new VertexSPComparator();
		PriorityQueue <Vertex> pq = new PriorityQueue<Vertex>(100, comparator);

		//preconditions
		for(int i = 0; i < g.vertices.size(); i++){
			Vertex v = g.vertices.get(i);
			v.id = i;
			predecesor[i] = -1;
			pq.add(v);
			if(v == source){
				v.spWeight = 0;
			} else {
				v.spWeight = Integer.MAX_VALUE;
			}
		}

		while(pq.peek() != null){
			Vertex v = pq.poll();
			relax(g, v, predecesor);
		}
		return predecesor;

	}

	public void relax( Graph g, Vertex u, int[] predecesor){
		
		for (int i = 0;i < u.vertices.size() ;i++ ) {
			Vertex v = u.vertices.get(i);
			Edge e = getEdge(u, v, g);
			if(u.spWeight + e.weight < v.spWeight){
				predecesor[v.id] = u.id;
				v.spWeight = u.spWeight + e.weight;
			}
		}
	}

	/*retrieves edge that goes from u to v
	* This is done in linear time. It could be better if implemented with a hashtable (That would complicate things a little bit more)
	*/

	private Edge getEdge(Vertex u, Vertex v, Graph g){
		for (int i = 0; i < g.edges.size() ;i++ ) {
			Edge e = g.edges.get(i);
			if(e.v1 == u && e.v2 == v){
				return e;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		
		// graph for testing
		Vertex s = new Vertex("s");
		Vertex t = new Vertex("t");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex z = new Vertex("z");
		
		Graph g = new Graph();

		g.addVertex(s);
		g.addVertex(t);
		g.addVertex(x);
		g.addVertex(y);
		g.addVertex(z);

		s.addConnection(t);
		g.addEdge(s, t, 6);
		s.addConnection(y);
		g.addEdge(s,y,4);
		
		t.addConnection(y);
		g.addEdge(t,y,2);
		t.addConnection(x);
		g.addEdge(t,x,3);
		
		x.addConnection(z);
		g.addEdge(x,z,4);
		
		y.addConnection(t);
		g.addEdge(y,t,1);
		y.addConnection(x);
		g.addEdge(y,x,9);
		y.addConnection(z);
		g.addEdge(y,z,3);
		
		
		z.addConnection(s);
		g.addEdge(z,s,7);
		z.addConnection(x);
		g.addEdge(z,x,5);
		

		GraphAlgorithms ga = new GraphAlgorithms();

		int[] shortestPath = ga.dijkstra(g,s);
		System.out.println("sp is: " + Arrays.toString(shortestPath));
	

	}

}