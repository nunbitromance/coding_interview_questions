/***********************************************************************
 * Author: Isai Damier
 * Title: Find Kth Greatest Value
 * Project: geekviewpoint
 * Package: algorithms
 *
 * Statement:
 *   Given a list of values, find the highest kth. Assume indexing starts
 *   at one and not at zero so that the greatest number in the list is
 *   the 1st and not the 0th number.
 *
 * Time Complexity: average = O(n log n); worse O(n^2)
 * 
 * Sample Input: {21,3,34,5,13,8,2,55,1,19}; 4
 * Sample Output: 19
 * 
 * Details: This is a selection algorithm, where the task is to select
 *   an elite out of a group. In the sample input, for instance, we are
 *   to select the 4th greatest number in the list; which happens to be 13
 *   since 55, 34, and 21 are all greater than 13.
 * 
 *   Generally, selection algorithms are modified sort algorithms; where
 *   instead of sorting the whole list, we sort up to the kth value.
 *   Hence, a selection algorithm is bounded by whatever sort algorithm
 *   is used to implement it.
 * 
 *   Here for example we are using quickselect to find the kth largest
 *   value. Consequently, this algorithm is bounded by quicksort; leading
 *   to a worse case time complexity of O(n^2) and an average case
 *   time complexity of O( n log n).
 * 
 *   Note: Finding the kth largest is essentially the same as finding
 *   the kth smallest.
 * 
 **********************************************************************/
 public int quickselect(int[] G, int k) {
  return quickselect(G, 0, G.length - 1, k - 1);
}
 
private int quickselect(int[] G, int first, int last, int k) {
  if (first <= last) {
    int pivot = partition(G, first, last);
    if (pivot == k) {
      return G[k];
    }
    if (pivot > k) {
      return quickselect(G, first, pivot - 1, k);
    }
    return quickselect(G, pivot + 1, last, k);
  }
  return Integer.MIN_VALUE;
}
 
private int partition(int[] G, int first, int last) {
  int pivot = first + new Random().nextInt(last - first + 1);
  swap(G, last, pivot);
  for (int i = first; i < last; i++) {
    if (G[i] > G[last]) {
      swap(G, i, first);
      first++;
    }
  }
  swap(G, first, last);
  return first;
}
 
private void swap(int[] G, int x, int y) {
  int tmp = G[x];
  G[x] = G[y];
  G[y] = tmp;
}

public static int selectKth(int[] arr, int k) {
 if (arr == null || arr.length <= k)
  throw new Error();
 
 int from = 0, to = arr.length - 1;
 
 // if from == to we reached the kth element
 while (from < to) {
  int r = from, w = to;
  int mid = arr[(r + w) / 2];
 
  // stop if the reader and writer meets
  while (r < w) {
 
   if (arr[r] >= mid) { // put the large values at the end
    int tmp = arr[w];
    arr[w] = arr[r];
    arr[r] = tmp;
    w--;
   } else { // the value is smaller than the pivot, skip
    r++;
   }
  }
 
  // if we stepped up (r++) we need to step one down
  if (arr[r] > mid)
   r--;
 
  // the r pointer is on the end of the first k elements
  if (k <= r) {
   to = r;
  } else {
   from = r + 1;
  }
 }
 
 return arr[k];
}

/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example, given [3,2,1,5,6,4] and k = 2, return 5.

Note: You may assume k is always valid, 1 ≤ k ≤ array's length.

Java Solution 1 - Sorting

public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
}
Time is O(nlog(n)).

Java Solution 2 - Quick Sort

This problem can also be solved by using quickselect, which is similar to quicksort.
*/
public int findKthLargest(int[] nums, int k) {
	if (k < 1 || nums == null) {
		return 0;
	}
 
	return getKth(nums.length - k +1, nums, 0, nums.length - 1);
}
 
public int getKth(int k, int[] nums, int start, int end) {
 
	int pivot = nums[end];
 
	int left = start;
	int right = end;
 
	while (true) {
 
		while (nums[left] < pivot && left < right) {
			left++;
		}
 
		while (nums[right] >= pivot && right > left) {
			right--;
		}
 
		if (left == right) {
			break;
		}
 
		swap(nums, left, right);
	}
 
	swap(nums, left, end);
 
	if (k == left + 1) {
		return pivot;
	} else if (k < left + 1) {
		return getKth(k, nums, start, left - 1);
	} else {
		return getKth(k, nums, left + 1, end);
	}
}
 
public void swap(int[] nums, int n1, int n2) {
	int tmp = nums[n1];
	nums[n1] = nums[n2];
	nums[n2] = tmp;
}
Average case time is O(n), worst case time is O(n^2).
