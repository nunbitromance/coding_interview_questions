/* Implement stack that keeps track of min.
*/
public class StackWithMin<T> : Stack<T>
{
	private Stack<T> minStack;
	
	public StackWithMin<T>()
	{
		minStack = new Stack<T>();
	}
	
	public void push(T val)
	{
		if (minStack.count() > 0 && minStack.peek() > val)
		{
			minStack.push(val);
		}
		base.push(val);
	}
	
	public T pop()
	{
		T data = base.pop();
		if (data == minStack.peek())
		{
			minStack.pop();
		}
		return data;
	}
	
	public T min()
	{
		if (minStack.count() > 0)
		{
			return minStack.peek();
		}
		return null;
	}
}