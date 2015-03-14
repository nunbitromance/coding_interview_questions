//Checks whether string has all unique characters.
public static bool isUnique(char[] s)
{
	Dictionary<char, bool> hash = new Dictionary<char, bool>();
	for (int i=0; i<s.length; i++)
	{
		if (hash.containsKey(s[i]) == false)
		{
			hash.add(s[i], true);
		}
		else
		{
			return false;
		}
	}
	return true;
}

public static bool isUnique(char[] s)
{
	int bitVector = 0;
	for (int i=0; i<s.length; i++)
	{
		if (bitVector & (1 << s[i]) == 0)
		{
			bitVector |= (1 << s[i]);
		}
		else
		{
			return false;
		}
	}
	return true;
}