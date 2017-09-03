/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        return searchInsert(A, target, 0, A.length - 1);
    }
    
    private int searchInsert(int[] A, int target, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }
        
        int mid = (lo + hi) / 2;
        if (A[mid] == target) {
            return mid;
        } else if (A[mid] < target) {
            return searchInsert(A, target, mid + 1, hi);
        } else {
            return searchInsert(A, target, lo, mid - 1);
        }
    }
}
