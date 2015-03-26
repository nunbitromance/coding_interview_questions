/*
	find solutions to 8X8 chess board, how many solutions there are to N queens problem.
*/
public static void findAllSolutionsToNQueens()
{
	int[] board = new int[8];
	for (int i = 0; i < board.length; i++)
	{
		board[i] = -1;
	}
	placeQueens(board, 0);	
}

// solve a problem by placing queen at row.
public static void placeQueens(int[] m, int row)
{
	if (row == m.length)
	{
		print(m);
	}
	else
	{
		for (int col = 0; col < m.length; col++)
		{
			if (canPlace(m, row, col))
			{
				m[row] = col;
				placeQueens(m, row + 1);
				m[row] = -1;
			}
		}
	}
}

// try to place Queen at row and col
private static bool canPlace(int[] m, int row, int col)
{
	for (int r = 0; r < row; r++)
	{
		// check same column
		if (col == m[r])
		{
			return false;
		}
		
		// check diagnal
		if (Math.abs(col - m[r]) == row - r)
		{
			return false;
		}
	}
	return true;	
}


=======================================================================

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> sol = new ArrayList<String[]>();
        String[] solI = new String[n];
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(".");
            }
            solI[row] = sb.toString();
        }
        solveNQueens(n, sol, solI, 0);
        return sol;
    }
    
    public void solveNQueens(int n, List<String[]> sol, String[] solI, int row) {
        if (row == n) {
            sol.add(solI.clone());
            return;
        }
        
        // placeNQueens on row if not in conflict
        for (int col = 0; col < n; col++) {
            if (checkValid(n, solI, row, col)) {
                StringBuilder sb = new StringBuilder(solI[row]);
                sb.setCharAt(col, 'Q');
                solI[row] = sb.toString();
                solveNQueens(n, sol, solI, row + 1);
                sb.setCharAt(col, '.');
                solI[row] = sb.toString();
            }
        }
    }
    
    public boolean checkValid(int n, String[] solI, int row, int col) {
        for (int r = 0; r < row; row++) {
            String s = solI[r];
            int c = s.indexOf('Q');
            
            if (c == col) {
                return false;
            }
            
            int colDistance = Math.abs(col - c);
            int rowDistance = Math.abs(row - r);
            if (colDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }
}
