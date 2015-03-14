/*
Decode WaysJun 25 '12
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
// "12" -> "AB" or "L"
public static int NumOfDecodedMessages(string s, int index)
{
	if (s.Length == 0 || index >= s.Length)
	{
		return 1;
	}
	
	char c = s[0];
	int result = 0;
	int val = c - '0';
	if (val > 0 && val <= 26)
	{
		result = NumOfDecodedMessages(s.Substring(1), index + 1);
	}
	if (s.Length > 1)
	{
		char c2 = s[1];
		int val2 = val * 10 + (c2 - '0');
		if (val2 > 0 && val2 <= 26)
		{
			result += NumOfDecodedMessages(s.Substring(2), index + 2);
		}
	}
	return result;
}