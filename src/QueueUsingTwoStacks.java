public class MyQueue<T>
{
	private Stack<T> s1;
	private Stack<T> s2;
	
	public MyQueue<T>()
	{
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void enqueue(T item)
	{
		s1.push(item);
	}
	
	public T dequeue()
	{
		while (s1.isEmpty() == false)
		{
			s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	public T peek()
	{
		while (s1.isEmpty() == false)
		{
			s2.push(s1.pop());
		}
		return s2.peek();
	}
}