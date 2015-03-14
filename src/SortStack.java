/* sort stack in descending order
* push item to s2 if item is bigger than s2 top. if not, push all the bigger elements in s2 to s1. repeat.
*/
public static Stack sortStack(Stack s)
{
	Stack t = new Stack();
	while (s1.isEmpty() == false)
	{
		int temp = s1.pop();	
		while (s2.peek() > temp)
		{
			s1.push(s2.pop());
		}
		s2.push(temp);
	}
	return t;
}