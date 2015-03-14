/*
	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	
	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	
	Your algorithm should run in O(n) complexity.
*/
public static int maxConsecutiveNumbers(int[] a)
{
	Dictionary<int, int> dic = new Dictionary<int, int>();
	int maxLength = 0;
	for (int i = 0; i < a.Length; i++)
	{
		if (dic.ContainsKey(a[i]))
		{
			continue;
		}
		
		int length = 1;
		
		// check if previous number has length
		if (dic.ContainsKey(a[i]-1))
		{
			length = length + dic[a[i]-1];
		}
		// check if next number has length
		if (dic.ContainsKey(a[i] + 1))
		{
			length = length + dic[a[i]+1];
		}
		
	    if (length > maxLength)
	    {
	    	maxLength = length;
	    }
		
		dic.Add(a[i], length);
	}
	
	return maxLength;
}