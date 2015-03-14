// Compress string aaaabbcccddaa -> a4b2c3d2a2
public static string compress(string s)
{
	StringBuilder sb = new StringBuilder();
	int count = 1;
	char lastChar = s[0];
	for (int i=1; i<s.length; i++)
	{
		if (s[i] == lastChar)
		{
			count++;
		}
		else
		{
			sb.append(lastChar);
			sb.append(count);
			count = 1;
			lastChar = s[i]; 
		}
	}
	print(sb.toString());
}