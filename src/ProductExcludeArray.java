/*
A Product Array Puzzle
May 18, 2010
Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).

Example:
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}

Algorithm:
1) Construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i] excluding arr[i].
2) Construct another temporary array right[] such that right[i] contains product of all elements on on right of arr[i] excluding arr[i].
3) To get prod[], multiply left[] and right[].
*/
public static int[] ProductExclude(int[] a)
{
	int[] product = new int[a.Length];
	
	int[] left = new int[a.Length];
	int[] right = new int[a.Length];
	
	int p = 1;
	for (int i = 0; i < a.Length; i++)
	{
		p = p * a[i];
		left[i] = p;
	}
	
	p = 1;
	for (int i = a.Length - 1; i >= 0; i--)
	{
		p = p * a[i];
		right[i] = p;
	}
	
	for (int i = 0; i < a.Length; i++)
	{
		product[i] = (i-1 < 0) ? 1 : left[i-1] * (i+1 >= a.Length) ? 1 : right[i+1];
	}
	
	return product;
}