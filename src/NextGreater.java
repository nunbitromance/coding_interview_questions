/*
Next Greater Element
March 17, 2011
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12     -->     -1
*/
public static void NextGreaterElement(int[] a)
{
	Stack<int> s = new Stack();
	s.Push(a[0]);
	int index = 0;
	int[] output = new int[a.Length];
	for (int i = 1; i < a.Length; i++)
	{
		if (a[i] < s.Peek())
		{
			while (s.Peek() < a[i])
			{
				Print(s.Pop(), a[i]);
			}
		}
		s.Push(a[i]);
	}
	
	Print(s.Pop(), -1);
} 