/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

public class Solution {
    public int maxSubArray(int[] arr) {
        int maxSumSoFar = arr[0];
        int sumSoFar = arr[0];
        int left = 0;
        int maxRight = 0;
        int maxLeft = 0;
        
        for (int i = 1; i < arr.length; i++) {
            sumSoFar += arr[i];
            
            if (sumSoFar < 0) {
                sumSoFar = i+1 < arr.length ? arr[i+1] : arr[i];
                left = i+1 : i;
            }
            if (sumSoFar > maxSumSoFar) {
                maxSumSoFar = sumSoFar;
                maxLeft = left;
                maxRight = i;
            }
        }
        
        return maxSumSoFar;
    }
}
