/*
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.

  k ==> Number of floors
  n ==> Number of Eggs
  eggDrop(n, k) ==> Minimum number of trials needed to find the critical
                    floor in worst case.
  eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)): 
                 x in {1, 2, ..., k}}

Output:
Minimum number of trials in worst case with 2 eggs and 10 floors is 4
It should be noted that the above function computes the same subproblems again and again. See the following partial recursion tree, E(2, 2) is being evaluated twice. There will many repeated subproblems when you draw the complete recursion tree even for small values of n and k.


                         E(2,4)
                           |                      
          ------------------------------------- 
          |             |           |         |   
          |             |           |         |       
      x=1/\          x=2/\      x=3/ \    x=4/ \
        /  \           /  \       ....      ....
       /    \         /    \
 E(1,0)  E(2,3)     E(1,1)  E(2,2)
          /\  /\...         /  \
      x=1/  \               .....
        /    \
     E(1,0)  E(2,2)
            /   \
            ......

Partial recursion tree for 2 eggs and 4 floors.
Since same suproblems are called again, this problem has Overlapping Subprolems property. So Egg Dropping Puzzle has both properties (see this and this) of a dynamic programming problem. Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array eggFloor[][] in bottom up manner.

Dynamic Programming Solution
Following are C++ and Python implementations for Egg Dropping problem using Dynamic Programming.
*/
//A Dynamic Programming based Python Program for the Egg Dropping Puzzle
class EggDrop
{
    // A utility function to get maximum of two integers
    static int max(int a, int b) { return (a > b)? a: b; }
      
    /* Function to get minimum number of trials needed in worst
    case with n eggs and k floors */
    static int eggDrop(int n, int k)
    {
       /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n+1][k+1];
        int res;
        int i, j, x;
          
        // We need one trial for one floor and0 trials for 0 floors
        for (i = 1; i <= n; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }
          
       // We always need j trials for one egg and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;
          
        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++)
        {
            for (j = 2; j <= k; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                     res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                     if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
          
        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
 
    }
          
    /* Driver program to test to pront printDups*/
    public static void  main(String args[] )
    {
        int n = 2, k = 10;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                 " floors is "+eggDrop(n, k));   
    }
}
/*This code is contributed by Rajat Mishra*/
Run on IDE
Output:
Minimum number of trials in worst case with 2 eggs and 36 floors is 8
Time Complexity: O(nk^2)
Auxiliary Space: O(nk)

As an exercise, you may try modifying the above DP solution to print all intermediate floors (The floors used for minimum trial solution).
