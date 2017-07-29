/*
Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
*/

 public int climbStairs(int n) {  
   if (n <= 0) return 0;  
   if (n == 1 || n == 2) return n;  
   int[] ways = new int[n];  
   ways[0] = 1; ways[1] = 2;  
   for (int i=2; i<n; ++i) {  
     ways[i] = ways[i-1] + ways[i-2];  
   }  
   return ways[n-1];  
 }  

// without extra array
public int climbStairs(int n) {  
   if (n <= 0) return 0;  
   int p1 = 1, p2 = 1;  
   for (int i=2; i<=n; ++i) {  
     int temp = p2;  
     p2 += p1;  
     p1 = temp;  
   }  
   return p2;  
 }  

public int climbStairs(int n) {
   if (n <= 0) {
     return 0;
   }
   int i_1 = 1;
   int i_2 = 1;
   int i_0 = 2;
   for (int i = 3; i <= n; i++) {
    int temp = i_0;
    i_0 = i_1 + i_2;
    i_2 = i_1;
    i_1 = temp;
   }
   return i_0;
}
