/*
Wildcard MatchingMar 16 '12
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "*") ? true
isMatch("aa", "a*") ? true
isMatch("ab", "?*") ? true
isMatch("aab", "c*a*b") ? false
*/
public static bool IsMatch(string s, string pattern)
{
	int i = s.Length - 1;
	int j = pattern.Length - 1;
	
	while (i >= 0 && j >= 0)
	{
		char p = pattern[j];
		
		if (p == '?') // any single character
		{
			j--;
			if (i < 0)
			{
				// if s ran out of characters.
				return false;
			}
			i--;
		}
		else if (p == '*')
		{
			// until stop char is met, match all chars
			char stopChar = p[--j];
			while (i >= 0 && s[i] != stopChar)
			{
				i--;
			}
		}
		else if (s[i] == p)
		{
			i--;
			j--;
		}
		else
		{
			return false;
		}
	}
	return true;
}