/*
    3
   / \
  9  20
    /  \
   15   7
   
  Visit order: 3 -> 9 -> 20 -> 15 -> 7
*/
// Non-recursion
package com.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
public class GraphTraversal {

    public void DFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<Long>();
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                DFSUtil(vertex,visited);
            }
        }
        
    }
    
    private void DFSUtil(Vertex<Integer> v,Set<Long> visited){
        visited.add(v.getId());
        System.out.print(v.getId() + " ");
        for(Vertex<Integer> vertex : v.getAdjacentVertexes()){
            if(!visited.contains(vertex.getId()))
                DFSUtil(vertex,visited);
        }
    }
	
    public void DFSNonRecursiveUtil(Vertex<Integer> v, Set<Long> visited) {
	    Deque<Integer> stack = new ArrayDeque<>();
	    stack.push(v);
	    while (!stack.isEmpty()) {
		Vertex<Integer> cur = stack.pop();
		if (!visited.contains(cur.getId())) {
			System.out.print(v.getId() + " ");
			visited.add(v);
			for (Vetex<Integer> child : v.getAdjacentVertexes()) {
				stack.push(child);
			}
		}
	    }
    }
	
    public static void main(String args[]){
        
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
    //  graph.addEdge(5, 1);
        graph.addEdge(5,3);
        
        GraphTraversal g = new GraphTraversal();
        g.BFS(graph);
    }
}
