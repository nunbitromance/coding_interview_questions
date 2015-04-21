/* implement three stacks using a single array
 * approach: stack1 grows from beginning of array, stack 2 grows from end of array to opposite direction
 * stack3 grows at 1/3 of array in right direction.
 */
public class Stacks<T>
{
	private T[] array;
	private int stack1Top;
	private int stack2Top;
	private int stack3Start;
	private int stack3Top;
		
	public Stacks<T>(int initialSize)
	{
		array = new T[initialSize];
		stack1Top = -1;
		stack2Top = initialSize;
		stack3Start = (initialSize) / 3;
		stack3Top = stack3Start - 1;
	}
	
	public void push(int stackNum, T val)
	{
		if (stackNum == 1 && stack1Top < stack3Start-1)
		{
			array[++stack1Top] = val;
		}
		else if (stackNum == 2 && stack2Top > stack3Top + 1)
		{
			array[--stack2Top] = val;
		}
		else if (stackNum == 3 && stack3Top < stack2Top - 1)
		{
			array[++stack3Top] = val;
		}
		else
		{
			throw new Exception(string.format("stack overflow {0}", stackNum));
		}
	}
	
	public T pop(int stackNum)
	{
		T data = null;
		if (stackNum == 1 && stack1Top >= 0)
		{
			data = array[stack1Top];
			array[stack1Top--] = null;
		}
		else if (stackNum == 2 && stack2Top <= array.length - 1)
		{
			data = array[stack2Top];
			array[stack2Top++] = null;
		}
		else if (stackNum == 3)
		{
			data = array[stack3Top];
			array[stack3Top--] = null;
		}
		else
		{
			throw new Exception(string.format("stack is already empty {0}", stackNum));
		}
	}
}

// more efficient implementation

// A C++ program to demonstrate implementation of k stacks in a single 
// array in time and space efficient way
#include<iostream>
#include<climits>
using namespace std;
 
// A C++ class to represent k stacks in a single array of size n
class kStacks
{
    int *arr;   // Array of size n to store actual content to be stored in stacks
    int *top;   // Array of size k to store indexes of top elements of stacks
    int *next;  // Array of size n to store next entry in all stacks
                // and free list
    int n, k;
    int free; // To store beginning index of free list
public:
    //constructor to create k stacks in an array of size n
    kStacks(int k, int n);
 
    // A utility function to check if there is space available
    bool isFull()   {  return (free == -1);  }
 
    // To push an item in stack number 'sn' where sn is from 0 to k-1
    void push(int item, int sn);
 
    // To pop an from stack number 'sn' where sn is from 0 to k-1
    int pop(int sn);
 
    // To check whether stack number 'sn' is empty or not
    bool isEmpty(int sn)  {  return (top[sn] == -1); }
};
 
//constructor to create k stacks in an array of size n
kStacks::kStacks(int k1, int n1)
{
    // Initialize n and k, and allocate memory for all arrays
    k = k1, n = n1;
    arr = new int[n];
    top = new int[k];
    next = new int[n];
 
    // Initialize all stacks as empty
    for (int i = 0; i < k; i++)
        top[i] = -1;
 
    // Initialize all spaces as free
    free = 0;
    for (int i=0; i<n-1; i++)
        next[i] = i+1;
    next[n-1] = -1;  // -1 is used to indicate end of free list
}
 
// To push an item in stack number 'sn' where sn is from 0 to k-1
void kStacks::push(int item, int sn)
{
    // Overflow check
    if (isFull())
    {
        cout << "\nStack Overflow\n";
        return;
    }
 
    int i = free;      // Store index of first free slot
 
    // Update index of free slot to index of next slot in free list
    free = next[i];
 
    // Update next of top and then top for stack number 'sn'
    next[i] = top[sn];
    top[sn] = i;
 
    // Put the item in array
    arr[i] = item;
}
 
// To pop an from stack number 'sn' where sn is from 0 to k-1
int kStacks::pop(int sn)
{
    // Underflow check
    if (isEmpty(sn))
    {
         cout << "\nStack Underflow\n";
         return INT_MAX;
    }
 
 
    // Find index of top item in stack number 'sn'
    int i = top[sn];
 
    top[sn] = next[i];  // Change top to store next of previous top
 
    // Attach the previous top to the beginning of free list
    next[i] = free;
    free = i;
 
    // Return the previous top item
    return arr[i];
}
