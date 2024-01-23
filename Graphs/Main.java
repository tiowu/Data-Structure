package day_11_graphs;

public class Main {
	public static void main(String[] args) {
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		
		Graph g = new Graph();
		g.connect(n0, n1);
		g.connect(n0, n2);
		g.connect(n1, n2);
		g.connect(n1, n3);
		g.connect(n2, n3);
		g.connect(n2, n4);
		g.connect(n3, n6);
		g.connect(n4, n5);
		g.connect(n5, n6);
		g.connect(n5, n7);
		g.connect(n6, n7);
		
		g.bfs(n0);
		
		System.out.println("\n"+g.isBipartite());
		
	}
}
