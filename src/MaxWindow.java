/*
A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]
*/
public class MaxHeapComparator<int> : IComparator<int>
{
	public int CompareTo(int a, int b)
	{
		return a - b;
	}
}

public static int[] MaxWindow(int[] a, int w)
{
	PriorityQueue<int> pq = new PriorityQueue<int>(w, new MaxHeapComparator<int>());
	int[] b = new int[a.Length];
	int index = 0;
	
	for (int i = 0; i < w; i++)
	{
		pq.Insert(a[i]);
	}
	
	for (int i = 1; i < a.Length; i++)
	{
		if (pq.Size < w)
		{
			pq.Insert(a[i]);
		}
		else 
		{
			PriorityQueue<int> pq2 = new PriorityQueue<int>(w, new MaxHeapComparator<int>());
			while (pq.Size > 0)
			{
				if (pq.Peek() != a[i-1])
				{
					pq2.Insert(pq.Remove());
				}
			}
			pq2.Insert(a[i+w-1]);
			pq = pq2;
		}
		
		b[index++] = pq.Peek();
	}
	
	return b;
}
