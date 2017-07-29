/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

public KadaneResult kadane(int arr[]){
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int sumSoFar = 0;
        for(int i=0; i < arr.length; i++){
            sumSoFar += arr[i];
            if(sumSoFar < 0){
                sumSoFar = 0;
                currentStart = i+1;
            }
            if(max < sumSoFar){
                maxStart = currentStart;
                maxEnd = i;
                max = sumSoFar;
            }
        }
        return new KadaneResult(max, maxStart, maxEnd);
    }
