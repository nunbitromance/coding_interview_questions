/*
Dynamic Programming | Set 17 (Palindrome Partitioning)
June 17, 2012
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed. If a string of length n containing all different characters, then minimum n-1 cuts are needed.

Solution
This problem is a variation of Matrix Chain Multiplication problem. If the string is palindrome, then we simply return 0. Else, like the Matrix Chain Multiplication problem, we try making cuts at all possible places, recursively calculate the cost for each cut and return the minimum value.

Let the given string be str and minPalPartion() be the function that returns the fewest cuts needed for palindrome partitioning. following is the optimal substructure property.

// i is the starting index and j is the ending index. i must be passed as 0 and j as n-1
minPalPartion(str, i, j) = 0 if i == j. // When string is of length 1.
minPalPartion(str, i, j) = 0 if str[i..j] is palindrome.

// If none of the above conditions is true, then minPalPartion(str, i, j) can be 
// calculated recursively using the following formula.
minPalPartion(str, i, j) = Min { minPalPartion(str, i, k) + 1 +
                                 minPalPartion(str, k+1, j) } 
                           where k varies from i to j-1
*/
public static int MinPalindromePartition(string s)
{
	bool[][] isPalindrome = new bool[s.length][s.length];
	int[][] minPartition = new int[s.length][s.length];
	
	for (int i = 0; i < s.length; i++)
	{
		// for all single chars, min partition is 0.
		minPartition[i][i] = 0;
		// for all single chars, it is palindrome.
		isPalindrome[i][i] = true;
	}
	
	for (int i = 0; i < s.length; i++)
	{
		for (int j = i + 1; j < s.length; j++)
		{
			if ((j - i) == 2)
			{
				// 2 letters
				isPalindrome[i][j] = (s[i] == s[j]) ? true : false;
			}
			else
			{
				// more than 2 letters
				isPalindrome[i][j] = (s[i] == s[j]) ? s[i+1][j-1] : false;
			}
			
			if (isPalindrome[i][j])
			{
				// already palindrome.
				minPartition[i][j] = 0;
			}
			else
			{
				// C[i][j] = min (C[i][j], C[i][k] + C[k+1][j]+1);
				int cut = int.MaxValue;
				for (int k = i; k < j; k++)
				{
					cut = Math.Min(minPartition[i][k] + minPartition[k+1][j] + 1, cut);
				}
				minPartition[i][j] = cut;
			}
		}
	}
	
	return minPartition[0][n-1];
}