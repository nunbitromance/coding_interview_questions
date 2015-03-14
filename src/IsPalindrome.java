/*
is string palindrome? "abcba" => true, "aab" = false
*/
public static bool isPalindrome(string s)
{
	bool isPalindrome = true;
	
	int begin = 0; int end = s.length - 1;
	
	while (begin < end)
	{
		if (s[begin++] != s[end--])
		{
			isPalindrome = false;
			break;
		}
	}
	return isPalindrome;
}

/*
is linked list palindrome? 1->2->3->2->1 => true, 1->2->3->2->2 => false, 1->2->2->1 => true
*/
public static bool isPalindrome(Node head)
{
	bool isPalindrome = true;
	
	Node p1 = head;
	Node p2 = head;
	Stack<int> s = new Stack<int>();
	
	while (p2.Next != null)
	{
		p1 = p1.Next;
		p2 = p2.Next.Next;
		s.insert(p1.Value);
	}
	
	if (p2 != null)
	{
		p1 = p1.Next;
	}
	
	while (p1 != null)
	{
		int top = s.pop();
		if (top != p1.Value)
		{
			return false;
		}
		p1 = p1.Next;
	}
	return true;
}

/*
is integer a palindrome?
12321 -> true, 12333 -> false
*/
public static bool IsPalindrome(int n)
{
	int div = 1;
	int k = n;
	while (k)
	{
		k /= 10;
		div *= 10;
	}

	k = n;
	while (k > 0)
	{
		if (k % 10 != k / div)
		{
			return false;
		}
		// 12321 % 10000 = 2321
		k %= div;
		// 1000
		div /= 10;
	}
	return true;
}
