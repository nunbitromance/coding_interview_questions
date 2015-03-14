/*
Given a string S, find the longest palindromic substring in S.
s = "abac" => "aba"

Define P[ i, j ] ? true iff the substring Si � Sj is a palindrome, otherwise false.
Therefore,

P[ i, j ] ? ( P[ i+1, j-1 ] and Si = Sj )
The base cases are:

P[ i, i ] ? true
P[ i, i+1 ] ? ( Si = Si+1 )
*/
public static string LongestPalindromeSubstring(string s)
{
	if (s == null)
	{
		throw new ArgumentNullException("s");
	}
	
	int[][] m = new int[s.Length][s.Length];
	for (int i = 0; i < s.Length; i++)
	{
		m[i][i] = 1;
	}
	string longestPalindrome = null;
	for (int length = 2; length <= s.Length; length++)
	{
		for (int i = 0; i < s.Length; i++)
		{
			int j = i + length - 1;
			
			if (s[i] == s[j])
			{
				m[i][j] = m[i+1][j-1] + 2;
				longestPalindrome = s.Substring(i, length);
			}
			else
			{
				m[i][j] = Math.Max(m[i+1][j], m[i][j-1]);
			}
		}
	} 
	
	return longestPalindrome == null ? s[0] : longestPalidrome;
}

string longestPalindromeDP(string s) {
  int n = s.length();
  int longestBegin = 0;
  int maxLen = 1;
  bool table[1000][1000] = {false};
  for (int i = 0; i < n; i++) {
    table[i][i] = true;
  }
  for (int i = 0; i < n-1; i++) {
    if (s[i] == s[i+1]) {
      table[i][i+1] = true;
      longestBegin = i;
      maxLen = 2;
    }
  }
  for (int len = 3; len <= n; len++) {
    for (int i = 0; i < n-len+1; i++) {
      int j = i+len-1;
      if (s[i] == s[j] && table[i+1][j-1]) {
        table[i][j] = true;
        longestBegin = i;
        maxLen = len;
      }
    }
  }
  return s.substr(longestBegin, maxLen);
}
Additional exercise:
Could you improve the above space complexity further and how?
