package day_11_graphs;

import java.util.ArrayList;

public class GraphNode {
	private int data;
	private ArrayList<Pair> adjList;
	
	public GraphNode(int d) {
		data = d;
		adjList = new ArrayList<>();
	}
	
	/**
	 * Should be utilized by the Graph.connect()
	 * method when we set a as the neighbor of b
	 * and vice versa.
	 * 
	 * If w is omitted, then the graph is not a weighted
	 * graph, default value of w is 1.
	 * @param d
	 * @param w
	 */
	//for not weight graphs
	public void addNeighbor(GraphNode d) {
		adjList.add(new Pair(d));
	}
	
	//weighted graphs with custom w
	public void addNeighbor(GraphNode d, int w) {
		adjList.add(new Pair(d, w));
	}
	
	public void removeNeighbor(GraphNode n) {
		for(int i = 0; i < adjList.size(); i++) {
			if(adjList.get(i).destination == n) {
				adjList.remove(i);
				return;
			}
		}
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int d) {
		data = d;
	}
	
	/**
	 * Return the degree of the node
	 * @return
	 */
	public int degree() {
		return adjList.size();
	}	
	
	/**
	 * Return the neighbor arraylist
	 * @return
	 */
	public ArrayList<Pair> getNeighbors(){
		return adjList;
	}
}
