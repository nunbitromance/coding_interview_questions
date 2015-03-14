/*
Search a 2D MatrixApr 7 '12
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
*/
public static bool SearchMatrix(int[][] m, int t)
{
	int height = m.Length;
	int width = m[0].Length;
	
	int i = 0;
	for (i = 0 ; i < height; i++)
	{
		if (m[i][width - 1] >= t)
		{
			break;
		}
	}
	
	// height passed the search row
	i--;
	for (int j = width - 1; j >= 0; j--)
	{
		if (m[i][j] == t)
		{
			return true;
		}
	}
	return false;
}
