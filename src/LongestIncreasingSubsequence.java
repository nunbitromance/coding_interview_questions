

http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
// OPT(i) = 1 + max{OPT(j)} for j < i and A[i] >= A[j]
// For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
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
