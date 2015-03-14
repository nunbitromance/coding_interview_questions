/*
Given a matrix (2D array) of m x n elements (m rows, n columns), write a function that prints the elements in the array in a spiral manner.
*/
// PrintSprialMatrix(m, 0, 0, m.Length, m[0].Length);
public static void PrintSpiralMatrix(int[][] m, int r, int c, int height, int width)
{
	if (r + height <= 0 || col + width <= 0)
	{
		return;
	}
	
	//Print top
	for (int i=c, i<width;i++)
	{
		Print(m[r][i]);
	}
	//Print right
	for (int i=r, i<height;i++)
	{
		Print(m[i][c+width]);
	}
	//Print bottom
	for (int i=c+width-1; i>=c; i--)
	{
		Print(m[r+height-1][i]);
	}
	//Print left
	for (int i=r+height-1; i>=r; i--)
	{
		Print(m[i][col]);
	}
		
	PrintSpiralMatrix(m, r+1, c+1, height-2, width-2);
}

/*
Spiral Matrix IIMar 28 '12
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public static int[][] GetSpiralMatrix(int n)
{

}