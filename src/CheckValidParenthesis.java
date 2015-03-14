/*1) Write a function that, given a string of parentheses, determines if it is balanced (returns true/false).

Examples:
"((()))()" and "" are balanced
")(" and "(()" are unbalanced*/
public static bool isValid(string s)
{
	int counter = 0;
	for (int i=0; i < s.Length; i++)
	{
		if (s[i] == '(')
		{
			counter++;
		}
		else if (s[i] == ')')
		{
			counter--;
		}
		
		if (counter < 0)
		{
			return false;
		}
	}
	return counter == 0;
}

/*2) Write a function that, given a string of parentheses '()', angle-brackets '<>', square brackets '[]' and brace brackets '{}', determines if everything is balanced.

Examples:
"[{{()<>}}]<>" is balanced
"[{{(<)>}}]<>" is not*/
public static bool isValid(string s)
{
	Stack<char> s = new Stack();
	for (int i=0; i<s.Length; i++)
	{
		if (s[i] == '(' || s[i] == '[' || s[i] == '{' || s[i] == '<')
		{
			s.Push(s[i]);
		}
		else if (s[i] == ')' || s[i] == ']' || s[i] == '}' || s[i] == '>')
		{
			if ((s[i] == ')' && s.Peek() != '(') 
			|| (s[i] == ']' && s.Peek() != '[') 
			|| (s[i] == '}' && s.Peek() != '{') 
			|| (s[i] == '>' && s.Peek() != '<'))
			{
				return false;
			}
			else
			{
				s.Pop();
			}
		}
	}
	return s.IsEmpty(); 
}