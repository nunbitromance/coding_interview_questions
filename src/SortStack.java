/* version 1 - sort stack in descending order with one extra stack
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

// version 2 - sort stack recursively without using extra space
// Java program to sort a Stack using recursion
// Note that here predefined Stack class is used
// for stack operation
 
import java.util.ListIterator;
import java.util.Stack;
 
class Test
{
    // Recursive Method to insert an item x in sorted way
    static void sortedInsert(Stack<Integer> s, int x)
    {
        // Base case: Either stack is empty or newly inserted
        // item is greater than top (more than all existing)
        if (s.isEmpty() || x > s.peek())
        {
            s.push(x);
            return;
        }
      
        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);
      
        // Put back the top item removed earlier
        s.push(temp);
    }
      
    // Method to sort stack
    static void sortStack(Stack<Integer> s)
    {
        // If stack is not empty
        if (!s.isEmpty())
        {
            // Remove the top item
            int x = s.pop();
      
            // Sort remaining stack
            sortStack(s);
      
            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }
     
    // Utility Method to print contents of stack
    static void printStack(Stack<Integer> s)
    {
       ListIterator<Integer> lt = s.listIterator();
        
       // forwarding
       while(lt.hasNext())
           lt.next();
        
       // printing from top to bottom
       while(lt.hasPrevious())
           System.out.print(lt.previous()+" ");
    }
   
    // Driver method 
    public static void main(String[] args) 
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
      
        System.out.println("Stack elements before sorting: ");
        printStack(s);
      
        sortStack(s);
      
        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);
      
    }
}
