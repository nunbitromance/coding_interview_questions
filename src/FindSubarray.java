/*
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
*/

/* Returns true if the there is a subarray of arr[] with sum equal to 'sum'
   otherwise returns false.  Also, prints the result */
int subArraySum(int arr[], int n, int sum)
{
    /* Initialize curr_sum as value of first element
       and starting point as 0 */
    int curr_sum = arr[0], start = 0, i;
 
    /* Add elements one by one to curr_sum and if the curr_sum exceeds the
       sum, then remove starting element */
    for (i = 1; i <= n; i++)
    {
        // If curr_sum exceeds the sum, then remove the starting elements
        while (curr_sum > sum && start < i-1)
        {
            curr_sum = curr_sum - arr[start];
            start++;
        }
 
        // If curr_sum becomes equal to sum, then return true
        if (curr_sum == sum)
        {
            printf ("Sum found between indexes %d and %d", start, i-1);
            return 1;
        }
 
        // Add this element to curr_sum
        if (i < n)
          curr_sum = curr_sum + arr[i];
    }
 
    // If we reach here, then no subarray
    printf("No subarray found");
    return 0;
}

public Pair<Integer, Integer> findSubarrayWithSum(int[] arr, int sum) {
   // validation
   int prefixSum = 0;
   int start = -1;
   int end = -1;
   Map<Integer, Integer> map = new HashMap<Integer, Integer>();
   for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i];
      if (arr[i] == sum) {
         start = i;
         end = i;
         break;
      } else if (prefixSum == sum) {
         start = 0;
         end = i;
         break;
      } else if (map.containsKey(prefixSum - sum)) {
         start =  map.get(prefixSum - sum) + 1;
         end = i;
         break;
      }
      map.put(prefixSum, i);
   }
   
   return Pair.of(start, end);
}
}
