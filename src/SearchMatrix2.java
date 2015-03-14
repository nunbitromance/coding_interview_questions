/*
SearchMatrix2
Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array). This table is sorted along the rows and columns — that is,

Table[i][j] ? Table[i][j + 1], 
Table[i][j] ? Table[i + 1][j]

[
  [1,  3,  12, 15],
  [10, 19, 20, 22],
  [23, 30, 34, 50]
]
*/
public static bool SearchMatrix(int[][] m, int n)
{
	int width = m[0].Length;
	int height = m.Length;
	
	int row = 0;
	int col = width-1;
	
	while (row != height && col != 0)
	{
		if (matrix[row][col] == n)
		{
			return true;
		}
		else if (matrix[row][col] > n) 
		{
			col--;
		}
		else
		{
			row++;
		}
	}
}

public static bool SearchMatrix(int[][] m, int n, int startRow, int startCol, int endRow, int end Col)
{
	if (startRow > endRow || startCol > endCol)
	{
		return false;
	}
	
	int midRow = startRow + (endRow - startRow) / 2;
	int midCol = startCol + (endCol - startCol) / 2;
	
	if (m[midRow-1][midCol-1] == n || m[midRow][midCol] == n)
	{
		return true;
	}
	else if (n < m[midRow-1][midCol-1])
	{
		return SearchMatrix(m, n, startRow, startCol, midRow-1, midCol-1);
	}
	else if (m[midRow][midCol] < n)
	{
		return SearchMatrix(m, n, midRow, midCol, endRow, endCol);
	}
	else
	{
		return SearchMatrix(m, n, startRow, midRow, midCol, endCol) || SearchMatrix(m, n, midRow, endRow, startCol, midCol); 
	}
	return false;
}