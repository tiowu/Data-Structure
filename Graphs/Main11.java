package day_11_graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Graph tio = new Graph();
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		
		tio.connect(n0, n1);
		tio.connect(n0, n2);
		tio.connect(n1, n2);
		tio.connect(n1, n3);
		tio.connect(n2, n3);
		tio.connect(n2, n4);
		tio.connect(n3, n6);
		tio.connect(n4, n5);
		tio.connect(n5, n6);
		tio.connect(n5, n7);
		tio.connect(n6, n7);
		
		//tio.BreadthFirstSearch(n0);
		
		tio.DepthFirstSearch(n0);
		
		/*
		
		n0.addNeighbor(n3);
		n3.addNeighbor(n0);

		n1.addNeighbor(n3);
		n3.addNeighbor(n1);
		
		n2.addNeighbor(n1);
		n1.addNeighbor(n2);
		
		n3.addNeighbor(n2);
		n2.addNeighbor(n3);	
		
		n0.addNeighbor(n2);
		n2.addNeighbor(n0);
		*/
	}
	
	/*
	public static void BreadthFirstSearch(GraphNode firstNode) {
		Queue<GraphNode> queue = new LinkedList<>();
		HashSet<GraphNode> visited = new HashSet<>();
		queue.add(firstNode);
		visited.add(firstNode);
		
		while(!queue.isEmpty()) {
			GraphNode temp = queue.remove();
			System.out.println(temp.getData());
			
			for(int i = 0; i < firstNode.getNeighbors().size(); i++) {
				GraphNode nextNeighbor = firstNode.getNeighbors().get(i).destination;
				if(!visited.contains(nextNeighbor)) {
					queue.add(nextNeighbor);
					visited.add(nextNeighbor);
				}
			}
		}
	}
	
	public static void DepthFirstSearch(GraphNode firstNode) {
		Stack<GraphNode> stack = new Stack<>();
		HashSet<GraphNode> visited = new HashSet<>();
		stack.push(firstNode);
		visited.add(firstNode);

		while(!stack.isEmpty()){
			GraphNode temp = firstNode;
			System.out.println(firstNode.getData());
			for(int i = 0; i < firstNode.getNeighbors().size(); i++){
				if(!visited.contains(firstNode.getNeighbors().get(i).destination)){
					stack.push(firstNode.getNeighbors().get(i).destination);
					visited.add(firstNode.getNeighbors().get(i).destination);
				}
			}
		}
	}	
	*/
}
