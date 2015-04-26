/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

public class Solution {
    public int findPeakElement(int[] num) {
        
        return findPeakElement(num, 0, num.length - 1);
        
    }
    
    public int findPeakElement(int[] num, int lo, int hi) {
        if (hi - lo == 0) {
            return hi;
        } else if (hi - lo == 1) {
            return num[lo] > num[hi] ? lo : hi;
        }
        
        
        int mid = (lo + hi) / 2;
        
        if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
            return mid;
        } else if (num[mid] < num[mid + 1]) {
            return findPeakElement(num, mid + 1, hi);
        } else {
            return findPeakElement(num, lo, mid - 1);
        }
    }
}
