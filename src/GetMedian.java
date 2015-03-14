

public class MedianGenerator
{
	private PrirorityQueue<int> minHeap, maxHeap;

	public MedianGenerator()
	{
		minHeap = new PriorityQueue<int>(new MinHeapComparator());
		maxHeap = new PriorityQueue<int>(new MaxHeapComparator());
	}
	
	private class MinHeapComparator
	{
		// if a < b return negative, a = 0 return 0, a > b return positive
		public int compareTo(int a, int b)
		{
			return a.compareTo(b);
		}
	}
	
	private class MaxHeapComparator
	{
		// if a < b return negative, a = 0 return 0, a > b return positive
		public int compareTo(int a, int b)
		{
			return -1 * a.compareTo(b);
		}
	}
}

public void addNumber(int a)
{
	if (maxHeap.size() < minHeap.size())
	{
		if (minHeap.peek() > a)
		{
			// insert into maxHeap.
			maxHeap.offer(a);
		}
		else
		{
			maxHeap.offer(minHeap.poll());
			maxHeap.offer(a);
		}
	}
	else if (maxHeap.size() == minHeap.size())
	{
		if (minHeap.peek() > a)
		{
			minHeap.offer(maxHeap.poll());
			maxHeap.offer(a);
		}
		else
		{
			maxHeap.offer(minHeap.poll());
			minHeap.offer(a);
		}
	}
	else
	{
		if (maxHeap.peek() < a)
		{
			minHeap.offer(a);
		}
		else
		{
			maxHeap.offer(minHeap.peek());
			minHeap.offer(a);
		}
	}
}

public int getMedian()
{
	if (maxHeap.size() == minHeap.size())
	{
		return (maxHeap.peek() + minHeap.peek())/2;
	}
	else
	{
		if (maxHeap.size() > minHeap.size())
		{
			return maxHeap.peek();
		}
		else
		{
			return minHeap.peek();
		}
	}
}