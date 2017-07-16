/*
12 -5 4 -8 11
ans should contain 11+12=23

now in first run of kadane algorithm we look for subarray with max sum in first run it will return 12

now in for loop we add all the elements and change sign so after for loop our array is -12 5 -4 8 -11 and sum is 14

when we run again kadane algorithm it will give that part of array which has actually min sum in this case -9 .

so kadane wil return 9 as we have changed sign of all the array and then we remove that part from sum which has 

minimum sum max_wrap + kadane(a, n);

then we return max of first run of kadane and ans we got after removing that part which has minimum sum.
*/

public int maxSubarrayCicular(int[] arr) {
  int maxSum = kadane(arr);
  int sum = 0;
  for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
    arr[i] *= -1;
  }
  int minSum = kadane(arr);
  return Math.max(maxSum, sum + minSum);
}

private int kadane(int[] arr) {
  int maxSum = 0;
  int curSum = 0;
  for (int i = 0; i < arr.length; i++) {
    curSum += arr[i];
    if (curSum < 0) {
      curSum = 0;
    }
    maxSum = Math.max(curSum, maxSum);
  }
  return maxSum;
}
