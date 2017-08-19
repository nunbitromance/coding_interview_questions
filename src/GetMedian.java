/*
https://leetcode.com/problems/find-median-from-data-stream/description/
295. Find Median from Data Stream
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
Credits:
*/

class MedianFinder {
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        low = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        high = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
    }
    
    public void addNum(int num) {
        if (low.size() > high.size()) {
            if (high.size() > 0 && num > high.peek()) {
                high.offer(num);
            } else {
                low.offer(num);
                int maxLow = low.poll();
                high.offer(maxLow);
            }
        } else if (low.size() < high.size()) {
            if (low.size() > 0 && num < low.peek()) {
                low.offer(num);
            } else {
                high.offer(num);
                int minHigh = high.poll();
                low.offer(minHigh);
            }
        } else {
            if (low.size() > 0 && num < low.peek()) {
                low.offer(num);
            } else {
                high.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else if (low.size() < high.size()) {
            return high.peek();
        } else {
            return (double)low.peek() + ((double)(high.peek() - low.peek()) / 2.0);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


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
