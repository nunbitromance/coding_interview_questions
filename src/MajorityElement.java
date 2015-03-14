/*
A non-empty zero-indexed array A consisting of N integers is given. The leader of this array is the value that occurs in more than half of the elements of A. http://www.careercup.com/question?id=15206756
Write a function 
int arrLeader(int A[], int N); 
that, given a non-empty zero-indexed array A consisting of N integers, returns the leader of array A. The function should return -1 if array A does not contain a leader. 
Assume that: 
N is an integer within the range [1..1,000,000]; 
each element of array A is an integer within the range [0..2147483647]. 
For example, given array A consisting of ten elements such that: 
A[0] = 4 A[1] = 2 A[2] = 2 
A[3] = 3 A[4] = 2 A[5] = 4 
A[6] = 2 A[7] = 2 A[8] = 6 
A[9] = 4 
the function should return ?1, because the value that occurs most frequently in the array, 2, occurs 5 times, and 5 is not more than half of 10. 
Given array A consisting of five elements such that: 
A[0] = 100 A[1] = 1 A[2] = 1 
A[3] = 50 A[4] = 1 
the function should return 1. 
Complexity: 
expected worst-case time complexity is O(N); 
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments). 
Elements of input arrays can be modified.

// Moore's Voting algorithm
// http://www.geeksforgeeks.org/majority-element/
*/
public static int MajorityElement(int[] a)
{
	// validation
	
	int candidate = a[0];
	int count = 1;
	
	for (int i = 1; i < a.Length; i++)
	{
		if (a[i] == candidate)
		{
			count++;
		}
		else
		{
			count--;
		}
		
		if (count == 0)
		{
			// switch the candidate
			candidate = a[i];
		}
	}
	
	// check majority
	count = 0;
	for (int i = 0; i < a.Length; i++)
	{
		if (a[i] == candidate)
		{
			count++;
		}
	}
	
	return count > a.Length / 2 ? candidate : -1;
}