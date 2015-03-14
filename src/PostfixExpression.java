// solve postfix expression 345+*612+/-
public static int Solve(string exp)
{
	Stack<int> s = new Stack<int>();
	
	int i = 0;
	
	while (i < exp.Length)
	{
		char c = exp[i];
		
		if (IsOperation(c))
		{
			int b = s.Pop();
			int a = s.Pop();
			int c = 0;
			switch (c):
			{
				case '+':
					c = a + b;
					break;
				
				case '-':
					c = a - b;
					break;
				
				case '*':
					c = a * b;
					break;
				
				case '/':
					c = a / b;
					break;
				
				default:
				throw new Exception("invalid expression");
			}
			s.Push(c);
		}
		else if (c >= '0' && c <= '9')
		{
			s.Push(c - '0');
		}
		else
		{
			throw new Exception("invalid character");
		}
		i++;
	}
	
	return s.Peek();
}

private static bool IsOperation(char c)
{
	return c == '+' || c == '-' || c == '*' || c == '/';
}