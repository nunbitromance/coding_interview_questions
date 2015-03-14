/*
Find subsequence which adds to S

[1 3 -2 4 2 -1 5] 
S = 4
[1 3]
[-2 4 2]
[4]

int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
s = 23
output: 1 4
*/

public static void FindSubsequenceSum(int[] a, int s)
{
	int sum = 0;
	int start = 0;
	
	for (int i = 0; i < a.Length; i++)
	{
		while (sum > s)
		{
		    sum = sum - a[start];
			start = start + 1;
		}
		
		sum += a[i];
				if (sum == s)
		{
			Print(start, i);
		}
	}
}
