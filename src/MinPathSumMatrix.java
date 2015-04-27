/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
// DFS solution
public class Solution {
    private int minSum = Integer.MAX_VALUE;
    
    public int minPathSum(int[][] grid) {
        helper(grid, 0, 0, 0);
        return minSum;
    }
    
    private void helper(int[][] grid, int sum, int r, int c) {
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            sum+=grid[r][c];
            minSum = Math.min(minSum, sum);
        } else if (r >= grid.length || c >= grid[0].length) {
            return;
        }
        
        sum+=grid[r][c];
        
        helper(grid, sum, r+1, c);
        helper(grid, sum, r, c+1);
    }
}

// DP solution
public int minPathSum(int[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        
        int[][] minCounter=new int[grid.length][grid[0].length];
        
        minCounter[0][0]=grid[0][0];
        
        // build first column
        for  (int i=1; i<grid.length; i++){
            minCounter[i][0]=grid[i][0]+minCounter[i-1][0];
        }
        
        // build first row
        for (int i=1; i<grid[0].length; i++){
            minCounter[0][i]=grid[0][i]+minCounter[0][i-1];
        }
        
        //build minCounter
        for (int i=1; i<grid.length; i++){
            for (int j=1; j<grid[0].length; j++){
                minCounter[i][j]=Math.min(minCounter[i-1][j], minCounter[i][j-1])+grid[i][j];
            }
        }
        
        return minCounter[grid.length-1][grid[0].length-1];
    }
