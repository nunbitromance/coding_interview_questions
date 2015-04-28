public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    public boolean helper(char[][] board) {
        Coordinate nextSpot = findNextCoordinate(board);
        if (nextSpot != null) {
            for (char k = '1'; k <= '9'; k++) {
                if (isValid(board, nextSpot.row, nextSpot.col, k)) {
                    board[nextSpot.row][nextSpot.col] = k;
                    boolean solved = helper(board);
                    if (solved == true) {
                        return true;
                    } else {
                        board[nextSpot.row][nextSpot.col] = '.';
                    }
                }
            }
            return false;
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char c){
     
        // check column
        for (int row=0; row<9; row++){
            if (board[row][j]==c){
                return false;
            }
           
             
        }
        
       // check row
        for (int col=0; col<9; col++){
            if (board[i][col]==c){
                return false;
            }
            
        }
      
        // check block
        for(int row=i/3*3; row<i/3*3+3; row++){
            for (int col=j/3*3; col<j/3*3+3; col++){
                if (board[row][col]==c){
                    return false;
                }
                
            }
        }
       
        return true;
        
    }
    
    private Coordinate findNextCoordinate(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }
}

class Coordinate {
    public int row;
    public int col;
    public Coordinate(int r, int c) {
        this.row = r;
        this.col = c;
    }
}
