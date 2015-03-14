/*
Set Matrix ZeroesApr 6 '12
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
input:
1324324
2132023
2132345
output:
1324024
0000000
2132045
*/
public static SeeMatrixZeros(int[][] matrix)
{
	bool[] rows = new bool[matrix.Length];
	bool[] cols = new bool[matrix[0].Length];
	
	for (int i = 0; i < rows.Length; i++)
	{
		for (int j = 0; j < cols.Length; j++)
		{
			if (matrix[i][j] == 0)
			{
				rows[i] = true;
				cols[j] = true;
			}
		}
	}
	
	// rows[1] = true, cols[4] = true
	for (int i = 0; i < rows.Length; i++)
	{
		for (int j = 0; j < cols.Length; j++)
		{
			if (rows[i] == true || cols[j] == true)
			{
				matrix[i][j] = 0;
			}
		}
	}	
}