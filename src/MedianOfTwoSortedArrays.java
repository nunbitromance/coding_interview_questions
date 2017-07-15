package com.interview.binarysearch;

/**
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
/* Explanation:
This method works by first getting medians of the two sorted arrays and then comparing them.

Let ar1 and ar2 be the input arrays.

Algorithm:

1) Calculate the medians m1 and m2 of the input arrays ar1[] 
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one 
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one    
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays 
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get 
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
    */
public class MedianOfTwoSortedArray {

    public double median(int arr1[],int arr2[]){
        int low1 = 0;
        int high1 = arr1.length-1;
        
        int low2 = 0;
        int high2 = arr2.length-1;

        while(true){
            
            if(high1 == low1){
                return (arr1[low1] + arr2[low2])/2;
            }
            
            if(high1 - low1 == 1){
                return (double)(Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2]))/2;
            }
            
            double med1 = getMedian(arr1,low1,high1);
            double med2 = getMedian(arr2,low1,high2);
            if(med1 <= med2){
                if((high1-low1 + 1) % 2 == 0){
                    low1 = (high1+low1)/2;
                    high2 = (high2+low2)/2 + 1;
                }else{
                    low1 = (low1+high1)/2;
                    high2 = (low2+high2)/2;
                }
            }
            else{
                if((high1-low1 + 1) % 2 == 0){
                    low2 = (high2+low2)/2;
                    high1 = (high1+low1)/2 + 1;
                }else{
                    low2 = (low2+high2)/2;
                    high1 = (low1+high1)/2;
                }
            }
        }
    }
    
    private double getMedian(int arr[],int low,int high){
        int len = high - low+1;
        if(len % 2 == 0){
            return (arr[low + len/2] + arr[low+ len/2-1])/2;
        }else{
            return arr[low+len/2];
        }
    }
    
    public static void main(String args[]){
        int arr1[] = {1,2,3,4,6};
        int arr2[] = {-1,5,6,7,8};
        MedianOfTwoSortedArray mts = new MedianOfTwoSortedArray();
        System.out.println(mts.median(arr1, arr2));
    }
    
}
