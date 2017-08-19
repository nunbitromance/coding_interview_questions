/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

https://leetcode.com/problems/wiggle-sort/description/
*/

class Solution {
    public void wiggleSort(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i+1]) {
                    swap(nums, i, i+1);
                }
            } else {
                if (nums[i] < nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
            less = !less;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
