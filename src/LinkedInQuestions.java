1. Compute square-root of a number x. http://www.careercup.com/question?id=4419686

2. Implement a function to solve an string given in reverse polish notation.

3. Given an interface called IntStream with methods 'bool hasNext()' and 'int next()', implement the function 'IntStream merge(IntStream[] streams)' 
where each input IntStream produces strictly increasing, possibly infinite number of, integers, and the resultant IntStream also produces 
strictly increasing integers by merging the input streams. 
The interviewer also provides a simple test harness that prints the first 5000 integers from that function. 

4. Given a single-line text string and a maximum width value, write the function 'string justify(string text, int maxWidth)' http://www.careercup.com/question?id=9842871
that formats the input text using full-justification, 
i.e., extra spaces on each line are equally distributed between the words; 
the first word on each line is flushed left and the last word on each line is flushed right. 

// "hello world", 20 => "    hello     world   "
public static string Justify(string text, int maxWidth)
{
	StringBuilder sb = new StringBuilder();
	
	int i = 0;
	int count = 0;
	while (i < text.Length)
	{
		if (text[i] == ' ')
		{
			count++;
		}
		i++;
	}
	int totalAllowed = maxWidth - (text.Length - count);
	int space = totalAllowed /	count + 2; // blank count + left and right
	
	for (int i = 0; i < text.Length; i++)
	{
		if (text[i] == ' ')
		{
			for (int j = 0; j < space; j++)
			{
				sb.Append(' ');
			}
		}
		else
		{
			sb.Append(text[i]);
		}
	}
	
	return sb.toString();
}

5. Write an iterative version of a recursive function. Yes, it sounds basic, and yes it's easy to do for many problems (tree walking, Fibonacci series, etc). This wasn't one of the straightforward cases.  

6. Write a routine to find all collinear points in a plane. Constraint: The time complexity cannot be greater than O(n^2).

7. Write put/get methods for a BlockingQueue

8. Describe a routine which returns the set of integers in {1..100} divisible without remainder by 3 but not by 9.  

9. filteriterator hasnext() and next() function

10. Design a hangman game

11. given like +77288.100, a772sb, 2000.00.11.
return if it's a number.
you could either write a regular expression or simply go through the string.
1. it should start with "+/-" or "0-9".
2. there should only have one "." in the string.
3. all other character are "0-9"
that's it.

12. Design a function to determine whether a graph is bipartite

// PRE: All nodes have color None.
// POST: Checks whether graph is bipartite
public static bool isBipartite(Node root)
{
	Queue<Node> q = new Queue<Node>();
	// color = blud or red
	root.Color = Color.Blue;
	q.enqueue(root);
	
	while (q.isEmpty() == false)
	{
		Node cur = q.dequeue();
		foreach (Node child in cur.getChildren())
		{
			if (child.Color == Color.Red)
			{
				return false;
			}
			else if (child.Color = Color.None)
			{
				child.Color = Color.Red;
				q.enqueue(child);
			}
		}
	}
	return true;
}

public static bool isBipartite(Node root)
{
	Stack<Node> s = new Stack<Node>();
	// color = blud or red
	root.Color = Color.Blue;
	q.push(root);
	
	while (s.isEmpty() == false)
	{
		Node cur = q.pop();
		
		foreach (Node child in cur.getChildren())
		{
			if (child.Color == Color.Red)
			{
				return false;
			}
			else if (child.Color = Color.None)
			{
				child.Color = Color.Red;
				q.push(child);
			}
		}
	}
	return true;
}


13. A non-empty zero-indexed array A consisting of N integers is given. The leader of this array is the value that occurs in more than half of the elements of A. http://www.careercup.com/question?id=15206756
Write a function 
int arrLeader(int A[], int N); 
that, given a non-empty zero-indexed array A consisting of N integers, returns the leader of array A. The function should return -1 if array A does not contain a leader. 
Assume that: 
N is an integer within the range [1..1,000,000]; 
each element of array A is an integer within the range [0..2147483647]. 
For example, given array A consisting of ten elements such that: 
A[0] = 4 A[1] = 2 A[2] = 2 
A[3] = 3 A[4] = 2 A[5] = 4 
A[6] = 2 A[7] = 2 A[8] = 6 
A[9] = 4 
the function should return ?1, because the value that occurs most frequently in the array, 2, occurs 5 times, and 5 is not more than half of 10. 
Given array A consisting of five elements such that: 
A[0] = 100 A[1] = 1 A[2] = 1 
A[3] = 50 A[4] = 1 
the function should return 1. 
Complexity: 
expected worst-case time complexity is O(N); 
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments). 
Elements of input arrays can be modified.

// Moore's Voting algorithm
// http://www.geeksforgeeks.org/majority-element/
public static int major(int[] A)
{
	int count = 1;
	int majorIndex = 0;
	
	for (int i = 1; i<A.length; i++)
	{
		if (A[i] == A[majorIndex])
		{
			count++;
		}
		else
		{
			count--;
		}
		
		if (count == 0)
		{
			majorIndex = i;
			count = 1;
		}
	}
	
	// Check majority
	count = 0;
	for (int i = 0; i < A.length; i++)
	{
		if (A[i] == A[majorIndex])
		{
			count++;
		}
	}
	
	return count > (A.length / 2) ? A[majorIndex] : -1;
}

14. Consider this string representation for binary trees. http://www.careercup.com/question?id=13262681
Each node is of the form (lr), where l represents the left child and r represents the right child. If l is the character 0, then there is no left child. Similarly, if r is the character 0, then there is no right child. Otherwise, the child can be a node of the form (lr), and the representation continues recursively. 
For example: (00) is a tree that consists of one node. ((00)0) is a two-node tree in which the root has a left child, and the left child is a leaf. And ((00)(00)) is a three-node tree, with a root, a left and a right child. 

Write a function that takes as input such a string, and returns -1 if the string is malformed, and the depth of the tree if the string is well-formed. 

For instance: 

find_depth('(00)') -> 0 
find_depth('((00)0)') -> 1 
find_depth('((00)(00))') -> 1 
find_depth('((00)(0(00)))') -> 2 
find_depth('((00)(0(0(00))))') -> 3 
find_depth('x') -> -1 
find_depth('0') -> -1 
find_depth('()') -> -1 
find_depth('(0)') -> -1 
find_depth('(00)x') -> -1 
find_depth('(0p)') -> -1

15. Edit distance dynamic programming question
E(i, j) = min( [E(i-1, j) + D], [E(i, j-1) + I],  [E(i-1, j-1) + R if i,j characters are not same])

public static double sqrt(double n, int s, int e)
{
	double mid = (s + e) / 2;
	
	double c = mid * mid;
	double epsilon = 0.000001;
	if (c > n - epsilon && c < n + epsilon)
	{
		return mid;
	}
	else if (c > n)
	{
		return sqrt(n, s, mid);
	}
	return sqrt(n, mid, e);
}

public static int pow(int n, int k)
{
	if (k == 0)
	{
		return 1;
	}

	int p = pow(n, k/2);
	
	if (k % 2 == 0)
	{
		return p * p;
	}
	else
	{
		return p * p * n;
	}
}

16. Consider an X x Y array of 1's and 0s. The X axis   represents "influences" meaning that X influences Y. So, for example, if $array[3,7] is 1 that means that 3 influences 7. An "influencer" is someone who influences every other person, but is not influenced by any other member. Given such an array, write a function to determine whether or not an "influencer" exists in the array. 

public boolean isInfluencerExists(int[][] graph) {
	int[] degreeIn = new int[graph.length];
	int[] degreeOut = new int[graph.length];
	
	for (int i = 0; i < graph.length; i++) {
		for (int j = 0; j < graph[0].length; j++) {
			if (graph[i][j] == 1) {
				degreeOut[i]++;
				degreeIn[j]++;
			}
		}
	}
	
	for (int i = 0; i < graph.length; i++) {
		if (degreeOut[i] == 0 && degreeIn[i] == graph.length - 2) {
			return true;
		}
	}
	return false;
}
