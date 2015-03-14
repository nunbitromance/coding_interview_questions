/*Surrounded Regions
0
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
public static void SurroundedRegion(char[][] m)
{
	for (int i = 0; i < m.Length; i++)
	{
		for (int j = 0; j < m[0].Length; j++)
		{
			if (m[i][j] == 'O')
			{
				FloodFill(m, i, j);
			}
		}
	}
}

private static bool FloodFill(char[][] m, int i, int j)
{
	if (i < 0 || i > m.length || j < 0 || j > m[0].length)
	{	
		// if i hit a boundary return false
		return false;
	}
	else if (m[i][j] == 'X')
	{
		// if i hit an X stop and backtrack.
		return true;
	}
	
	if (m[i][j] == 'O')
	{
		// if i hit an O, mark it as X
		m[i][j] = 'X';
	}
	// Mark north, east, west, south. If I hit boundary, backtrack and restore.
	if (FloodFill(m, i-1, j) == false)
	{
		m[i][j] = 'O';
	}
	if (FloodFill(m, i, j+1) == false)
	{
		m[i][j] = 'O';
	}
	if (FloodFill(m, i+1, j) == false)
	{
		m[i][j] = 'O';
	}
	if (FloodFill(m, i, j-1) == false)
	{
		m[i][j] = 'O';
	}
}