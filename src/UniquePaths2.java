/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
*/

// DFS 
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return helper(obstacleGrid, 0, 0);
    }
    
    private int helper(int[][] obstacleGrid, int row, int col) {
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            return obstacleGrid[row][col] == 0 ? 1 : 0;
        } else if (row > obstacleGrid.length - 1 || col > obstacleGrid[0].length - 1) {
            return 0;
        }
        
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        int moveRight = helper(obstacleGrid, row, col + 1);
        int moveDown = helper(obstacleGrid, row+1, col);
        return moveRight + moveDown;
    }
}

// DP
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] opt = new int[obstacleGrid.length][obstacleGrid[0].length];
        opt[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        
        for (int i = 1; i < opt.length; i++) {
            opt[i][0] = obstacleGrid[i][0] == 0 ? opt[i-1][0] : 0;
        }
        
        for (int i = 1; i < opt[0].length; i++) {
            opt[0][i] = obstacleGrid[0][i] == 0 ? opt[0][i-1] : 0;
        }
        
        for (int i = 1; i < opt.length; i++) {
            for (int j = 1; j < opt[0].length; j++) {
                opt[i][j] = obstacleGrid[i][j] == 0 ? opt[i-1][j] + opt[i][j-1] : 0;
            }
        }
        
        return opt[opt.length - 1][opt[0].length - 1];
    }
}
