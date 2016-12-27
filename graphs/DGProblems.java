import java.util.ArrayList;
import java.util.ArrayDeque;

public class DGProblems {

	public boolean isThereAPath(Graph g, Vertex a, Vertex b){
		//pick one of the two to be a source
		// do a BFS or a DFS from that source. THis time let's do BFS to remember the use of a Queue.
		// whenever we found the other vertex, we return true
		// otherwise, we return false

		g.BFSpreconditions();
		Vertex source = a;
		ArrayDeque<Vertex> q = new ArrayDeque<Vertex>();
		source.color = Graph.GRAY;
		q.add(source);
		boolean found = false;
		while(!q.isEmpty() && !found){
			Vertex current = q.poll();
			found = current.ID.equals(b.ID);

			ArrayList<Vertex> currentAdjacencyList;
			
			if(!found){
				currentAdjacencyList = current.vertices;
				for (int i = 0; i < currentAdjacencyList.size() ; i++ ) {
					Vertex v = currentAdjacencyList.get(i);
					if(v.color.equals(Graph.WHITE)){
						q.add(v);
					}
					v.color = Graph.GRAY;
				}

				current.color = Graph.BLACK;
			}



		}
		return found;

	}
	
	public static void main(String[] args) {
		// we create a graph for testing purposes

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		Vertex i = new Vertex("i");
		Vertex j = new Vertex("j");
		Vertex k = new Vertex("k");
		Vertex l = new Vertex("l");

		//
		a.addConnection(b);
		a.addConnection(c);

		b.addConnection(e);

		c.addConnection(d);
		c.addConnection(e);

		d.addConnection(a);

		e.addConnection(f);

		f.addConnection(i);
		f.addConnection(j);

		g.addConnection(h);

		k.addConnection(l);
		l.addConnection(k);

		Graph graph = new Graph();
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);
		graph.addVertex(j);
		graph.addVertex(k);
		graph.addVertex(l);


		DGProblems dg = new DGProblems();
		System.out.println("IS there a path between a and a :" + dg.isThereAPath(graph, a, a) );
		System.out.println("IS there a path between a and e :" + dg.isThereAPath(graph, a, e) );
		System.out.println("IS there a path between a and d :" + dg.isThereAPath(graph, a, d) );
		System.out.println("IS there a path between a and h :" + dg.isThereAPath(graph, a, h) );
		System.out.println("IS there a path between g and h :" + dg.isThereAPath(graph, g, h) );
		System.out.println("IS there a path between k and l :" + dg.isThereAPath(graph, k, l) );

	}
}