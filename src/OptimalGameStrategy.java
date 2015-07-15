//http://n00tc0d3r.blogspot.com/2013/07/optimal-game-strategy-maximum-coin-value.html
//Maximum Coin Value
//Consider a row of n coins of values (v1, ..., vn), where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
//Note: The opponent is as clever as the user.
/*Let us understand the problem with few examples:

    8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)

Does choosing the best at each move give an optimal solution?

No. In the second example, this is how the game can finish:

1.
…….User chooses 8.
…….Opponent chooses 15.
…….User chooses 7.
…….Opponent chooses 3.
Total value collected by user is 15(8 + 7)

2.
…….User chooses 7.
…….Opponent chooses 8.
…….User chooses 15.
…….Opponent chooses 3.
Total value collected by user is 22(7 + 15)

*/

public int getMaxCoin(int[] coins) {  
   int n = coins.length;  
   int[][] maxCoin = new int[n][n];  
   
   // fill up the center diagomal  
   for (int i=0; i<n; ++i) {  
     maxCoin[i][i] = coins[i];  
   }  
   
   // fill up the table  
   for (int k=1; k<n; ++k) {  
     for (int i=0, j=k; i<n-k; ++i, ++j) {  
       int left = (i+2 <= j) ? maxCoin[i+2][j] : 0;  
       int bottom = (j-2 >= i) ? maxCoin[i][j-2] : 0;  
       maxCoin[i][j] = Math.max((coins[i] + Math.min(left, maxCoin[i+1][j-1])),  
                    (coins[j] + Math.min(maxCoin[i+1][j-1], bottom)));  
     }  
   }  
   
   return maxCoin[0][n-1];  
 }  
