/* Check if string s1 contains s2 */
public static int isSubstring(string s1, string s2)
{
	for (int i=0; i<= s1.length-s2.length; i++)
	{
		int j = 0;
		for (; j<s2.length; j++)
		{
			if (s1[i + j] != s2[j])
			{
				break;
			}
		}
		
		if (j == s2.length)
		{
			return i;
		}
	}
	return -1;
}

/* Rabin Karp */
public static bool IsSubstring(string s1, string s2)
{
	int hash1 = GetHash(s1, 0, s2.Length);
	int hash2 = GetHash(s2, 0, s2.Length);
	
	if (hash1 == hash2)
	{
		return 0;
	}

	for (int i = 0; i <= s1.length - s2.length; i++)
	{
		if (hash1 == hash2)
		{
			int j = 0;
			for (j = 0; j < s2.length; j++)
			{
				if (s1[i + j] != s2[j])
				{
					break;
				}
			}
			if (j == s2.length)
			{
				return true;
			}
		}
		else
		{
			hash1 = (hash - s1[0] * 31 + s1[i + s2.length] * pow(31, s2.length - 1)) / 31;
		}
	}
}

public static int GetHash(string s, int offset, int length)
{
	int hash = 0;
	for (int i = offset; i < offset + Length; i++)
	{
		hash += s[i] * power(31, i);
	}
	return hash;
}

/*
public int rabinKarp(String t, String p) {
        int m = p.length();
        int hashP = hash(p.toCharArray(), 0, m);
        int hashT = hash(t.toCharArray(), 0, m);
        if (hashP == hashT) { return 0; }

        int a_to_m_minus_1 = 1; // 31 ^ (m - 1)
        for (int i = 0; i < m - 1; i++) {
            a_to_m_minus_1 = (a_to_m_minus_1 << 5) - a_to_m_minus_1;
        }

        for (int i = 1; i < t.length() - m + 1; i++) {
            hashT = hashT - a_to_m_minus_1 * t.toCharArray()[i - 1];
            hashT = (hashT << 5) - hashT;
            hashT = hashT + t.toCharArray()[i + m - 1];
            if (hashP == hashT) { return i; }
        }

        return -1;
    }

    public static int hash(char[] chars, int offset, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash << 5) - hash + chars[offset + i];
        }

        return hash;
    }

*/