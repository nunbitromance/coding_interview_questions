package com.interview.dynamic;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 
 Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.

Examples

arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.
Following are the two main steps to solve this problem:
1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.

The first step is simple. The second step is crucial, it can be solved either using recursion or Dynamic Programming.

 */
public class SubsetSum {

    public boolean partition(int arr[]){
        int sum =0;
        for(int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        
        if(sum % 2 != 0){
            return false;
        }
        sum = sum/2;
        boolean[][] T = new boolean[arr.length+1][sum+1];
        
        for(int i=0; i <= arr.length; i++){
            T[i][0] = true;
        }
        
        for(int i=1; i <= arr.length; i++){
            for(int j=1; j <= sum; j++){
                if(j - arr[i-1] >= 0){
                    T[i][j] = T[i-1][j - arr[i-1]] || T[i-1][j];
                }
            }
        }
        return T[arr.length][sum];
    }
    
    public static void main(String args[]){
        SubsetSum ss = new SubsetSum();
        int arr[] = {1,3,5,5,2,1,1,6};
        boolean r = ss.partition(arr);
        System.out.print(r);
    }
}
