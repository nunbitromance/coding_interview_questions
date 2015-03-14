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