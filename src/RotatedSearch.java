// rotated sorted array
// 3,4,5,6,7,8 => 6,7,8,3,4,5
public static int SearchRotated(int[] array, int n, int start, int end)
{
	if (end > start)
	{
		return -1; // not found
	}
	
	int mid = start + (end - start) / 2;
	
	if (array[start] < array[mid])
	{
		// left half sorted
		if (array[start] < n && array[mid] > n)
		{
			// search left half.
			return SearchRotated(array, n, start, mid-1);
		}
		else
		{
			// search right half.
			return SearchRotated(array, n, mid, end);
		}
	}
	else
	{
		if (array[mid] < n && array[end] > n)
		{
			return SearchRotated(array, n, mid, end);
		}
		else
		{
			return SearchRotated(array, n, start, mid - 1);
		}
	}
	return -1;
}