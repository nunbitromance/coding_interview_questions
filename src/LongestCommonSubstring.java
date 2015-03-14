/*
The longest common substring of the strings "ABABC", "BABCA" and "ABCBA" is string "ABC" of length 3. Other common substrings are "AB", "BC" and "BA".
*/
public static string LongestCommonSubstring(string s1, string s2)
{
	if (s1 == null)
	{
		throw new ArgumentNullException("s1");
	}
	if (s2 == null)
	{
		throw new ArgumentNullException("s2");
	}	
	string maxSubstring = null;
	int maxLength = 0;
	int[][] m = new int[s1.Length][s2.Length];
	
	for (int i = 0; i < s1.Length; i++)
	{
		if (s1[i] == s2[0])
		{
			m[i][0] = 1;
		}
	}
	
	for (int j = 0; j < s2.Length; j++)
	{
		if (s2[j] == s1[0])
		{
			m[0][j] = 1;
		}
	}
	
	for (int i = 1; i < s1.Length; i++)
	{
		for (int j = 1; j < s2.Length; j++)
		{
			if (s1[i] == s2[j])
			{
				int result = m[i-1][j-1] + 1;
				if (result > maxLength)
				{
					maxLength = result;
					maxSubstring = s1.Substring(i-maxLength+1, maxLength);
				}
			}
			else
			{
				m[i][j] = 0;
			}
		}
	}
	
	return maxSubstring;
}