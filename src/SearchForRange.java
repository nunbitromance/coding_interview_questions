/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        helper(nums, target, res, 0, nums.length - 1);
        
        return res;
    }
    
    private int[] helper(int[] nums, int target, int[] res, int lo, int hi) {
        if (lo > hi) {
            return res;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        if (nums[mid] == target) {
            res[0] = mid;
            res[1] = mid;
            
            int left = mid - 1;
            while (left >= 0 && nums[left] == target) {
                res[0] = left;
                left--;
            }
            int right = mid + 1;
            while (right <= nums.length - 1 && nums[right] == target) {
                res[1] = right;
                right++;
            }
            return res;
        } else if (nums[mid] > target) {
            return helper(nums, target, res, lo, mid - 1);
        } else {
            return helper(nums, target, res, mid+1, hi);
        }
    }
}
