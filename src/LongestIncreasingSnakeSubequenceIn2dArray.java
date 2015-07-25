// as known as snake problem, find longest increasing subsequence given a 2d matrix of integers.
// 2 approaches: DFS or Dynamic Programming

// Dynamic Programming: runtime O(n^2) space O(n^2)
public int findLongestIncreasing(int[][] m) {
    if (m == null) {
       throw new IllegalArgumentException("m");
    } else if (m.length == 0 && m[0].length == 0) {
       return 0;
    }
    int[][] opt = new int[m.length][m[0].length];
    for (int i = 0; i < m.length; i++) {
      Arrays.fill(m[i], 1);
    }
    int max = 1;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        // up
        if (i - 1 > 0 && m[i-1][j] - m[i][j] == 1) {
          opt[i][j] = Math.max(opt[i][j], opt[i-1][j] + 1);
        }
        // left
        if (j - 1 > 0 && m[i][j - 1] - m[i][j] == 1) {
          opt[i][j] = Math.max(opt[i][j], opt[i][j - 1] + 1);
        }
        // down
        if (i + 1 < m.length && m[i][j - 1] - m[i][j] == 1) {
          opt[i][j] = Math.max(opt[i][j], opt[i+1][j] + 1);
        }
        // right
        if (j + 1 < m[0].length && m[i][j + 1] - m[i][j] == 1) {
          opt[i][j] = Math.max(opt[i][j], opt[i][j+1] + 1);
        }
        max = Math.max(max, opt[i][j]);
      }
    }
    return max;
}


// DFS or backtracking O(n^2 * n^2) = O(n^4)
public int findLongestIncreasing(int[][] m) {
    if (m == null) {
       throw new IllegalArgumentException("m");
    } else if (m.length == 0 && m[0].length == 0) {
       return 0;
    }
    boolean[][] visited = new boolean[m.length][m[0].length];
    int longest = 1;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        longest = Math.max(longest, findLongestIncreasing(m, visited, i, j);
      }
    }
    return longest; 
}

public int findLongestIncreasing(int[][] m, boolean[][] visited, int r, int c) {
    if (r < 0 || r > m.length - 1 || c < 0 || c > m[0].length - 1) {
       return 0;
    }
    int longest = 1;
    if (visited[r][c] == false) {
      visited[r][c] = true;
      
      // left
      if (c - 1 > 0 && Math.abs(m[r][c] - m[r][c-1]) == 1) {
        longest = Math.max(longest, findLongestIncreasing(m, visited, r, c - 1) + 1);
      }
      // up
      if (r - 1 > 0 && Math.abs(m[r][c] - m[r-1][c]) == 1) {
        longest = Math.max(longest, findLongestIncreasing(m, visited, r-1, c) + 1);
      }
      // right
      if (c+1 < m[0].length && Math.abs(m[r][c] - m[r][c+1]) == 1) {
        longest = Math.max(longest, findLongestIncreasing(m, visited, r, c+1) + 1);
      }
      // down
      if (r + 1 < m.length && Math.abs(m[r][c] - m[r+1][c]) == 1) {
        longest = Math.max(longest, findLongestIncreasing(m, visited, r+1, c) + 1);
      }
      
      visited[r][c] = false;
    }
    return longest;
}

