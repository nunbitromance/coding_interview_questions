/*
Continuing further on dynamic programming series, edit distance is an interesting algorithm.

Problem: Given two strings of size m, n and set of operations replace (R), insert (I) and delete (D) all at equal cost. 
Find minimum number of edits (operations) required to convert one string into another.
*/
public static int GetMinEditDistance(string s, string t, int R, int I, int D)
{
	int[][] minEdit = new int[s.length][t.length];
	
	// intialization
	minEdit[0][0] = 0;
	if (s.length == 0)
	{
		for (int j = 0; j < t.length; t++)
		{
			// insert all characters in t to match.
			minEdit[0][j] = j * I;
		}
	}
	if (t.length == 0)
	{
		for (int j = 0; j < s.length; t++)
		{
			// delete all characters in s to match.
			minEdit[j][0] = j * D;
		}
	}
	
	
	for (int i = 1; i < s.length; i++)
	{
		for (int j = 1; j < t.length; j++)
		{
			if (s[i] == t[j])
			{
				// same edit distance as no change needed.
				minEdit[i][j] = minEdit[i-1][j-1];
			}
			else
			{
				// E(i, j) = min( [E(i-1, j) + D], [E(i, j-1) + I],  [E(i-1, j-1) + R if i,j characters are not same] )
				int minEditDistance = Math.Min(
					minEdit[i-1][j] + D,
					minEdit[i][j-1] + I);
				minEditDistance = Math.Min(
					minEditDistance,
					minEdit[i-1][j-1] + R);
			}
		}
	}
	
	return minEdit[s.length-1][t.length-1];
}