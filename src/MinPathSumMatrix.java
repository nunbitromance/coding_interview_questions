/*
Minimum Path SumMar 29 '12
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public static int MinPathSumMatrix(int[][] m, int row, int col, int sum)
{
	if (row = m.Length -1 && col == m[0].Length - 1)
	{
		return sum;
	}
	
	// add cost to sum.
	sum += m[row][col];
	
	int val = 0;
	if (row < m.Length)
	{
		// Go down
		val = MinPathSumMatrix(m, row+1, col, sum);
	}
	if (col < m[0].Length)
	{
		// Go right
		val = Math.Min(MinPathSumMatrix(m, row, col + 1, sum), val);
	}

	return val;
}
