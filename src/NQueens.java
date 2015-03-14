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