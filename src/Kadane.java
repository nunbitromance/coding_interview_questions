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
