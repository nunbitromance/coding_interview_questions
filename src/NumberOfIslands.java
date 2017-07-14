/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

*/
package com.interview.graph;

/**
 http://www.geeksforgeeks.org/find-number-of-islands/
 */
public class NumberOfIsland {

    public int numberOfIsland(int[][] graph){
        
        boolean[][] visited = new boolean[graph.length][graph.length];
        int count = 0;
        for(int i=0; i < graph.length ; i ++){
            for(int j =0 ; j < graph[i].length ; j++){
                if(visited[i][j] == false && graph[i][j] == 1) {
                    count++;
                    DFS(graph,visited,i,j);
                }
            }
        }
        return count;
    }
    
    private void DFS(int[][] graph, boolean[][] visited,int i,int j){
        if(i <0 || j < 0 || i == graph.length || j == graph[i].length)
        {
            return;
            
        }
        visited[i][j] = true;
        if(graph[i][j] == 0){
            return;
        }
        DFS(graph,visited,i,j+1);
        DFS(graph,visited,i+1,j);
        DFS(graph,visited,i+1,j+1);
        DFS(graph,visited,i-1, j+1);
    }
    
    public static void main(String args[]){
        
        int matrix[][] = {{1,1,0,1,0},
                          {1,0,0,1,1},
                          {0,0,0,0,0},
                          {1,0,1,0,1},
                          {1,0,0,0,0}
                        };
        NumberOfIsland island = new NumberOfIsland();
        int count = island.numberOfIsland(matrix);
        System.out.println(count);
    }
}
