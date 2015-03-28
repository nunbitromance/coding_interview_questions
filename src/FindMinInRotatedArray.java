/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.*/

public class Solution {
    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }
    
    private int findMin(int[] num, int begin, int end) {
        if (begin > end) {
            return num[0];
        }
        
        int middle = (begin+end)/2;

        if (middle + 1 < num.length && num[middle] > num[middle + 1]) {
            return num[middle+1];
        } else if (middle - 1 >= 0 && num[middle] < num[middle-1]) {
            return num[middle];
        }
        if (num[middle] < num[end]) {
            return findMin(num, begin, middle - 1);
        }
        return findMin(num, middle+1, end);
    }
}
