/*
Interleaving StringAug 31 '12
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
// Recursion
public static bool IsInterleaving(string s1, string s2, string s3, int m, int n, int k)
{
	if (k == s1.Length + s2.Length)
	{
		return true;
	}
	
	if (s1[m] == s3[k])
	{
		return IsInterleaving(s1, s2, s3, m+1, n, k+1);
	}
	else if (s2[n] == s3[k])
	{
		return IsInterleaving(s1, s2, s3, m, n+1, k+1);
	}
	
	return false;
}

// Dynamic Programming
public static bool IsInterleaving(string s1, string s2, string s3)
{
	bool[][] memo = new bool[s1.Length + 1][s2.Length + 1];
	
	for (int i = 0; i < s1.Length + 1; i++)
	{
		memo[i][0] = true;
	}
	for (int j = 0; j < s2.Length + 1; j++)
	{
		memo[0][j] = true;
	}
	
	for (int i = 1; i < s1.Length + 1; i++)
	{
		for (int j = 1; j < s2.Length + 1; j++)
		{
			if (memo[i-1][j] && s3[i + j - 1] == s1[i - 1])
			{
				memo[i][j] = true;
			}
			else if (memo[i][j-1] && s3[i + j -1] == s2[j - 1])
			{
				memo[i][j] = true;
			}
			else
			{
				memo[i][j] = false;
			}
		}
	}
	
	return memo[s1.Length][s2.Length];
}