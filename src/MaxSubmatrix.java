/*
Max Submatrix Problem
*/
public static int MaxSubmatrix(int[][] m)
{
	for (int rowStart = 0; rowStart < m.Length; rowStart++)
	{
		for (int rowEnd = rowStart; rowEnd < m.Length; rowEnd++)
		{
			int[] tempSum = new int[m[0].Length];
			for (int col = 0; col < m[0].Length; col++)
			{
				for (int p = rowStart; p <= rowEnd; p++)
				{
					tempSum[col] += m[p][col];
				}
			}
			
			int tempLargest = MaxSubsum(tempSum);
			if (tempLargest > maxSum)
			{
				maxSum = tempLargest;
			}
		}
	}
	return maxSum;
}