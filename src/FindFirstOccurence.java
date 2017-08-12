/*
Find first and last occurrences of an element in a sorted array
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Examples:

Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}    
        x = 5
Output : First Occurrence = 2
         Last Occurrence = 5

Input : arr[] = {1, 3, 5, 5, 5, 5 ,7, 123 ,125 }    
        x = 7
Output : First Occurrence = 6
         Last Occurrence = 6

An Efficient solution of this problem is to use binary search.
1. For first occurrence of a number

  a) If (high >= low)
  b) Calculate  mid = low + (high - low)/2;
  c) If ((mid == 0 || x > arr[mid-1]) && arr[mid] == x)
         return mid;
  d) Else if (x > arr[mid])
        return first(arr, (mid + 1), high, x, n);
  e) Else
        return first(arr, low, (mid -1), x, n);
  f) Otherwise return -1; 
2. For last occurrence of a number

  a) if (high >= low)
  b) calculate mid = low + (high - low)/2;
  c)if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
         return mid;
  d) else if(x < arr[mid])
        return last(arr, low, (mid -1), x, n);
  e) else
       return last(arr, (mid + 1), high, x, n);      
  f) otherwise return -1; 
  */



    /* if x is present in arr[] then returns the index of
    FIRST occurrence of x in arr[0..n-1], otherwise
    returns -1 */
    public static int first(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            int mid = low + (high - low)/2;
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
                return mid;
             else if(x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid -1), x, n);
        }
    return -1;
    }
