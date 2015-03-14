int maxSubArraySum(int a[], int size)
{
   int max_so_far = 0, max_ending_here = 0;
   int i;
   for(i = 0; i < size; i++)
   {
     max_ending_here = max_ending_here + a[i];
     if(max_ending_here < 0)
        max_ending_here = 0;
     if(max_so_far < max_ending_here)
        max_so_far = max_ending_here;
    }
    return max_so_far;
} 