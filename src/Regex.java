/*
Implement regular expression matching with support for ¡®.¡¯ and ¡®*¡¯.

¡®.¡¯ Matches any single character.
¡®*¡¯ Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch(¡°aa¡±,¡±a¡±) ¡æ false
isMatch(¡°aa¡±,¡±aa¡±) ¡æ true
isMatch(¡°aaa¡±,¡±aa¡±) ¡æ false
isMatch(¡°aa¡±, ¡°a*¡±) ¡æ true
isMatch(¡°aa¡±, ¡°.*¡±) ¡æ true
isMatch(¡°ab¡±, ¡°.*¡±) ¡æ true
isMatch(¡°aab¡±, ¡°c*a*b¡±) ¡æ true
*/

public static bool IsMatch(string s, string p, int i, int j)
{
	// base case
	if (j == p.Length)
	{
		return i == s.Length;
	}
	
	if (p[j+1] != '*')
	{
		return (p[j] == s[i] ||
			p[j] == '.' && i == s.Length) & isMatch(s, p, i+1, j+1);
	}
	while (p[j] == s[i] || p[j] == '.' && i < s.Length)
	{
		if (IsMatch(s, p, i, j+2))
		{
			return true;
		}
		i++;
	}
	return IsMatch(s, p, i, j+2);
}

/* C++ code
bool isMatch(const char *s, const char *p) {
  assert(s && p);
  if (*p == '\0') return *s == '\0';
 
  // next char is not '*': must match current character
  if (*(p+1) != '*') {
    assert(*p != '*');
    return ((*p == *s) || (*p == '.' && *s != '\0')) && isMatch(s+1, p+1);
  }
  // next char is '*'
  while ((*p == *s) || (*p == '.' && *s != '\0')) {
    if (isMatch(s, p+2)) return true;
    s++;
  }
  return isMatch(s, p+2);
}
*/