/*
Next Greater Element
March 17, 2011
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12     -->     -1
*/
/* prints element and NGE pair for 
       all elements of arr[] of size n */
    public void printNGE(int arr[], int n) 
    {
        int i = 0;
        stack s = new stack();
        s.top = -1;
        int element, next;
 
        /* push the first element to stack */
        s.push(arr[0]);
 
        // iterate for rest of the elements
        for (i = 1; i < n; i++) 
        {
            next = arr[i];
 
            if (s.isEmpty() == false) 
            {
                 
                // if stack is not empty, then 
                // pop an element from stack
                element = s.pop();
 
                /* If the popped element is smaller than 
                   next, then a) print the pair b) keep 
                   popping while elements are smaller and 
                   stack is not empty */
                while (element < next) 
                {
                    System.out.println(element + " -- " + next);
                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }
 
                /* If element is greater than next, then 
                   push the element back */
                if (element > next)
                    s.push(element);
            }
 
            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }
 
        /* After iterating over the loop, the remaining 
           elements in stack do not have the next greater 
           element, so print -1 for them */
        while (s.isEmpty() == false) 
        {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }
 
    public static void main(String[] args) 
    {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
    }
}
