/* find all solutions to 9X9 sudoku */
public static void solveSudoku()
{
	int[][] board = new int[9][9];
	solveSudoku(board);
}

public static void solveSudoku(int[][] board)
{
	int row, col = 0;
	
	if (findNextPlace(board, out row, out col))
	{
		for (int i = 1; i <= 9; i++)
		{
			if (!isConflicting(board, row, col, i))
			{
				// place i in that row, col
				board[row][col] = i;
				
				// solve starting from next row, col.
				solveSudoku(board);
				
				// reset the row, col to unselected
				board[row][col] = 0;
			}
		}
	}
	else
	{
		print(board);
	}
}

public static bool findNextPlace(int[][] board, out int row, out int col)
{
	for (int i=0; i < 9; i++)
	{
		for (int j=0; j<9; j++)
		{
			if (board[i][j] == 0)
			{
				row = i;
				col = j;
				return true;
			}
		}
	}
	return false;
}

public static bool isConflicting(int[][] board, int row, int col, int num)
{
	// check same row
	for (int i = 0; i < board[0].length; i++)
	{
		if (i != col && board[row][i] == num)
		{
			return false;
		}
		
		if (i != row && board[i][col] == num)
		{
			return false;
		}
	}
	
	int rowBoxStart = row - row%3;
	int colBoxStart = col - col%3;
	for (int j = rowBoxStart; j < rowBoxStart + 3; j++)
	{
		for (int k = colBoxStart; k < colBoxStart + 3; k++)
		{
			if ((j != row && k != col) && board[j][k] == num)
			{
				return false;
			}
		}
	}
	return true;
}