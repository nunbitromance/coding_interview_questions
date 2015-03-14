


// OPT(i) = 1 + max{OPT(j)} for j < i and A[i] >= A[j]
public static int longestIncreasingSubsequence(int[] array)
{
	if (array == null || array.length == 0)
	{
		return 0;
	}

	int[] maxLenghth = new int[array.length];
	maxLength[0] = 0;
	
	for (int i = 1; i < maxLength.length; i++)
	{
		int maxLength = 0;
		
		for (int j = 0; j < i; j++)
		{
			if (maxLength[j] > maxLength && array[j] < array[i])
			{
				maxLength = maxLength[j];
			}
		}
		
		maxLength[i] = maxLength + 1;
	}
    	
	return maxLength[array.length - 1];
}