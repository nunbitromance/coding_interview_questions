Going over all cells, we can count only those that are the "first" cell of the battleship. 
    First cell will be defined as the most top-left cell. We can check for first cells by only counting cells that do not 
    have an 'X' to the left and do not have an 'X' above them.


    public int countBattleships(char[][] board) {
        int c = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && 
                    (i == 0 || board[i - 1][j] == '.') && 
                    (j == 0 || board[i][j - 1] == '.')) {
                    c++;
                }
            }
        }
        return c;
    }
