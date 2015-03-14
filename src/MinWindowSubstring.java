/*
Minimum Window SubstringApr 15 '12
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
public static string MinWindowSubstring(string s, string t)
{
	Dictionary<char, PriorityQueue<int>> sHash = new Dictionary<char, PriorityQueue<int>>();
	Dictionary<char, int> tHash = new Dictionary<char, int>();
	
	// Map counter by char
	for (int j=0; j<t.Length; j++)
	{
		if (tHash.ContainsKey(t[j]))
		{
			tHash[t[j]] = tHash[t[j]] + 1;
		}
		else
		{
			tHash.Add(t[j], 1); 
		}
	}
	
	// Map priority queues by char
	for (int i=0; i < s.Length; i++)
	{
		if (tHash.ContainsKey(s[i]))
		{
			// We only care if the char is in pattern
			if (sHash.ContainsKey(s[i]))
			{
				sHash[s[i]].Insert(i);
			}
			else
			{
				var pq = new PriorityQueue<int>();
				pq.Insert(i);
				sHash.Add(s[i], pq);
			}
		}
	}
	
	int minWindowStart = 0;
	int minWindowEnd = 0;
	bool hasReachedFirstWindow = false;
	
	Dictionary<char, bool> dic = new Dictionary<char, bool>();	
	for (int i = 0; i < s.Length; i++)
	{
		if (tHash.ContainsKey(s[i]))
		{
			if (tHash.Size <= tHash.Length)
			{
				dic.Add(s[i], true)
			}
			else
			{
				int localStart = 99;
				int localEnd = 99;
				foreach (char c in t)
				{
					PriorityQueue pq = sHash[c];
					if (pq.Peek() < localStart)
					{
						localStart = pq.Peek();
					}
					if (pq.Peek() > localEnd)
					{
						localEnd = pq.Peek();
					}
				}
			}
		}
	
		
	}
	
	return s.Substring(minWindowStart, minWindowEnd - minWindowStart + 1);
}