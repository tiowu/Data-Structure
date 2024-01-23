package day_11_graphs;

/** 
 * This class stores the destination node
 * as well the weight which are used for 
 * the adjacency list of a directed graph.
 * If the graph is undirected, default to 
 * weight one.
 * @author nikolabaci
 *
 */
public class Pair {
	GraphNode destination;
	int edgeWeight;
	
	public Pair(GraphNode dest) {
		destination = dest;
		edgeWeight = 1;
	}
	
	public Pair(GraphNode dest, int w) {
		destination = dest;
		edgeWeight = w;
	}
}
