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

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i > 0 && grid[i-1][j]=='1') helper(grid,i-1,j);
        if (j > 0 && grid[i][j-1]=='1') helper(grid,i,j-1);
        if (i < grid.length-1 && grid[i+1][j]=='1') helper(grid,i+1,j);
        if (j < grid[0].length-1 && grid[i][j+1]=='1') helper(grid,i,j+1);
    }
}
