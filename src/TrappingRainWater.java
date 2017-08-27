/*
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to 
trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being 
trapped. Thanks Marcos for contributing this image!
*/
public class Solution {
    public int trap(int[] height) {
        int w = 0;
        
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int maxLeft = height[0];
        int[] maxLefts = new int[height.length];
        int maxRight = height[height.length - 1];
        int[] maxRights = new int[height.length];
        
        for (int i = 1; i < maxLefts.length; i++) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            }
            maxLefts[i] = maxLeft;
        }
        
        for (int j = maxRights.length - 2; j >= 0; j--) {
            if (height[j] > maxRight) {
                maxRight = height[j];
            }
            maxRights[j] = maxRight;
        }
        
        for (int i = 1; i < height.length - 1; i++) {
            w += (Math.min(maxLefts[i], maxRights[i]) - height[i]);
        }
        
        return w;
    }
}
