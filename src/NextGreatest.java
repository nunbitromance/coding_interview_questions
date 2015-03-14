/*
Replace every element with the next greatest
August 30, 2012
Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1. 
For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.
*/
public static void NextGreatest(int[] a)
{
	int maxSoFar = a[a.Length - 1];
	a[a.Length - 1] = -1;
	
	for (int i = a.Length-1; i >= 0; i--)
	{
		int temp = a[i];
		a[i] = maxSoFar;
		if (temp > maxSoFar)
		{
			maxSoFar = temp;
		}
	}
}