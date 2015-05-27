/*
 for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
 the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
*/
private KadaneResult kadane(int arr[]){
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;
        for(int i=0; i < arr.length; i++){
            maxSoFar += arr[i];
            if(maxSoFar < 0){
                maxSoFar = 0;
                currentStart = i+1;
            }
            if(max < maxSoFar){
                maxStart = currentStart;
                maxEnd = i;
                max = maxSoFar;
            }
        }
        return new KadaneResult(maxSoFar, maxStart, maxEnd);
    }
