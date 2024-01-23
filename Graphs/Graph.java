package day_11_graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	HashSet<GraphNode> graph;
	
	public Graph() {
		graph = new HashSet<>();
	}
	
	/**
	 * Connect nodes a and b. If graph is not weighted, 
	 * then the weight defaults to 1.
	 * @param a
	 * @param b
	 * @param weight
	 */
	
	public void connect(GraphNode a, GraphNode b) {
		graph.add(a);
		graph.add(b);
		a.addNeighbor(b);
		b.addNeighbor(a);
	}
	
	//weighted graph
	public void connect(GraphNode a, GraphNode b, int w) {
		graph.add(a);
		graph.add(b);
		a.addNeighbor(b, w);
		b.addNeighbor(a, w);
	}
	
	/**
	 * Delete the GraphNode and remove all the
	 * connecting edges to this node.
	 * @param n
	 * @return
	 */
	public void delete(GraphNode n) {
		ArrayList<Pair> neighbors = n.getNeighbors();
		//go through all the neighbors that reference n,
		//tell them to remove this reference to n
		for(int i = 0; i < neighbors.size(); i++) {
			neighbors.get(i).destination.removeNeighbor(n);
		}
		//finally, remove n from the graph
		graph.remove(n);
	}
	
	/**
	 * Perform Breadth First Search on the graph.
	 * Print each node you visit.
	 * @param initNode
	 */
	public HashSet<GraphNode> bfs(GraphNode initNode) {
		Queue<GraphNode> queue = new LinkedList<>();
		HashSet<GraphNode> visited = new HashSet<>();
		
		queue.add(initNode);
		visited.add(initNode);
		
		while(!queue.isEmpty()) {
			GraphNode node = queue.poll();
			System.out.println(node.getData());
			ArrayList<Pair> nodeNeighbors = node.getNeighbors();
			for(int i = 0; i < nodeNeighbors.size(); i++) {
				GraphNode neighbor = nodeNeighbors.get(i).destination;
				
				if(!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
		return visited;
	}
	
	/**
	 * Perform Depth First Search on the graph.
	 * Print each node you visit.
	 * @param initNode
	 */
	public void dfs(GraphNode initNode) {
		Stack<GraphNode> stack = new Stack<>();
		HashSet<GraphNode> visited = new HashSet<>();
		
		stack.push(initNode);
		visited.add(initNode);
		
		while(!stack.isEmpty()) {
			GraphNode node = stack.pop();
			System.out.println(node.getData());
			ArrayList<Pair> nodeNeighbors = node.getNeighbors();
			for(int i = 0; i < nodeNeighbors.size(); i++) {
				GraphNode neighbor = nodeNeighbors.get(i).destination;
				
				if(!visited.contains(neighbor)) {
					stack.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
	}
	
	/**
	 * Given two nodes, a and b, find the shortest
	 * path if it exits. Shortest path is defined
	 * in terms of edge weights (aka smallest weight sum).
	 * @param a
	 * @param b
	 */
	public void shortestPath(GraphNode a, GraphNode b) {
	
	}
	
	/**
	 * Can we color the graph in such a way that
	 * each neighbor is of alternating red/blue color?
	 * @return
	 */
	
	public GraphNode getANode() {
		if(graph.size() == 0) return null;
		for(GraphNode node: graph) {
			return node;
		}
		return null;
	}
	
	
	public boolean isBipartite() {
		if(graph.size() < 2) return true;
		HashSet<GraphNode> redNodes = new HashSet<>();
		HashSet<GraphNode> blueNodes = new HashSet<>();
		GraphNode initNode = getANode();
		
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(initNode);
		redNodes.add(initNode);
		
		while(!queue.isEmpty()) {
			GraphNode node = queue.poll();
			ArrayList<Pair> nodeNeighbors = node.getNeighbors();
			System.out.println(node.getData());
			for(int i = 0; i < nodeNeighbors.size(); i++) {
				GraphNode neighbor = nodeNeighbors.get(i).destination;
				
				if((redNodes.contains(node) && redNodes.contains(neighbor)) ||
						(blueNodes.contains(node) && blueNodes.contains(neighbor))) {
					return false;
				}
				if(!redNodes.contains(neighbor) && !blueNodes.contains(neighbor)) {
					queue.add(neighbor);
					if(redNodes.contains(node)) {
						blueNodes.add(neighbor);
					} else {
						redNodes.add(neighbor);
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Are all the nodes connected to each other?
	 * @return
	 */
	public boolean isConnected() {
		HashSet<GraphNode> visited = new HashSet<>();
		for(GraphNode node: graph) {
			visited = bfs(node);
			break;
		}
		return visited.size() == graph.size();
	}
}
