package day_11_Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		
		n0.addNeighbors(n3);
		n3.addNeighbors(n0);

		n1.addNeighbors(n3);
		n3.addNeighbors(n1);
		
		n2.addNeighbors(n1);
		n1.addNeighbors(n2);
		
		n3.addNeighbors(n2);
		n2.addNeighbors(n3);	
		
		n0.addNeighbors(n2);
		n2.addNeighbors(n0);
		
		BreadthFirstSearch(n0);
	}
	
	public static void BreadthFirstSearch(GraphNode firstNode) {
		Queue<GraphNode> queue = new LinkedList<>();
		HashSet<GraphNode> visited = new HashSet<>();
		queue.add(firstNode);
		visited.add(firstNode);
		
		while(!queue.isEmpty()) {
			GraphNode temp = queue.remove();
			System.out.println(temp.data);
			
			for(int i = 0; i < firstNode.adjList.size(); i++) {
				GraphNode nextNeighbor = firstNode.adjList.get(i);
				if(!visited.contains(nextNeighbor)) {
					queue.add(nextNeighbor);
					visited.add(nextNeighbor);
				}
			}
		}
	}

}
