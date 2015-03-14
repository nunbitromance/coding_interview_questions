/*
Maximal RectangleApr 24 '12
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

00011111
00011110
10011111
00000001
*/
public class Cell
{
	public int OnesRight { get; set;}
	public int OnesBelow { get; set;}	
}

public static int MaxRectangle(int[][] m)
{
	Cell[][] c = new Cell[m.Length][m[0].Length];

	for (int i = m.Length; i >= 0; i--)
	{
		for (int j = m[0].Length; j >= 0; j--)
		{
			int onesRight = 0;
			int onesBelow = 0;
			
			if (m[i][j] == 1)
			{
				onesRight++;
				onesBelow++;
				
				if (j + 1 < m.Length) 
				{
					Cell previous = c[i][j+1];
					onesRight = onesRight + previous.OnesRight;
				}
				if (i + 1 < m.Length)
				{
					Cell previous = c[i+1][j];
					onesBelow = onesBelow + previous.OnesBelow;
				}
			}
			c[i][j] = new Cell();
			c[i][j].OnesRight = onesRight;
			c[i][j].OnesBelow = onesBelow;
		}
	}


	for (int i = 0; i < m.Length; i++)
	{
		for (int j = 0; j < m[0].Length; j++)
		{
			for (int k = m.Length; k > 1; k--)
			{
				for (int l = m[0].Length; m > 1; m--)
				{
					if (isRectangle(c, i, j, k, l))
					{
						return (k - i) * (j - l);
					}
				}
			}
		}
	}
}

private static int IsRectangle(Cell[][] c, int row, int col, int height, int width)
{
	Cell topLeft = c[row][col];
	Cell topRight = c[row][col + width - 1];
	Cell bottomLeft = c[row + height -1][col];
	
	if (topLeft.OnesBelow < height)
	{
		return false;
	}
	if (topRight.OnesBelow < height)
	{
		return false;
	}
	if (bottomLeft.OnesRight < width)
	{
		return false;
	}
	return true;
} 