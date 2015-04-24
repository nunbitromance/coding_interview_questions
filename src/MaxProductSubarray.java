/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Solution:

This is similar to maximum subarray. Instead of sum, the sign of number affect the product value.

When iterating the array, each element has two possibilities: positive number or negative number. We need to track a minimum value, so that when a negative number is given, it can also find the maximum value. We define two local variables, one tracks the maximum and the other tracks the minimum.
*/
public int maxProduct(int[] A) {
    if(A==null || A.length==0)  
        return 0;  
 
    int maxLocal = A[0];  
    int minLocal = A[0];  
    int global = A[0];  
 
    for(int i=1; i<A.length; i++){  
        int temp = maxLocal;  
        maxLocal = Math.max(Math.max(A[i]*maxLocal, A[i]), A[i]*minLocal);  
        minLocal = Math.min(Math.min(A[i]*temp, A[i]), A[i]*minLocal);  
        global = Math.max(global, maxLocal);  
    }  
    return global;
}

// Mine.

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
