/*
Word SearchApr 18 '12
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
» Solve this problem
*/

public class WordSearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] m = new char[3][3];
        m[0] = new char[]{'A', 'B', 'C'};
        m[1] = new char[]{'D', 'E', 'F'};
        m[2] = new char[]{'G', 'H', 'I'};
        
        System.out.println(new WordSearch().wordSearch(m, "EFI"));
    }

    public boolean wordSearch(char[][] m, String word) {
        boolean[][] visited = new boolean[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (wordSearch(m, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean wordSearch(char[][] m, String word, boolean[][] visited, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        } else if (i >= m.length || i < 0 || j >= m[0].length || j < 0) {
            return false;
        }
        
        visited[i][j] = true;
        if (word.charAt(index) == m[i][j]) {
            return wordSearch(m, word, visited, index + 1, i-1, j) ||
                    wordSearch(m, word, visited, index + 1, i, j+1) ||
                    wordSearch(m, word, visited, index + 1, i+1, j) ||
                    wordSearch(m, word, visited, index + 1, i, j-1);
        }
        visited[i][j] = false;
        return false;
    }
    
}
