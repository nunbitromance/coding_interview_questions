
/*
  without indexes
*/
class Main
{
    // Function to find the maximum sum of a contiguous subarray
    // in a given integer array
    public static int kadane(int[] A)
    {
        // stores the maximum sum subarray found so far
        int maxSoFar = 0;
 
        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;
 
        // traverse the given array
        for (int i: A)
        {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index `i-1`)
            maxEndingHere = maxEndingHere + i;
 
            // if the maximum sum is negative, set it to 0 (which represents
            // an empty subarray)
            maxEndingHere = Integer.max(maxEndingHere, 0);
 
            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }
 
        return maxSoFar;
    }
 
    public static void main(String[] args)
    {
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
 
        System.out.println("The sum of contiguous subarray with the " +
                            "largest sum is " + kadane(A));
    }
}

/*
 for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
 the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
*/
private KadaneResult kadane(int arr[]){
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
