/*
http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
Given an unsorted integer array, find the first missing positive integer. For example, given [1,2,0] return 3 and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Analysis

This problem can solve by using a bucket-sort like algorithm. Let's consider finding first missing positive and 0 first. The key fact is that the ith element should be i, so we have:
i==A[i]
A[i]==A[A[i]]


*/
public int firstMissingPositive(int[] A) {
        int n = A.length;
 
    	for (int i = 0; i < n; i++) {
    		while (A[i] != i + 1) {
    			if (A[i] <= 0 || A[i] >= n)
    				break;
 
                	if(A[i]==A[A[i]-1])
                    		break;
 
    			int temp = A[i];
    			A[i] = A[temp - 1];
    			A[temp - 1] = temp;
    		}
    	}
 
    	for (int i = 0; i < n; i++){
    		if (A[i] != i + 1){
    			return i + 1;
    		}
    	}	
 
    	return n + 1;
}
