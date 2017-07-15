Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      int minLength = nums.length;
    	int start = 0;
    	int end = 0;
    	int sum = 0;
    
    	while (end < nums.length) {
    		while (sum < s && end < nums.length) {
    			sum += nums[end++];
    		}
    
    		while (sum >= s && start < nums.length) {
    			minLength = Math.min(end - start, minLength);
    			sum -= nums[start++];
    		}
    	}
    	
    	if (sum < s && minLength == nums.length) {
    	    return 0;
    	}
    	
    	return minLength;
    }
}

public int minSubArrayLen(int s, int[] a) {
  if (a == null || a.length == 0)
    return 0;
  
  int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
  
  while (j < a.length) {
    sum += a[j++];
    
    while (sum >= s) {
      min = Math.min(min, j - i);
      sum -= a[i++];
    }
  }
  
  return min == Integer.MAX_VALUE ? 0 : min;
}
