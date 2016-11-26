package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Graph {
	
	/*Constants needed for traversal*/
	public final static String WHITE = "WHITE";
	public final static String GRAY = "GRAY";
	public final static String BLACK  = "BLACK";
	
	/*time variable for DFS*/
	public int time;
	
	/* we have a list of every vertex in the graph */
	ArrayList<Vertex> vertices;
	
	public Graph(){
		vertices = new ArrayList<>();
	}
	
	public ArrayList<Vertex> BFS (Vertex source){
		ArrayList<Vertex> shortestPath = new ArrayList<>();
		ArrayDeque<Vertex> q = new ArrayDeque<Vertex>();
		
		/**
		 *  first we make sure the preconditions for the graph are met. These are:
		 *  1. THe distance in source and parent in source are 0 and null respectively.
		 *  2. Every other vertex has distance equal to infinity and is painted white.
		 */
		BFSpreconditions();
		source.color = GRAY;
		source.distance = 0;
		source.parent = null;
	
		q.add(source);
		
		while(q.size() != 0){
			
			Vertex u = q.remove();
			System.out.println("we are at vertix:  "+ u.ID);
			
			int adjSize = u.vertices.size();
			for(int i = 0; i < adjSize; i++){
				Vertex v = u.vertices.get(i);
				if(v.color.equals(WHITE)){
					v.color = GRAY;
					v.distance = u.distance + 1;
					v.parent = u;
					q.add(v);
				}
			}
			
			u.color = BLACK;
			
			
		}
		
		//process
		return shortestPath;
	}
	
	public void BFSpreconditions(){
		for(int i = 0; i < vertices.size(); i++){
			Vertex current = vertices.get(i);
			current.distance = Integer.MAX_VALUE;
			current.parent = null;
			current.color = WHITE;
		}
	}
	
	public void DFSpreconditions(){
		for(int i = 0; i < vertices.size(); i++){
			Vertex current = vertices.get(i);
			current.parent = null;
			current.color = WHITE;
		}
	}
	
	
	public void DFS(Vertex source){
		DFSpreconditions();
		time = 0;
		for(int i = 0; i < vertices.size(); i++){
			Vertex current = vertices.get(i);
			if(current.color.equals(WHITE)){
				DFSVisit(current);
			}
		}
		time = 0; 
	}
	
	public void DFSVisit(Vertex u){
		System.out.println("We are visiting vertex: " + u.ID);
		time = time + 1;
		u.d = time;
		u.color = GRAY;
		for(int i = 0; i < u.vertices.size(); i++){
			Vertex v = u.vertices.get(i);
			if(v.color.equals(WHITE)){
				v.parent = u;
				DFSVisit(v);
			}
		}
		
		u.color = BLACK;
		time = time + 1;
		u.f = time;
	}
	
	
	public void addVertex(Vertex v){
		if(v != null){
			vertices.add(v);
		}
		
	}
	
	public static void main(String[] args) {
		// graph for testing
		Vertex r = new Vertex("r");
		Vertex s = new Vertex("s");
		Vertex t = new Vertex("t");
		Vertex u = new Vertex("u");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		
		r.addConnection(s);
		r.addConnection(v);
		
		s.addConnection(r);
		s.addConnection(w);
		
		t.addConnection(w);
		t.addConnection(u);
		t.addConnection(x);
		
		u.addConnection(t);
		u.addConnection(y);
		u.addConnection(x);
		
		y.addConnection(u);
		y.addConnection(x);
		
		x.addConnection(u);
		
		w.addConnection(s);
		w.addConnection(t);
		
		v.addConnection(r);
		
		Graph g = new Graph();
		g.addVertex(r);
		g.addVertex(s);
		g.addVertex(t);
		g.addVertex(u);
		g.addVertex(v);
		g.addVertex(w);
		g.addVertex(x);
		g.addVertex(y);
		
		g.BFS(s);
		
		System.out.println("---------- DFS from here-----------");
		g.DFS(s);
		
	}

}
