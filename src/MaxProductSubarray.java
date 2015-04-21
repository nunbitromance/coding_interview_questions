/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.*/

public class Solution {
    public int maxProduct(int[] A) {
        int maxProduct = A[0];
        int minProduct = A[0];
        int curProduct = A[0];
        for (int i = 1; i < A.length; i++) {
            curProduct *= A[i];
            if (curProduct <= 0) {
                curProduct = A[i];
            }
            if (A[i] < 0) {
                if (curProduct > maxProduct) {
                    maxProduct = A[i] * curProduct;
                }
            }
            if (maxProduct < curProduct) {
                maxProduct = curProduct;
            }
            if (minProduct > curProduct) {
                minProduct = curProduct;
            }
        }
        return maxProduct;
    }
}
